package commands;

public class PenUp extends MultipleTurtleCommand {
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