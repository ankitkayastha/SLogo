package commands;
import java.util.List;

public class PenUp extends Command {
	public PenUp(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		myTurtle.setPenDown(false);
		return 0;
	}
}