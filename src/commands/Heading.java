package commands;
public class Heading extends Command {
	public Heading() {
		paramCode = "";
	}
	
	public double execute() {
		return ((360 - myTurtle.getAngle()) % 360);
	}
}