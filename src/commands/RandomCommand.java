package commands;
import java.util.List;
import java.util.Random;

public class RandomCommand extends Command {
	public RandomCommand(List<String> input) {
		super(input);
		parametersNeeded = 1;
	}
	
	public double execute() {
		if (validParameters()) {
			Random generator = new Random();
			return Math.abs(myParameters[0] * generator.nextDouble());		
		}
		return Double.MIN_VALUE;
	}
}