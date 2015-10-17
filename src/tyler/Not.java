package tyler;
public class Not extends Command {
	public Not() {
		paramCode = "e";
	}

	public double execute() {
		if (myParameters[0] == 0)
			return 1;
		else
			return 0;
	}
}