import java.util.List;

public class Cos extends Command {
	public Cos(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			return Math.cos(Math.toRadians(myParameters[0]));
		}
		return Double.MIN_VALUE;
	}
}