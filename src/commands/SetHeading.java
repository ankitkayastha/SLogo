package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;

public class SetHeading extends Command {
	public SetHeading(List<String> input) {
		super(input);
		parametersNeeded = 1;
		myErrorChecker = new CommandErrorChecker(parametersNeeded, restOfInput, factory);
	}
	
	public double execute() {
		if (checkAndPutParameters()) {
			double oldAngle = myTurtle.getAngle();
			double newAngle = 450 - myParameters[0];
			newAngle = newAngle % 360;
			myTurtle.setAngle(newAngle);
			
			double difference = Math.abs(oldAngle - newAngle);
			if (difference > 180) {
				return 360 - difference;
			}
			return difference;
		}
		return Double.MIN_VALUE;
	}
}