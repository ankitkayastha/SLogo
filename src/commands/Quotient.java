package commands;

public class Quotient extends Command {
	public Quotient() {
		parameterCode = "ee";
	}

	public double execute() {
		if (myParameters[1] == 0) {
			return 0;
		}
		return (int) (myParameters[0] / myParameters[1]);
	}
}