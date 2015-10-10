import java.util.List;

public class Pow extends Command {
	public Pow(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			return Math.pow(myParameters[0], myParameters[1]);
		}
		return Double.MIN_VALUE;
	}
}