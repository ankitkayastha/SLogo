package commands;

public class SetHeading extends Command {
	public SetHeading() {
		paramCode = "e";
	}

	public double execute() {
		double startAngle = myTurtle.getAngle();
		double endAngle = 450 - myParameters[0];
		endAngle = endAngle % 360;
		myTurtle.setAngle(endAngle);
		myTurtle.addAngle((360 + startAngle - endAngle) % 360);

		double difference = Math.abs(startAngle - endAngle);
		if (difference > 180) {
			return 360 - difference;
		}
		return difference;
	}
}