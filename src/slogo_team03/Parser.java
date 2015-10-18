package slogo_team03;

import java.util.ArrayList;
import java.util.List;

import commands.Command;
import commands.SpecialCommand;
import commands.To;
import commands.UserCommand;

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
		for (int i = 0; i < list.size(); i++) {

		}
		while (list.size() > 0) {
			val = evaluateCommands(list);
			// System.out.println(val);
		}
		return val;
	}

	public void processLanguage(String language) {
		factory.receiveLanguage(language);
	}

	public double evaluateCommands(List<String> inputList) throws CommandInputException {
		double result = Double.MAX_VALUE;
		String commandName = inputList.remove(0);
		// System.out.print("Command: " + commandName + ", InputList:");
		// for (int i = 0; i < inputList.size(); i++) {
		// System.out.print(" " + inputList.get(i));
		// }
		// System.out.println();

		// System.out.println(commandName);

		// if (commandName.length() == 0) {
		//// System.out.println("White space");
		// return 0;
		// }

		// if (userDefinedCommands.containsKey(commandName)) {
		// inputList.addAll(0, userDefinedCommands.get(commandName));
		// commandName = inputList.remove(0);
		// }

		Command command = factory.createCommand(commandName);
		if (command == null) {
			throw new CommandInputException();
		}

		String paramTypes = command.getParamCode();
		int paramsNeeded = paramTypes.length();
		for (int i = 0; i < paramsNeeded; i++) {
			// System.out.println(paramTypes.charAt(i));
			setValidParameter(inputList, paramTypes.charAt(i), command, i);
		}
		command.setTurtle(currentTurtle);
		result = command.executeAndFormat();

		// if (command instanceof UserCommand) {
		// result = processInput(((UserCommand) command).getDefinition());
		// }

		if (command instanceof SpecialCommand) {
			// System.out.print("RunList: ");
			// List<String> myRunList = new ArrayList<String>(((SpecialCommand)
			// command).getRunList());
			// for (int i = 0; i < myRunList.size(); i++) {
			// System.out.print(" " + myRunList.get(i));
			// }
			// System.out.println();
		}

		if (command instanceof To) {
			try {
				processInput(((SpecialCommand) command).getRunList());
			} catch (CommandInputException e) {
				return 0;
			}
			return 1;
		} else if (command instanceof SpecialCommand) { // result == -1 NEED TO
														// CHANGE THIS
			result = processInput(((SpecialCommand) command).getRunList());
			// System.out.println(((SpecialCommand) command).getRunList());
		}
		return result;
	}

	public boolean setValidParameter(List<String> inputList, char inputType, Command command, int i)
			throws CommandInputException {
		if (inputList.size() == 0) {
			throw new CommandInputException();
		}

		String current = inputList.remove(0);

		// System.out.print("Parameter: " + current + ", InputList:");
		// for (int j = 0; j < inputList.size(); j++) {
		// System.out.print(" " + inputList.get(j));
		// }
		// System.out.println();

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

			int leftCount = 1;

			while (inputList.size() >= 0) {
				tempList.add(current);
				if (inputList.get(0).equals("[")) {
					leftCount++;
				}
				if (inputList.get(0).equals("]")) {
					leftCount--;
					if (leftCount == 0) {
						command.addListOfCommands(tempList);
						return true;
					}
				}
				if (inputList.size() == 0)
					return false;

				current = inputList.remove(0);
				// System.out.print("Parameter: " + current + ", InputList:");
				// for (int j = 0; j < inputList.size(); j++) {
				// System.out.print(" " + inputList.get(j));
				// }
				// System.out.println();

				// System.out.println("Command: " + command + ", Param: " +
				// current);

			}
			return false;
		} else if (inputType == 'e') {
			if (isNumeric(current)) {
				command.setParameter(i, Double.parseDouble(current));
				return true;
			} else if (isVariable(current)) {
				if (variables.getVariableMap().containsKey(current)) {
					command.setParameter(i, variables.getVariable(current));
				} else {
					variables.addVariable(current, 0);
					command.setParameter(i, 0);
				}
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
			if (isCommandName(current)) {
				((To) command).createUserDefinedCommand(current);
				return true;
			} else {
				throw new CommandInputException();
			}
		} else if (inputType == 'p') {
			List<String> tempList = new ArrayList<String>();
			if (current.equals("]")) {
				return true;
			}
			while (inputList.size() >= 0) {
				if (!isVariable(current)) {
					throw new CommandInputException();
				}
				tempList.add(current);
				if (inputList.get(0).equals("]")) {
					command.addVariable(current);
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