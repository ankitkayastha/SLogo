package commands;
import java.util.List;

public class EqualP extends Command {
	public EqualP(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			if (myParameters[0] == myParameters[1]) 
				return 1;
			else
				return 0;
		}
		return Double.MIN_VALUE;
	}
}