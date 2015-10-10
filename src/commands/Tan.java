package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Tan extends Command {
	public Tan(List<String> input) {
		super(input);
		parametersNeeded = 1;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			return Math.tan(Math.toRadians(myParameters[0]));
		}
		return Double.MIN_VALUE;
	}
}