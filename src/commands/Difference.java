package commands;

public class Difference extends Command {
	public Difference() {
		parameterCode = "ee";
	}

	public double execute() {
		return myParameters[0] - myParameters[1];
	}
}