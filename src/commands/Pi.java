package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Pi extends Command {
	public Pi(List<String> input) {
		super(input);
		parametersNeeded = 0;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			return Math.PI;
		}
		return Double.MIN_VALUE;
	}
}