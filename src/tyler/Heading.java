package tyler;
public class Heading extends Command {
	public Heading() {
		paramCode = "";
	}
	
	public double execute() {
		return ((450 - myTurtle.getAngle()) % 360);
	}
}