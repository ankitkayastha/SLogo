package commands;

public class LessP extends Command {
	public LessP() {
		parameterCode = "ee";
	}

	public double execute() {
		if (myParameters[0] < myParameters[1])
			return 1;
		else
			return 0;
	}
}