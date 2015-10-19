package commands;
public class Sin extends Command {
	public Sin() {
		parameterCode = "e";
	}

	public double execute() {
		return Math.sin(Math.toRadians(myParameters[0]));
	}
}