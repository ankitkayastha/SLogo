package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Remainder extends Command {
	public Remainder(List<String> input) {
		super(input);
		parametersNeeded = 2;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			if (myParameters[0] < myParameters[1])
				return myParameters[1];
			else
				return myParameters[0] % myParameters[1];		
		}
		return Double.MIN_VALUE;
	}
}