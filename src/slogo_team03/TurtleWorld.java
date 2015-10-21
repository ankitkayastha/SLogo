package slogo_team03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import commands.Command;

public class TurtleWorld implements ReceiveString, PassToFrontInterface {
	private Turtle turtle;
	private UserDefinedCommands userDefinedCommands;
	private UserDefinedVariables variables;
	private Parser parser;
	private TurtleMap turtles;

	public TurtleWorld() {
		userDefinedCommands = new UserDefinedCommands();
		variables = new UserDefinedVariables();
		parser = new Parser(userDefinedCommands, variables);
		turtle = new Turtle();
		turtles = new TurtleMap();
		turtles.addTurtle(turtle);
		Command.setMaps(userDefinedCommands, variables);
	}

	public void processInput(String input) throws CommandInputException {
		Command.setMaps(userDefinedCommands, variables);
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
		parser.setTurtle(turtle);
		parser.processInput(inputList);
		// System.out.println(parser.processInput(inputList));
		// System.out.println("Variables: " + variables.getVariableMap());
		// System.out.println("UserDefinedCommands: " +
		// userDefinedCommands.getCommandMap());
	}

	public double getAngle() {
		return turtle.absoluteAngleFrontend();
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