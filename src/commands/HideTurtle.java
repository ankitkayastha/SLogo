package commands;
public class HideTurtle extends Command {
	public HideTurtle() {
		paramCode = "";
	}
	
	public double execute() {
		myTurtle.setVisible(false);
		return 0;
	}
}