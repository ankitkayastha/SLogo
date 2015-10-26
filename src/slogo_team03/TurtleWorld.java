package slogo_team03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.Command;
import commands.UserCommand;
import javafx.scene.paint.Color;


public class TurtleWorld implements ReceiveFromFront, PassToFrontInterface, FileInterface {
	private Turtle turtle;
	private UserDefinedCommands userDefinedCommands;
	private UserDefinedVariables variables;
	private Parser parser;
	private TurtleMap turtles;
	private TurtleManager turtleManager;
	private XmlWriter xmlWriter;
	private XmlReader xmlReader;
	private String myInput;

	public TurtleWorld() {
		turtleManager = new TurtleManager();
		userDefinedCommands = new UserDefinedCommands();
		variables = new UserDefinedVariables();
		parser = new Parser(userDefinedCommands, variables, turtleManager);
		turtle = new Turtle();
		turtles = new TurtleMap();
		turtles.addTurtle(turtle);
		Command.setMaps(userDefinedCommands, variables);
		xmlWriter = new XmlWriter(userDefinedCommands, variables);
		xmlReader = new XmlReader(variables, userDefinedCommands);
		myInput = "";
	}

	public void interpretInput(List<String> inputList) throws CommandInputException, TrigonometricException {
		Command.setMaps(userDefinedCommands, variables);
		parser.processInput(inputList);
	}

	private List<String> removeCommentsAndWhitespace(String input) {
		String processedInput = "";
		for (int i = 0; i + 1 <= input.length(); i++) {
			if (input.substring(i, i + 1).equals("#")) {
				i++;
				while (i + 1 < input.length() && !input.substring(i, i + 1).equals("\n")) {
					i++;
				}
			} else {
				processedInput += input.substring(i, i + 1);
			}
		}
		String[] inputArray = processedInput.trim().split("\\s+");
		List<String> inputList = new ArrayList<String>(Arrays.asList(inputArray));
		return inputList;
	}

	public double getAngle() {
		return turtle.absoluteAngleFrontend();
	}

	public Turtle getTurtle() {
		return turtleManager.firstTurtle();
	}

	@Override
	public void receiveCommand(String input) throws CommandInputException, TrigonometricException {
		myInput = input;
		interpretInput(removeCommentsAndWhitespace(input));
	}

	@Override
	public void receiveLanguage(String language) {
		parser.processLanguage(language);		
	}

	@Override
	public Map<String, Double> getVariableMap() {
		return variables.getVariableMap();
	}

	@Override
	public String getLastCommand() {
		return myInput;
	}

	@Override
	public Map<String, UserCommand> getUserDefinedCommands() {
		return userDefinedCommands.getCommandMap();
	}

	@Override
	public Color getUpdatedBackgroundColor() {
		return turtle.getBackgroundColor();
	}

	@Override
	public Map<Double, Color> getPalette() {
		return turtle.getPen().getPalette();
	}

	
	public void readXmlFile(String path) {
		xmlReader.readFile(path);
	}
	
	public void writeXmlFile(String path) {
		xmlWriter.writeXmlFile(path);
	}
}