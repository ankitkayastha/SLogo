import java.util.List;

public class PenDownP extends Command {
	public PenDownP(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		if (myTurtle.isPenDown())
			return 1;
		else
			return 0;
	}
}