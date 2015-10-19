package commands;

public class PenUp extends Command {
	public PenUp() {
		parameterCode = "";
	}

	public double execute() {
		myTurtle.setPenDown(false);
		return 0;
	}
}