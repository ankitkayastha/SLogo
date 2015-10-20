package commands;

import java.util.Random;

public class RandomCommand extends Command {
	public RandomCommand() {
		super();
	}

	public double execute() {
		Random generator = new Random();
		return Math.abs(myParameters[0] * generator.nextDouble());
	}
	
	@Override
	public String toString() {
		return "Random";
	}
}