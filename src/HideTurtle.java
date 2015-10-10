import java.util.List;

public class HideTurtle extends Command {
	public HideTurtle(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		myTurtle.setVisible(false);
		return 0;
	}
}