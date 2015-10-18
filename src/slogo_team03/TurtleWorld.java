package slogo_team03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.Command;

public class TurtleWorld implements ReceiveString, PassToFrontInterface {
	private Turtle turtle;
	private Parser parser;
	private UserDefinedCommands userDefinedCommands;
	private UserDefinedVariables variables;
	private TurtleMap turtles;

	public TurtleWorld() {
		turtle = new Turtle();
		parser = new Parser();
		userDefinedCommands = new UserDefinedCommands();
		variables = new UserDefinedVariables();
		turtles = new TurtleMap();
		turtles.addTurtle(turtle);
		Command.setMaps(userDefinedCommands, variables);
	}

	public void processInput(String input) throws CommandInputException {
		String[] inputArray = input.trim().split("\\s+");
		List<String> inputList = new ArrayList<String>(Arrays.asList(inputArray));
		setParser();
		try {
			parser.processInput(inputList);
//			 System.out.println(parser.processInput(inputList));
			parser.processInput(inputList);
		} catch (CommandInputException e) {
			System.out.println("Invalid Input!");
			return;
		}
	}

	public double getAngle() {
		return turtle.angleToRotate();
	}

	private void setParser() {
		parser.setTurtle(turtle);
		parser.setUserDefinedCommands(userDefinedCommands);
		parser.setVariables(variables);
	}

	public Turtle getTurtle() {
		return turtle;
	}

	@Override
	public void receiveCommand(String s) throws CommandInputException {
		processInput(s);
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
	public Map<String, String> getUserDefinedCommands() {
		// TODO Auto-generated method stub
		return null;
	}
}