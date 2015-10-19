package commands;
public class PenDownP extends Command {
	public PenDownP() {
		parameterCode = "";
	}
	
	public double execute() {
		if (myTurtle.isPenDown())
			return 1;
		else
			return 0;
	}
}