package commands;
public class Minus extends Command {
	public Minus() {
		parameterCode = "e";
	}

	public double execute() {
		return myParameters[0] * -1;
	}
}