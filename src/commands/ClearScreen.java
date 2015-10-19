package commands;

public class ClearScreen extends Command {
	public ClearScreen() {
		parameterCode = "";
	}

	public double execute() {
		double x0 = myTurtle.getX();
		double y0 = myTurtle.getY();

		myTurtle.setX(0);
		myTurtle.setY(0);
		myTurtle.resetLineList();

		return Math.sqrt(x0 * x0 + y0 * y0);
	}
}