package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class Left extends Command {
	public Left(List<String> input) {
		super(input);
		parametersNeeded = 1;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			double angle = myTurtle.getAngle();
			angle += myParameters[0];
			myTurtle.setAngle(angle%360);
			return myParameters[0];
		}
		return Double.MIN_VALUE;
	}
}