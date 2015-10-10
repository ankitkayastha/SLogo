package commands;
import java.util.List;

public class Not extends Command {
	public Not(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			if (myParameters[0] == 0) 
				return 1;
			else
				return 0;
		}
		return Double.MIN_VALUE;
	}
}