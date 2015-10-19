package slogo_team03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
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
		setParser();
//		try {
//			parser.processInput(inputList);
//			// System.out.println(parser.processInput(inputList));
//			parser.processInput(inputList);
//		} catch (CommandInputException e) {
//			System.out.println("Invalid Input!");
//			return;
//		}
		parser.processInput(inputList);
	}

	public double getAngle() {
		return turtle.absoluteAngleFrontend();
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
		return null;
	}
}