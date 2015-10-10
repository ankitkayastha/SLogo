import java.util.List;

public class YCor extends Command {
	public YCor(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		return myTurtle.getY();
	}
}