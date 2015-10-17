package commands;
public class SetXY extends Command {
	public SetXY() {
		paramCode = "ee";
	}

	public double execute() {
		double x0 = myTurtle.getX();
		double y0 = myTurtle.getY();
		double x1 = myParameters[0];
		double y1 = myParameters[1];

		myTurtle.setX(x1);
		myTurtle.setY(y1);
		myTurtle.addPoint(x1, y1);

		return Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2));
	}
}