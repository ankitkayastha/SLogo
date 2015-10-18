package slogo_team03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import commands.Command;
import commands.SpecialCommand;

public class Parser {
	private CommandFactory factory;
	private UserDefinedCommands userDefinedCommands;
	private UserDefinedVariables variables;
	private Turtle currentTurtle;

	public Parser() {
		factory = new CommandFactory();
	}

	public double processInput(List<String> list) throws CommandInputException {
		double val = Double.MAX_VALUE;
		while (list.size() > 0) {
			val = evaluateCommands(list);	
		}
		return val;
	}
	
	public void processLanguage(String language) {
		factory.receiveLanguage(language);
	}

	public double evaluateCommands(List<String> inputList) throws CommandInputException {
		double result = Double.MAX_VALUE;
		String commandName = inputList.remove(0);

//		if (userDefinedCommands.containsKey(commandName)) {
//			inputList.addAll(0, userDefinedCommands.get(commandName));
//			commandName = inputList.remove(0);
//		}

		Command command = factory.createCommand(commandName);
		if (command == null) {
			throw new CommandInputException();
		}

		String paramTypes = command.getParamCode();
		int paramsNeeded = paramTypes.length();
		for (int i = 0; i < paramsNeeded; i++) {
			setValidParameter(inputList, paramTypes.charAt(i), command, i);
		}
		command.setTurtle(currentTurtle);
		result = command.format();

		if (command instanceof SpecialCommand) {
			result = processInput(((SpecialCommand) command).getRunList());
		}
		return result;
	}

	public boolean setValidParameter(List<String> inputList, char inputType, Command command, int i)
			throws CommandInputException {
		if (inputList.size() == 0) {
			throw new CommandInputException();
		}

		String current = inputList.remove(0);

		if (inputType == '[') {
			return current.equals("[");
		} else if (inputType == ']') {
			return current.equals("]");
		} else if (inputType == 'v') {
			if (isVariable(current)) {
				command.setVariable(current);
				return true;
			} else {
				return false;
			}
		} else if (inputType == 'c') {
			List<String> tempList = new ArrayList<String>();
			if (current.equals("]")) {
				return false;
			}

			while (inputList.size() >= 0) {
				tempList.add(current);
				if (inputList.get(0).equals("]")) {
					command.addListOfCommands(tempList);
					return true;
				}
				if (inputList.size() == 0)
					return false;
				current = inputList.remove(0);
			}
			return false;
		} else if (inputType == 'e') {
			if (isNumeric(current)) {
				command.setParameter(i, Double.parseDouble(current));
				return true;
			} else if (isVariable(current)) {
				command.setParameter(i, variables.getVariable(current));
				return true;
			} else {
				inputList.add(0, current);

				double value = evaluateCommands(inputList);

				if (value != Double.MAX_VALUE) {
					command.setParameter(i, value);
					return true;
				}
				return false;
			}
		} else if (inputType == 'n') {
			return isCommandName(current);
		} else if (inputType == 'p') {
			List<String> tempList = new ArrayList<String>();
			if (current.equals("]")) {
				return false;
			}
			while (inputList.size() >= 0) {
				if (!isVariable(current)) {
					throw new CommandInputException();
				}
				tempList.add(current);
				if (inputList.get(0).equals("]")) {		// Add remove
					command.addListOfCommands(tempList);
					return true;
				}
				if (inputList.size() == 0)
					throw new CommandInputException();
				current = inputList.remove(0);
			}
			return false;
		
		} else {
			return false;
		}
	}

	public boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}

	public boolean isVariable(String s) {
		return s.matches(":[a-zA-Z_]+");
	}

	public boolean isCommandName(String s) {
		if (!s.matches("[a-zA-Z_]+")) {
			return false;
		}
		Command command = factory.createCommand(s);
		return command == null;
	}

	public void setUserDefinedCommands(UserDefinedCommands commands) {
		userDefinedCommands = commands;
	}

	public void setVariables(UserDefinedVariables vars) {
		variables = vars;
	}

	public void setTurtle(Turtle turtle) {
		currentTurtle = turtle;
	}
}