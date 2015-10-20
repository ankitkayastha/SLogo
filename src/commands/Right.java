package commands;

public class Right extends Command {
	public Right() {
		super();
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();
		double endAngle = startAngle - myParameters[0];
		myTurtle.setAngle(endAngle % 360);
		return myParameters[0];
	}
	
	@Override
	public String toString() {
		return "Right";
	}
}