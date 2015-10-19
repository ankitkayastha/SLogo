package commands;
public class Not extends Command {
	public Not() {
		parameterCode = "e";
	}

	public double execute() {
		if (myParameters[0] == 0)
			return 1;
		else
			return 0;
	}
}