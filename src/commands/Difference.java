package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Difference extends Command {
	public Difference(List<String> input) {
		super(input);
		parametersNeeded = 2;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			return myParameters[0] - myParameters[1];		
		}
		return Double.MIN_VALUE;
	}
}