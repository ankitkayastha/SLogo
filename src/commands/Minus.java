package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Minus extends Command {
	public Minus(List<String> input) {
		super(input);
		parametersNeeded = 1;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			return myParameters[0] * -1;		
		}
		return Double.MIN_VALUE;
	}
}