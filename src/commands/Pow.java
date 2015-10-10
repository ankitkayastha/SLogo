package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Pow extends Command {
	public Pow(List<String> input) {
		super(input);
		parametersNeeded = 2;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			return Math.pow(myParameters[0], myParameters[1]);
		}
		return Double.MIN_VALUE;
	}
}