package tyler;
public class Pow extends Command {
	public Pow() {
		paramCode = "ee";
	}

	public double execute() {
		return Math.pow(myParameters[0], myParameters[1]);
	}
}