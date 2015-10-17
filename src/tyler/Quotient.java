package tyler;
public class Quotient extends Command {
	public Quotient() {
		paramCode = "ee";
	}

	public double execute() {
		return (int) (myParameters[0] / myParameters[1]);
	}
}