package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Or extends Command {
	public Or(List<String> input) {
		super(input);
		parametersNeeded = 2;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			if (myParameters[0] != 0 || myParameters[1] != 0) 
				return 1;
			else
				return 0;
		}
		return Double.MIN_VALUE;
	}
}