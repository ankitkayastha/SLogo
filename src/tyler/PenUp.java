package tyler;
public class PenUp extends Command {
	public PenUp() {
		paramCode = "";
	}

	public double execute() {
		myTurtle.setPenDown(false);
		return 0;
	}
}