package commands;
public class HideTurtle extends Command {
	public HideTurtle() {
		paramCode = "";
	}
	
	public double execute() {
		myTurtle.setVisible(false);
		System.out.println("Turtle visibility from command is " + myTurtle.isVisible());
		return 0;
	}
}