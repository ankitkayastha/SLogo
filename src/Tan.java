import java.util.List;

public class Tan extends Command {
	public Tan(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			return Math.tan(Math.toRadians(myParameters[0]));
		}
		return Double.MIN_VALUE;
	}
}