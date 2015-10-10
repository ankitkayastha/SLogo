package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Quotient extends Command {
	public Quotient(List<String> input) {
		super(input);
		parametersNeeded = 2;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			return (int) (myParameters[0] / myParameters[1]);		
		}
		return Double.MIN_VALUE;
	}
}