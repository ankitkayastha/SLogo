import java.util.List;

public class Towards extends Command {
	public Towards(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			double oldAngle = myTurtle.getAngle();
			double newAngle;	//Not correct
			
			double x0 = myTurtle.getX();
			double y0 = myTurtle.getY();
			double x1 = myParameters[0];
			double y1 = myParameters[1];
			
			//Need to calculate newAngle
			
			
			
			double difference = Math.abs(oldAngle - newAngle);
			if (difference > 180) {
				return 360 - difference;
			}
			return difference;
		}
		return Double.MIN_VALUE;
	}
}