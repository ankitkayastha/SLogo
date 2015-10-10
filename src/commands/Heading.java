package commands;
import java.util.List;

public class Heading extends Command {
	public Heading(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		return ((450 - myTurtle.getAngle()) % 360);
	}
}