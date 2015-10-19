package commands;
public class Pow extends Command {
	public Pow() {
		parameterCode = "ee";
	}

	public double execute() {
		return Math.pow(myParameters[0], myParameters[1]);
	}
}