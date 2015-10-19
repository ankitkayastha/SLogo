package commands;

public class HideTurtle extends Command {
	public HideTurtle() {
		parameterCode = "";
	}

	public double execute() {
		myTurtle.setVisible(false);
		return 0;
	}
}