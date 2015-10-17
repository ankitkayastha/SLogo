package commands;
public class Or extends Command {
	public Or() {
		paramCode = "ee";
	}

	public double execute() {
		if (myParameters[0] != 0 || myParameters[1] != 0)
			return 1;
		else
			return 0;
	}
}