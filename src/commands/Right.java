package commands;
import java.util.List;

public class Right extends Command {
	public Right(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			double angle = myTurtle.getAngle();
			angle -= myParameters[0];
			myTurtle.setAngle(angle%360);
			return myParameters[0];
		}
		return Double.MIN_VALUE;
	}
}