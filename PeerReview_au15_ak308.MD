Written by: Abhishek Upadhyaya Ghimire (au15)
About: Ankit Kayastha (ak308)

Ankit's slogo code for CommandPrompt class uses resource file, which is good as all the constants are declared in that resource file. However, to make the class specific to certain function, it would be better if he can ave separate classes for Button and Textfield. He could use CommandPrompt class only to call those button and textfield related classes and link it to the root rather than creating the textfield and the button in the same class.