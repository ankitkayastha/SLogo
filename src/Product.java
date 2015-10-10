import java.util.List;

public class Product extends Command {
	public Product(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			return myParameters[0] * myParameters[1];		
		}
		return Double.MIN_VALUE;
	}
}