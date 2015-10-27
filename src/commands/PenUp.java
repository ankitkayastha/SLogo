package commands;

public class PenUp extends MultipleTurtleCommandsuckmyballs {
	public PenUp() {
		super();
	}

	public double execute() {
		pen.setPenDown(false);
		return 0;
	}
	
	@Override
	public String toString() {
		return "PenUp";
	}
}