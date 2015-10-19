package commands;

public class PenDown extends Command {
	public PenDown() {
		parameterCode = "";
	}

	public double execute() {
		myTurtle.setPenDown(true);
		return 1;
	}
}