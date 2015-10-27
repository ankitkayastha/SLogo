package commands;

public class Right extends MultipleTurtleCommand {
	public Right() {
		super();
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();
		double endAngle = startAngle - myParameters.get(0);
		myTurtle.setAngle(endAngle % 360);
		return myParameters.get(0);
	}

	@Override
	public String toString() {
		return "Right";
	}
}