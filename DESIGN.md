###Introduction
By writing this program we’re trying to solve the problem of properly taking in, parsing, and acting on commands given from a user and then displaying that output on the screen.  Where we want our program to be most flexible is in the addition of new commands, so we are going to use an abstract class that is extended by each individual command.  We also want the GUI to be flexible so it can take in new elements and add them to the GUI with ease.
At a high level, our program would be split up as follows: a GUI that displays the scene, with an input box for the commands, and some other option boxes to choose different parameters from.  The input string would be passed to a parser, which passes the command (after checking for errors) to the abstract command class.  The command would then be run, and the maps/classes that contain the information to be passed back to the GUI would be updated.  
The parts of the design of the program that are open to extension will be the commands and additional GUI elements.  The parts of the design that will be closed for modifications will be the parser, the abstract command class, and the actual setup of the GUI.  




### User Interface

The User Interface for this program will be fairly simple to start, and then we will see if more things have to be added. Essentially, it will include a main window where the Turtle will be displayed. This panel will also be the largest as it is the primary window and interaction for the program. Below the main window will be the command prompt area where the user will type in the commands to contro the Turtle. Within this command prompt area, there will be a text box where the user can type the commands in, and then there will be Run and Clear buttons. The Run button must be clicked to run the command, and the Clear button will clear the text the user was typing to allow the user to retype a command. To the right of the main turtle window, we have a series of Combo Boxes that will be used to control various items such as pen color, background color, the image for the turtle, and the language. This area will also contain the command history, variable history, and user-defined functions. These will of course be interactive to allow the user to choose a specific color and do other actions like click on a command history and load that command into the area where the commands are typed in. Above the main turtle screen will be an object that holds the title of our project. And finally, below that, we will have the HTML linked page that will serve as the "Help Page". For now, it will be linked to the webpage that lists all of the valid commands and what arguments they take in. 

The picture, or general outline, of the User Interface can be seen below.

![Image of GUI](https://github.com/duke-compsci308-fall2015/slogo_team03/blob/master/img/GUI.jpg)


In terms of the erroneous situations reported to the user, the GUI will most likely display some sort of dialog or warning box displaying what the error is. For instance, if the command the user types in is invalid, after the command is parsed and it has been determined that it is invalid, an exception will be thrown and the user will see a box that pops up displaying the error. Similar things will happen for incorrect arguments, and if the user tries to access variables or user defined commands that are not avaialble. 
