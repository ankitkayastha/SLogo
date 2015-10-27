package slogo_team03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import commands.Command;
import commands.UserCommand;
import javafx.scene.paint.Color;


public class TurtleWorld implements ReceiveFromFront, PassToFrontInterface, FileInterface, StampInterface, IPenUpDown {
	private Turtle turtle;
	private UserDefinedCommands userDefinedCommands;
	private UserDefinedVariables variables;
	private Parser parser;
//	private TurtleMap turtles;
	private TurtleManager turtleManager;
	private XmlWriter xmlWriter;
	private XmlReader xmlReader;
	private String myInput;
	private Pen myPen;

	public TurtleWorld() {
		turtleManager = new TurtleManager();
		userDefinedCommands = new UserDefinedCommands();
		variables = new UserDefinedVariables();
		parser = new Parser(userDefinedCommands, variables, turtleManager);
		turtle = new Turtle();
		myPen = new Pen();
		Turtle.setPen(myPen);
//		turtles = new TurtleMap();
//		turtles.addTurtle(turtle);
		Command.setMapsAndPen(userDefinedCommands, variables, myPen);
		xmlWriter = new XmlWriter();
		xmlReader = new XmlReader(variables, userDefinedCommands);
		myInput = "";
	}

	public void interpretInput(List<String> inputList) throws CommandInputException, MathException {
		Command.setMapsAndPen(userDefinedCommands, variables, myPen);
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

	public Turtle getTurtle() {
		return turtleManager.firstTurtle();
	}

	@Override
	public void receiveCommand(String input) throws CommandInputException, MathException {
		myInput = input;
		interpretInput(removeCommentsAndWhitespace(input));
	}

	@Override
	public void receiveLanguage(String language) {
		parser.processLanguage(language);
		xmlWriter.receiveLanguage(language);
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
		return myPen.getBackgroundColor();
	}

	@Override
	public Map<Double, Color> getPalette() {
		return myPen.getPalette();
	}
	
	public void readXmlFile(String path) {
		xmlReader.readLibraryFile(path);
	}
	
	public void writeXmlFile(String path) {
		xmlWriter.receiveVariablesAndCommands(variables, userDefinedCommands);
		xmlWriter.writeLibraryFile(path);
	}

	@Override
	public List<Stamp> getStampList() {
		return myPen.getStampList();
	}

	@Override
	public boolean isPenDown() {
		return myPen.isPenDown();
	}
}