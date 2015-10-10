package slogo_team03;

import java.util.List;

public class CommandErrorChecker {
	private int parametersNeededByCommand;
	private List<String> restOfCommandInput;
	private CommandFactory commandFactory;


	public CommandErrorChecker(int parametersNeeded, List<String> restOfInput, CommandFactory factory) {
		parametersNeededByCommand = parametersNeeded;
		restOfCommandInput = restOfInput;
		commandFactory = factory;
	}

	private boolean enoughParameters() {
		return (restOfCommandInput.size() >= parametersNeededByCommand);
	}

	private String nextParameter(int i) {
		return restOfCommandInput.get(i);
	}

	private boolean isNumeric(String s) {  
		return s.matches("[-+]?\\d*\\.?\\d+");  
	}

	private boolean isCommand(String s) {
		return (!isNumeric(s));
	}

	private boolean isValidCommand(String command) {
		return commandFactory.isValidCommand(command);
	}

	public boolean areParametersValid() {
		//Check if we have enough parameters left
		if (!enoughParameters()) {
			System.out.println("You did not input the correct number of parameters.");
			return false;
		}

		//Check validity of individual parameters
		for (int i = 0; i < parametersNeededByCommand; i++) {
			if (isCommand(nextParameter(i))) {
				return (isValidCommand(nextParameter(i)));
			}
		}

		return true;
	}
}
