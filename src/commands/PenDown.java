package commands;

public class PenDown extends Command {
	public PenDown() {
		super();
	}

	public double execute() {
		myTurtle.setPenDown(true);
		return 1;
	}
	
	@Override
	public String toString() {
		return "PenDown";
	}
}