package tyler;
public class NotEqualP extends Command {
	public NotEqualP() {
		paramCode = "ee";
	}

	public double execute() {
		if (myParameters[0] != myParameters[1])
			return 1;
		else
			return 0;
	}
}