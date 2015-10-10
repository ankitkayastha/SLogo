import java.util.List;

public class Or extends Command {
	public Or(List<String> input) {
		super(input);
		parametersNeeded = 2;
	}
	
	public double execute() {
		if (validParameters()) {
			if (myParameters[0] != 0 || myParameters[1] != 0) 
				return 1;
			else
				return 0;
		}
		return Double.MIN_VALUE;
	}
}