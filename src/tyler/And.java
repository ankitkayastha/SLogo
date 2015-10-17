package tyler;
public class And extends Command {
	public And() {
		paramCode = "ee";
	}

	public double execute() {
		if (myParameters[0] != 0 && myParameters[1] != 0)
			return 1;
		else
			return 0;
	}
}