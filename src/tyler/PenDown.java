package tyler;
public class PenDown extends Command {
	public PenDown() {
		paramCode = "";
	}
	
	public double execute() {
		myTurtle.setPenDown(true);
		return 1;
	}
}