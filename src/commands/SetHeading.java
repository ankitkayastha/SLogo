package commands;
import java.util.List;

public class SetHeading extends Command {
	public SetHeading(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
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