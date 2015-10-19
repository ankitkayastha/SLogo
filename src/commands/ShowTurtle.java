package commands;

public class ShowTurtle extends Command {
	public ShowTurtle() {
		parameterCode = "";
	}

	public double execute() {
		myTurtle.setVisible(true);
		return 1;
	}
}