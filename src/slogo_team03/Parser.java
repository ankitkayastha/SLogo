package slogo_team03;

import java.util.ArrayList;
import java.util.List;

import commands.Command;
import commands.SetMultipleTurtlesCommand;
import commands.SpecialCommand;
import commands.To;
//import commands.TurtleCommand;
//import commands.UserCommand;
import newCommands.Ask;
import newCommands.MultipleTurtleCommand;
import newCommands.Tell;

public class Parser {
	private CommandFactory factory;
	private UserDefinedCommands userDefinedCommands;
	private UserDefinedVariables variables;
	private TurtleManager myTurtleManager;
	private Turtle currentTurtle;
	private Turtle copyOfTurtle;
	private boolean evaluating;

	public Parser(UserDefinedCommands commands, UserDefinedVariables vars, TurtleManager TW) {
		copyOfTurtle = new Turtle(0);
		userDefinedCommands = commands;
		variables = vars;
		myTurtleManager = TW;
		currentTurtle = myTurtleManager.firstTurtle();
		factory = new CommandFactory(userDefinedCommands);
		evaluating = false;
	}

	public double processInput(List<String> list) throws CommandInputException, MathException {
		double val = Double.MAX_VALUE;
		while (list.size() > 0) {
			val = runCommand(list);
		}
		return val;
	}

	public double runCommand(List<String> inputList) throws CommandInputException, MathException {
		String commandName = inputList.remove(0);
		Command command = factory.createCommand(commandName);
		return checkCommandAndEvaluate(inputList, commandName, command);
	}

	private double checkCommandAndEvaluate(List<String> inputList, String commandName, Command command)
			throws CommandInputException, MathException {
		double result = Double.MAX_VALUE;
//		System.out.println(commandName);   //FUCK
		if (command == null) {
			throw new CommandInputException(commandName);
		} else if (command instanceof MultipleTurtCommand) {
//			System.out.println("MULTIPLE TURTLE COMMAND");
			List<Turtle> turtleList = myTurtleManager.getActiveList();
			
			
			for (int i = 0; i < turtleList.size(); i++) {
//				System.out.println("Current " + turtleList.get(i).getID());
				currentTurtle = turtleList.get(i);
				List<String> copyOfInputList = new ArrayList<String>(inputList);
				result = evaluateCommand(inputList, command);
//				System.out.println(currentTurtle.getY());
				
//				System.out.println("X: " + currentTurtle.getX() + ", Y: " + currentTurtle.getY() + ", ID: " + currentTurtle.getID());
				
				
				
				inputList = new ArrayList<String>(copyOfInputList);
			}
		} else if (command instanceof Tell) {
//			System.out.println("Tell");
			result = evaluateCommand(inputList, command);
			myTurtleManager.setActiveList(((Tell) command).getTurtleList());
		} else if (command instanceof Ask) {
			result = evaluateCommand(inputList, command);
			myTurtleManager.setTemporaryList(((Ask) command).getTurtleList());

		} else {
//			System.out.println("else");
			result = evaluateCommand(inputList, command);
		}
		myTurtleManager.deleteTemporaryList();
		return result;
	}

	private double evaluateCommand(List<String> inputList, Command command)
			throws CommandInputException, MathException {
		double result = Double.MAX_VALUE;
		setParameters(inputList, command);
		command.setTurtle(currentTurtle);
		if (evaluating) {
			try {
				result = command.executeAndFormat();
			} catch (MathException e) {
				result = 0;
			}
		} else {
			result = command.executeAndFormat();
		}

		if (command instanceof MultipleTurtleCommand) {
			if (command instanceof Tell) {
//				myTurtleManager.setActiveList(((MultipleTurtleCommand) command).getTurtleList());
			} else {
				myTurtleManager.setTemporaryList(((MultipleTurtleCommand) command).getTurtleList());
			}
		}

		result = runExtraCommands(command, result);
		return result;
	}

	private double runExtraCommands(Command command, double result) throws MathException, CommandInputException {
		if (command instanceof To) {
			evaluating = true;
			List<String> runList = ((SpecialCommand) command).getRunList();
			while (!runList.isEmpty()) {
				try {
					copyOfTurtle.setTurtle(currentTurtle);
					processInput(((SpecialCommand) command).getRunList());
				} catch (CommandInputException e) {
					evaluating = false;
					return 0;
				}
			}

			currentTurtle.setTurtle(copyOfTurtle);
			userDefinedCommands.addCommand(((To) command).getUserCommand());
			evaluating = false;
			return 1;
		} else if (command instanceof SpecialCommand && result == -1) {
			result = processInput(((SpecialCommand) command).getRunList());
		}
		return result;
	}

	public void setParameters(List<String> inputList, Command command) throws CommandInputException, MathException {
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
			} else if (parameterType == 't') {
				if (current.equals("]")) {
					inputList.add(0, current);
					continue;
				}

				boolean succesfullyEndedTurtleList = false;
				while (inputList.size() > 0) {

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
					((SetMultipleTurtlesCommand) command).addTurtle(Integer.valueOf((int) value));
					if (inputList.get(0).equals("]")) {
						succesfullyEndedTurtleList = true;
						break;
					}
					if (inputList.size() == 0) {
						throw new CommandInputException("");
					}
					current = inputList.remove(0);
					
					
					
					

				}
				
				
				if (succesfullyEndedTurtleList) {
					continue;

				} else {
					throw new CommandInputException(current);
				}

				

			} else {
				throw new CommandInputException("");
			}
		}
	}

	public void processLanguage(String language) {
		factory.receiveLanguage(language);
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
}