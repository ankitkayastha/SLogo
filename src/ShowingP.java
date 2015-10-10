import java.util.List;

public class ShowingP extends Command {
	public ShowingP(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		if (myTurtle.isVisible())
			return 1;
		else
			return 0;
	}
}