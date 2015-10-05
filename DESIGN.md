#SLogo

##Members - Team 3

  * Nicholas Groszewski (nrg12)
  * Ankit Kayastha (ak308)
  * Daniel Song (dws20)
  * Tyler Webner (tlw37)



##Introduction
By writing this program we’re trying to solve the problem of properly taking in, parsing, and acting on commands given from a user and then displaying that output on the screen.  Where we want our program to be most flexible is in the addition of new commands, so we are going to use an abstract class that is extended by each individual command.  We also want the GUI to be flexible so it can take in new elements and add them to the GUI with ease.
At a high level, our program would be split up as follows: a GUI that displays the scene, with an input box for the commands, and some other option boxes to choose different parameters from.  The input string would be passed to a parser, which passes the command (after checking for errors) to the abstract command class.  The command would then be run, and the maps/classes that contain the information to be passed back to the GUI would be updated.  
The parts of the design of the program that are open to extension will be the commands and additional GUI elements.  The parts of the design that will be closed for modifications will be the parser, the abstract command class, and the actual setup of the GUI.  




## User Interface
The User Interface for this program will be fairly simple to start, and then we will see if more things have to be added. Essentially, it will include a main window where the Turtle will be displayed. This panel will also be the largest as it is the primary window and interaction for the program. Below the main window will be the command prompt area where the user will type in the commands to contro the Turtle. Within this command prompt area, there will be a text box where the user can type the commands in, and then there will be Run and Clear buttons. The Run button must be clicked to run the command, and the Clear button will clear the text the user was typing to allow the user to retype a command. To the right of the main turtle window, we have a series of Combo Boxes that will be used to control various items such as pen color, background color, the image for the turtle, and the language. This area will also contain the command history, variable history, and user-defined functions. These will of course be interactive to allow the user to choose a specific color and do other actions like click on a command history and load that command into the area where the commands are typed in. Above the main turtle screen will be an object that holds the title of our project. And finally, below that, we will have the HTML linked page that will serve as the "Help Page". For now, it will be linked to the webpage that lists all of the valid commands and what arguments they take in. One note to make is that we may explore using different options for the GUI like Menu Bars depending on how the implementation works. Some JavaFX objects may be easier to user and more user friendly so we will be exploring the different objects that can be used. 

The picture, or general outline, of the User Interface can be seen below.

![Image of GUI](https://github.com/duke-compsci308-fall2015/slogo_team03/blob/master/img/GUI.jpg)


In terms of the erroneous situations reported to the user, the GUI will most likely display some sort of dialog or warning box displaying what the error is. For instance, if the command the user types in is invalid, after the command is parsed and it has been determined that it is invalid, an exception will be thrown and the user will see a box that pops up displaying the error. Similar things will happen for incorrect arguments, and if the user tries to access variables or user defined commands that are not avaialble. 


##Design Details
###Front End - Front End API (Front-End Internal API)
The first API to cover is the internal API for the Front End of the program. This internal API is essentially responsible for any extensions that could be done in the future with respect to only the front end. Some of the methods/classes that will be public in this API will include a method for adding components to a Combo Box. This method could simply be called addToComboBox(), and its main functionality is to add another component to a Combo Box, given the name of the Combo Box and the item to add. Another method part of our API will be addToRoot(), which as the name indicates, will be used to add an object to the root. This can be any object, really, as long as it is meant to be displayed to the user. The next part of the API to cover is the reset method, which will be used to reset the GUI and turtle. Essentially, this will put the turtle back its original position (back at the origin), and will also reset the information to the initial default values. Then we have a method that will control the pop-up boxes, which will be used to convey errors to the user. These errors, as described above, could be due to invalid command, or improper references to variables or user defined commands. The initialize() method is used to initialize the stage/scene and the initial GUI to display to the user. Then, the render() method is also part of this API: this method is used to simply update the GUI. Note this is only updating the visual aspect of the project; the information for each turtle is being updated in the back-end of the program, but the render method is simply used to update the user interface based on that updated information. Finally, another part of the API that we will have is a method for adding another combo box, denoted as addComboBox(x, y, l, w, title). So, as the name suggests, this will simply be used to add another combo box to to the user interface. The addToRoot, addComboBox, and addToComboBox methods can be thought of as those that can be used for extension: the idea is that with these public methods, it will be fairly simple to add new nodes to the root, add new combo boxes, and add new components to a specific combo box. This API supports mainly the features of the GUI, such as creating the Combo Boxes, adding things to the root (which will be the main turtle display), and adding other components to the GUI in general. In terms of the resources it will use, this API will be heavily dependent on JavaFX objects and classes. It is inded to be used to add things to the user interface easily. 

###Front End - Back End API (Front End External API)
The primary purpose of this external API is to establish the communication that will occur between the Front-End and Back-End, specifically the flow of data from the Front-End to the Back-End. This API is relatively short because the Front-End does not need to pass much information to the Back-End besides the string representing the command that the user typed in as well as the language that the user has currently selected. This can be summarized into two public methods, passInput(String s), and passLanguage(String s). These methods, as the names indicate, will pass the inputted command as a string and the language, respectively. This is all the information the Back-End needs to update the information for the turtle and send it back to the Front-End. This API is to be used more for communication between the two parts of the project as opposed to accomplishing certain features. The resources this API will use include simply gathering the information from the text box where the user will type as well as gathering information from a combo box. We feel that these two are the only necessary parts of the API because the Back-End needs only a small amount of information to do its full job. It could be extended to include other methods if needed that are there to pass information to the Back-End. 

##API Example Code

*The user types 'fd 50' in the command window, and sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.*

After the user inputs the command into the input box and hits the “run” button, two things will occur.   First, the string that was input will be added to the top of the stack of commands that have been input by the updateCommandHistory(String s) method in the Command History class.  Then, the passInput(String s) method will be called (located in the User Interface class).  This method will pass the input to the parser, which will run the parse(String s) method (located in the Parser class) to parse the command.  Using reflection, the command that was input will be chosen (providing there wasn’t an error) and the command will be run using that specific command’s method (using the input parameters as the parameters).  Then, the method updateInfo() will be called (located in the AbstractCommand class) so that all of the maps and classes containing information (x and y coordinates,  pen down/up, visible/invisible, variables, user defined functions) can be updated.  Then the User Interface class’s method render() will update the display window with all of the new information that has been passed.  This flow of calls (and what class they can be found in) can be seen below:
1.	updateCommandHistory(String s)- Command History
2.	passInput(String s)- User Interface
3.	parse(String s)- Parser
4.	doCommand()- specific command class (from reflection)
5.	updateInfo()- Abstract Simulation
6.	render()- User Interface
