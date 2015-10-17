package tyler;
public class Difference extends Command {
	public Difference() {
		paramCode = "ee";
	}

	public double execute() {
		return myParameters[0] - myParameters[1];
	}
}