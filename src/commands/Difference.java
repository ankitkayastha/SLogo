package commands;
import java.util.List;

public class Difference extends Command {
	public Difference(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			return myParameters[0] - myParameters[1];		
		}
		return Double.MIN_VALUE;
	}
}