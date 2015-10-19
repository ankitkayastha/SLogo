package commands;

public class Towards extends Command {
	public Towards() {
		parameterCode = "ee";
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();

		double startX = myTurtle.getX();
		double startY = myTurtle.getY();
		double endX = myParameters[0];
		double endY = myParameters[1];

		if (startX == endX && startY == endY) {
			return 0;
		}

		double slope = (endY - startY) / (endX - startX);
		double endAngle = Math.toDegrees(Math.atan(slope));

		if (startX > endX) {
			endAngle += 180;
		}

		myTurtle.setAngle(endAngle);

		double difference = (360 + startAngle - endAngle) % 360;

		return difference;
	}
}