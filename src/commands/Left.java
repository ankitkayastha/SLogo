package commands;
public class Left extends Command {
	public Left() {
		parameterCode = "e";
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();
		double endAngle = startAngle + myParameters[0];
		myTurtle.setAngle(endAngle % 360);
		return myParameters[0];
	}
}