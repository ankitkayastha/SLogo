package commands;
public class Tan extends Command {
	public Tan() {
		parameterCode = "e";
	}

	public double execute() {
		return Math.tan(Math.toRadians(myParameters[0]));
	}
}