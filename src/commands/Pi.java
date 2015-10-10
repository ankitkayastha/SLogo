package commands;
import java.util.List;

public class Pi extends Command {
	public Pi(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		if (validParameters()) {
			return Math.PI;
		}
		return Double.MIN_VALUE;
	}
}