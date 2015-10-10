import java.util.List;

public class Quotient extends Command {
	public Quotient(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			return (int) (myParameters[0] / myParameters[1]);		
		}
		return Double.MIN_VALUE;
	}
}