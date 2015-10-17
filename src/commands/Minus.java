package commands;
public class Minus extends Command {
	public Minus() {
		paramCode = "e";
	}

	public double execute() {
		return myParameters[0] * -1;
	}
}