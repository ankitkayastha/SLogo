package commands;

public class SetHeading extends Command {
	public SetHeading() {
		super();
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();
		double endAngle = 450 - myParameters.get(0);
		endAngle = endAngle % 360;
		myTurtle.setAngle(endAngle);

		double difference = Math.abs(startAngle - endAngle);
		if (difference > 180) {
			return 360 - difference;
		}
		return difference;
	}

	@Override
	public String toString() {
		return "SetHeading";
	}
}