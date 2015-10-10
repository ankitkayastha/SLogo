import java.util.List;

public class ATan extends Command {
	public ATan(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			return Math.atan(Math.toRadians(myParameters[0]));
		}
		return Double.MIN_VALUE;
	}
}