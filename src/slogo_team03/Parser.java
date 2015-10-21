package slogo_team03;

import java.util.ArrayList;
import java.util.List;

import commands.Command;
import commands.SpecialCommand;
import commands.To;
import commands.TurtleCommand;
import commands.UserCommand;

public class Parser {
	private CommandFactory factory;
	private UserDefinedCommands userDefinedCommands;
	private UserDefinedVariables variables;
	private Turtle currentTurtle;
	private Turtle copyTurtle;
	private List<Turtle> turtleList;
	private boolean evaluating;

	public Parser(UserDefinedCommands commands, UserDefinedVariables vars) {
		userDefinedCommands = commands;
		variables = vars;
		factory = new CommandFactory(userDefinedCommands);
		copyTurtle = new Turtle();
		turtleList = new ArrayList<Turtle>();
		evaluating = false;
	}

	public double processInput(List<String> list) throws CommandInputException, TrigonometricException {
		double val = Double.MAX_VALUE;
		while (list.size() > 0) {
			val = runCommand(list);
		}
		return val;
	}

	public void processLanguage(String language) {
		factory.receiveLanguage(language);
	}

	public double runCommand(List<String> inputList) throws CommandInputException, TrigonometricException {
		double result = Double.MAX_VALUE;
		String commandName = inputList.remove(0);

		Command command = factory.createCommand(commandName);
		if (command == null) {
			throw new CommandInputException(commandName);
		}

		if (command instanceof TurtleCommand) {
			for (int i = 0; i < turtleList.size(); i++) {
				setTurtle(turtleList.get(i));
				List<String> copyOfInputList = new ArrayList<String>(inputList);
				result = evaluateCommand(inputList, command);
				inputList = new ArrayList<String>(copyOfInputList);
			}
		} else {
			result = evaluateCommand(inputList, command);
		}
		return result;
	}

	private double evaluateCommand(List<String> inputList, Command command)
			throws CommandInputException, TrigonometricException {
		double result = Double.MAX_VALUE;
		setParameters(inputList, command);
		command.setTurtle(currentTurtle);

		if (evaluating) {
			try {
				result = command.executeAndFormat();
			} catch (TrigonometricException e) {
				result = 1;
			} catch (ArithmeticException e) {
				result = 1;
			}
		} else {
			result = command.executeAndFormat();
		}

		if (command instanceof To) {
			evaluating = true;
			// Add while loop and catch dividebyzeroexceptions, not
			// commandinputexceptions

			List<String> runList = ((SpecialCommand) command).getRunList();
			while (!runList.isEmpty()) {
				try {
					copyTurtle.setTurtle(currentTurtle);
					processInput(((SpecialCommand) command).getRunList());
				} catch (CommandInputException e) {
					evaluating = false;
					return 0;
				}
			}

			currentTurtle.setTurtle(copyTurtle);
			userDefinedCommands.addCommand(((To) command).getUserCommand());
			evaluating = false;
			return 1;
		} else if (command instanceof SpecialCommand && result == -1) {
			result = processInput(((SpecialCommand) command).getRunList());
		}
		return result;
	}

	public void setParameters(List<String> inputList, Command command)
			throws CommandInputException, TrigonometricException {
		String parameterCode = command.getParameterCode();
		for (int i = 0; i < parameterCode.length(); i++) {
			if (inputList.size() == 0) {
				throw new CommandInputException("");
			}
			String current = inputList.remove(0);
			char parameterType = parameterCode.charAt(i);
			if (parameterType == '[') {
				if (current.equals("[")) {
					continue;
				} else {
					throw new CommandInputException(current);
				}
			} else if (parameterType == ']') {
				if (current.equals("]")) {
					continue;
				} else {
					throw new CommandInputException(current);
				}
			} else if (parameterType == 'v') {
				if (isVariable(current)) {
					command.addVariable(current);
					continue;
				} else {
					throw new CommandInputException(current);
				}
			} else if (parameterType == 'c') {
				List<String> tempList = new ArrayList<String>();
				if (current.equals("]")) {
					inputList.add(0, current);
					continue;
				}

				int leftCount = 1;
				boolean succesfullyEndedCommandList = false;
				while (inputList.size() >= 0) {
					tempList.add(current);
					if (inputList.get(0).equals("[")) {
						leftCount++;
					}
					if (inputList.get(0).equals("]")) {
						leftCount--;
						if (leftCount == 0) {
							command.addListOfCommands(tempList);
							succesfullyEndedCommandList = true;
							break;
						}
					}
					if (inputList.size() == 0) {
						throw new CommandInputException("");
					}

					current = inputList.remove(0);
				}
				if (succesfullyEndedCommandList) {
					continue;
				} else {
					throw new CommandInputException(current);
				}
			} else if (parameterType == 'e' || parameterType == 'i') {
				double value;
				if (isNumeric(current)) {
					value = Double.parseDouble(current);
				} else if (isVariable(current)) {
					if (variables.getVariableMap().containsKey(current)) {
						value = variables.getVariable(current);
					} else {
						variables.addVariable(current, 0);
						value = 0;
					}
				} else {
					inputList.add(0, current);
					value = runCommand(inputList);
				}
				if (parameterType == 'i' && !isInteger(value)) {
					throw new CommandInputException(current);
				}
				command.addParameter(value);
			} else if (parameterType == 'n') {
				if (isCommandName(current)) {
					((To) command).createUserDefinedCommand(current);
					continue;
				} else {
					throw new CommandInputException(current);
				}
			} else if (parameterType == 'p') {
				if (current.equals("]")) {
					inputList.add(0, current);
					continue;
				}
				boolean succesfullyEndedParamList = false;
				while (inputList.size() >= 0) {
					if (!isVariable(current)) {
						throw new CommandInputException(current);
					}
					command.addVariable(current);
					if (inputList.get(0).equals("]")) {
						succesfullyEndedParamList = true;
						break;
					}
					if (inputList.size() == 0) {
						throw new CommandInputException("");
					}
					current = inputList.remove(0);
				}
				if (succesfullyEndedParamList) {
					continue;
				} else {
					throw new CommandInputException(current);
				}
			} else {
				throw new CommandInputException("");
			}
		}
	}

	private boolean isInteger(double d) {
		return d == Math.floor(d);
	}

	public boolean isNumeric(String s) {
		return s.matches("[-+]?\\d*\\.?\\d+");
	}

	public boolean isVariable(String s) {
		return s.matches(":[a-zA-Z_]+");
	}

	public boolean isCommandName(String s) {
		Command command = factory.createCommand(s);
		if (command != null && !userDefinedCommands.containsKey(s)) {
			return false;
		}
		return s.matches("[a-zA-Z_]+");
	}

	public void setTurtle(Turtle turtle) {
		currentTurtle = turtle;
	}
}