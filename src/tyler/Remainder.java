package tyler;
public class Remainder extends Command {
	public Remainder() {
		paramCode = "ee";
	}

	public double execute() {
		if (myParameters[0] < myParameters[1])
			return myParameters[1];
		else {
			return myParameters[0] % myParameters[1];
		}
	}
}