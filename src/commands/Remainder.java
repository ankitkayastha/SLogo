package commands;
import java.util.List;

public class Remainder extends Command {
	public Remainder(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			if (myParameters[0] < myParameters[1])
				return myParameters[1];
			else
				return myParameters[0] % myParameters[1];		
		}
		return Double.MIN_VALUE;
	}
}