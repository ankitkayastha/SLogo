package commands;

public class HideTurtle extends Command {
	public HideTurtle() {
		super();
	}

	public double execute() {
		myTurtle.setVisible(false);
		return 0;
	}
	
	@Override
	public String toString() {
		return "HideTurtle";
	}
}