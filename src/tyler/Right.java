package tyler;
public class Right extends Command {
	public Right() {
		paramCode = "e";
	}

	public double execute() {
		double angle = myTurtle.getAngle();
		angle -= myParameters[0];
		myTurtle.setAngle(angle % 360);
		return myParameters[0];
	}
}