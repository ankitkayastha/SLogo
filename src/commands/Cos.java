package commands;

public class Cos extends Command {
	public Cos() {
		parameterCode = "e";
	}

	public double execute() {
		return Math.cos(Math.toRadians(myParameters[0]));
	}
}