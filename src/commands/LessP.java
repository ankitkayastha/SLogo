package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class LessP extends Command {
	public LessP(List<String> input) {
		super(input);
		parametersNeeded = 2;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			if (myParameters[0] < myParameters[1]) 
				return 1;
			else
				return 0;
		}
		return Double.MIN_VALUE;
	}
}