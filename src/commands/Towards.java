package commands;

public class Towards extends Command {
	public Towards() {
		paramCode = "ee";
	}

	public double execute() {
		double oldAngle = myTurtle.getAngle();
		double newAngle; // Not correct

		double startX = myTurtle.getX();
		double startY = myTurtle.getY();
		double endX = myParameters[0];
		double endY = myParameters[1];
		
		
//		if ((endX - startX) != 0) {
//			
//		}
		
		double slope = (endY - startY) / (endX - startX);
		return Math.atan(slope);

		// if (startY == endY) {
		// if (startX < endX) {
		// myTurtle.setAngle(0);
		// }
		// }

		// // Need to calculate newAngle
		// newAngle = 0;
		//
		// double difference = Math.abs(oldAngle - newAngle);
		// if (difference > 180) {
		// return 360 - difference;
		// }
		// return difference;
	}
}