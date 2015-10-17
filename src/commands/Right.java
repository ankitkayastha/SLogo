package commands;
public class Right extends Command {
	public Right() {
		paramCode = "e";
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();
		double endAngle = startAngle - myParameters[0];
		myTurtle.setAngle(endAngle % 360);
		myTurtle.addAngle((360 + startAngle - endAngle) % 360);
		return myParameters[0];
	}
}