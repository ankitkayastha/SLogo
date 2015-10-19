package commands;

public class ShowingP extends Command {
	public ShowingP() {
		parameterCode = "";
	}

	public double execute() {
		if (myTurtle.isVisible())
			return 1;
		else
			return 0;
	}
}