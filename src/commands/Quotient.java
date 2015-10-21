package commands;

public class Quotient extends Command {
	public Quotient() {
		super();
	}

	public double execute() {
		if (myParameters.get(1) == 0) {
			return 0;	//Change to throw exception
		}
		return (myParameters.get(0) / myParameters.get(1));
	}

	@Override
	public String toString() {
		return "Quotient";
	}
}