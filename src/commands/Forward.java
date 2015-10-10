package commands;
import java.util.List;

public class Forward extends Command {
	public Forward(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			double length = myParameters[0];
			double x0 = myTurtle.getX();
			double y0 = myTurtle.getY();
			double angle = myTurtle.getAngle();
			
			double x1 = x0 + length * Math.cos(Math.toRadians(angle));
			double y1 = y0 + length * Math.sin(Math.toRadians(angle));
			
			myTurtle.setX(x1);
			myTurtle.setY(y1);
			myTurtle.addPoint(x1, y1);
			
			return length;		
		}
		return Double.MIN_VALUE;
	}
}