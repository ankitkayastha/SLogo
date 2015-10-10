import java.util.List;

public class Minus extends Command {
	public Minus(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			return myParameters[0] * -1;		
		}
		return Double.MIN_VALUE;
	}
}