import java.util.List;

public class ShowTurtle extends Command {
	public ShowTurtle(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		myTurtle.setVisible(true);
		return 1;
	}
}