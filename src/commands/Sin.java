package commands;
import java.util.List;

public class Sin extends Command {
	public Sin(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			return Math.sin(Math.toRadians(myParameters[0]));
		}
		return Double.MIN_VALUE;
	}
}