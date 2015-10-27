package commands;

public class PenDown extends MultipleTurtleCommandsuckmyballs {
	public PenDown() {
		super();
	}

	public double execute() {
		pen.setPenDown(true);
		return 1;
	}
	
	@Override
	public String toString() {
		return "PenDown";
	}
}