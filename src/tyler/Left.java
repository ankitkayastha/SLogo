package tyler;
public class Left extends Command {
	public Left() {
		paramCode = "e";
	}

	public double execute() {
		double angle = myTurtle.getAngle();
		angle += myParameters[0];
		myTurtle.setAngle(angle % 360);
		return myParameters[0];
	}
}