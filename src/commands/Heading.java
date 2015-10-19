package commands;
public class Heading extends Command {
	public Heading() {
		parameterCode = "";
	}
	
	public double execute() {
		return ((450 - myTurtle.getAngle()) % 360);
	}
}