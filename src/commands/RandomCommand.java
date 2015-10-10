package commands;
import java.util.List;
import java.util.Random;

import slogo_team03.CommandErrorChecker;

public class RandomCommand extends Command {
	public RandomCommand(List<String> input) {
		super(input);
		parametersNeeded = 1;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			Random generator = new Random();
			return Math.abs(myParameters[0] * generator.nextDouble());		
		}
		return Double.MIN_VALUE;
	}
}