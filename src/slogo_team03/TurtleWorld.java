package slogo_team03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import commands.Command;
import commands.UserCommand;

public class TurtleWorld implements ReceiveFromFront, PassToFrontInterface {
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

	public void interpretInput(List<String> inputList) throws CommandInputException, TrigonometricException {
		Command.setMaps(userDefinedCommands, variables);
		parser.setTurtle(turtle); // Should this be here?
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
		return turtle;
	}

	@Override
	public void receiveCommand(String input) throws CommandInputException, TrigonometricException {
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
	public Map<String, UserCommand> getUserDefinedCommands() {
		return userDefinedCommands.getCommandMap();
	}

	@Override
	public String getLastCommand() {
		// TODO Auto-generated method stub
		return null;
	}

}