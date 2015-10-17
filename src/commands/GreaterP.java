package commands;
public class GreaterP extends Command {
	public GreaterP() {
		paramCode = "ee";
	}

	public double execute() {
		if (myParameters[0] > myParameters[1])
			return 1;
		else
			return 0;
	}
}