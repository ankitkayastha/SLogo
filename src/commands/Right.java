package commands;

public class Right extends Command {
	public Right() {
		parameterCode = "e";
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();
		double endAngle = startAngle - myParameters[0];
		myTurtle.setAngle(endAngle % 360);
		return myParameters[0];
	}
}