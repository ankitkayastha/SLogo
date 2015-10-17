package commands;

public class Towards extends Command {
	public Towards() {
		paramCode = "ee";
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();
		double endAngle; // Not correct

		double startX = myTurtle.getX();
		double startY = myTurtle.getY();
		double endX = myParameters[0];
		double endY = myParameters[1];
		
		
//		if ((endX - startX) != 0) {
//			
//		}
		
		double slope = (endY - startY) / (endX - startX);
		double angle = Math.atan(slope);
		angle = Math.toDegrees(angle);
		
		if (angle == 90.0) {
		} else if (angle == -90.0) {
			
		} else if ()
		
		
		
		
		return angle;
//		
//		
//		double angle = Math.atan(slope);
//		return angle;

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