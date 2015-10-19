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
	private Turtle copyTurtle;

	public Parser(UserDefinedCommands commands, UserDefinedVariables vars) {
		userDefinedCommands = commands;
		variables = vars;
		factory = new CommandFactory(userDefinedCommands);
		copyTurtle = new Turtle();
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
		// System.out.print("Command: " + commandName + ", InputList:");
		// for (int i = 0; i < inputList.size(); i++) {
		// System.out.print(" " + inputList.get(i));
		// }
		// System.out.println();

		Command command = factory.createCommand(commandName);
		if (command == null) {
			System.out.println(commandName + " command not found.");
			throw new CommandInputException();
		}

		String paramTypes = command.getParamCode();
		int paramsNeeded = paramTypes.length();
		for (int i = 0; i < paramsNeeded; i++) {
			setValidParameter(inputList, paramTypes.charAt(i), command, i);
		}
		command.setTurtle(currentTurtle);
		result = command.executeAndFormat();

		if (command instanceof To) {
			try {
				copyTurtle.setTurtle(currentTurtle);
				processInput(((SpecialCommand) command).getRunList());
			} catch (CommandInputException e) {
				// return 0;
			}
			currentTurtle.setTurtle(copyTurtle);
			userDefinedCommands.addCommand(((To) command).getUserCommand());
			return 1;
		} else if (command instanceof SpecialCommand && result == -1) {
			result = processInput(((SpecialCommand) command).getRunList());
		}
		return result;
	}

	public boolean setValidParameter(List<String> inputList, char inputType, Command command, int i)
			throws CommandInputException {
		if (inputList.size() == 0) {
			System.out.println("Empty inputList");
			throw new CommandInputException();
		}

		String current = inputList.remove(0);

		if (command.toString().equals("MakeUserInstruction") ) {
			System.out.print("Command: TO, ");
			System.out.print("Parameter: " + current + ", InputList:");
			for (int j = 0; j < inputList.size(); j++) {
				System.out.print(" " + inputList.get(j));
			}
			System.out.println();
		}

		if (inputType == '[') {
			return current.equals("[");
		} else if (inputType == ']') {
			return current.equals("]");
		} else if (inputType == 'v') {
			// System.out.println("CURRENT: " + current);
			if (isVariable(current)) {
				command.setVariable(current);
				return true;
			} else {
				return false;
			}
		} else if (inputType == 'c') {
			List<String> tempList = new ArrayList<String>();
			if (current.equals("]")) {
				inputList.add(0, current);
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
						// System.out.print("Command Definition:");
						// for (int z = 0; z < tempList.size(); z++) {
						// System.out.print(" " + tempList.get(z));
						// }
						// System.out.println();
						return true;
					}
				}
				if (inputList.size() == 0)
					return false;

				current = inputList.remove(0);
				// System.out.print("cParameter: " + current + ", InputList:");
				// for (int j = 0; j < inputList.size(); j++) {
				// System.out.print(" " + inputList.get(j));
				// }
				// System.out.println();
				//
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
				System.out.println("Calling createUserDefinedCommand(" + current + ")");
				((To) command).createUserDefinedCommand(current);
				return true;
			} else {
				System.out.println("CURRENT: " + current);
				throw new CommandInputException();
			}
		} else if (inputType == 'p') {
			if (current.equals("]")) {
				inputList.add(0, current);
				return true;
			}
			while (inputList.size() >= 0) {
				if (!isVariable(current)) {
					System.out.println("CURRENT: " + current);
					throw new CommandInputException();
				}
				command.addVariable(current);
				if (inputList.get(0).equals("]"))
					return true;
				if (inputList.size() == 0) {
					System.out.println("While getting parameters for UDC, reached end of list without ]");
					throw new CommandInputException();
				}
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
		return s.matches("[a-zA-Z_]+");
		// Need to check that its not already
		// a command
	}

	public void setTurtle(Turtle turtle) {
		currentTurtle = turtle;
	}
}