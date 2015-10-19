package commands;

public class NotEqualP extends Command {
	public NotEqualP() {
		parameterCode = "ee";
	}

	public double execute() {
		if (myParameters[0] != myParameters[1])
			return 1;
		else
			return 0;
	}
}