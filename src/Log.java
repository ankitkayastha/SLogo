import java.util.List;

public class Log extends Command {
	public Log(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			return Math.log(myParameters[0]);
		}
		return Double.MIN_VALUE;
	}
}