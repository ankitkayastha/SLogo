package commands;
public class Quotient extends Command {
	public Quotient() {
		parameterCode = "ee";
	}

	public double execute() {
		return (int) (myParameters[0] / myParameters[1]);
	}
}