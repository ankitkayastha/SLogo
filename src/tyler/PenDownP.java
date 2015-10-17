package tyler;
public class PenDownP extends Command {
	public PenDownP() {
		paramCode = "";
	}
	
	public double execute() {
		if (myTurtle.isPenDown())
			return 1;
		else
			return 0;
	}
}