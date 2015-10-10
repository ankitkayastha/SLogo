import java.util.List;

public class SetXY extends Command {
	public SetXY(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			double x0 = myTurtle.getX();
			double y0 = myTurtle.getY();
			double x1 = myParameters[0];
			double y1 = myParameters[1];

			myTurtle.setX(x1);
			myTurtle.setY(y1);
			
			return Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2));
		}
		return Double.MIN_VALUE;
	}
}