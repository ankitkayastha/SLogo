package tyler;
public class SetHeading extends Command {
	public SetHeading() {
		paramCode = "e";
	}

	public double execute() {
		double oldAngle = myTurtle.getAngle();
		double newAngle = 450 - myParameters[0];
		newAngle = newAngle % 360;
		myTurtle.setAngle(newAngle);

		double difference = Math.abs(oldAngle - newAngle);
		if (difference > 180) {
			return 360 - difference;
		}
		return difference;
	}
}