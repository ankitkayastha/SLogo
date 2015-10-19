package commands;

public class PenUp extends Command {
	public PenUp() {
		super();
	}

	public double execute() {
		myTurtle.setPenDown(false);
		return 0;
	}
	
	@Override
	public String toString() {
		return "PenUp";
	}
}