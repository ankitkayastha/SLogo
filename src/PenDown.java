import java.util.List;

public class PenDown extends Command {
	public PenDown(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		myTurtle.setPenDown(true);
		return 1;
	}
}