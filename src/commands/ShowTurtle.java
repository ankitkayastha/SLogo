package commands;
public class ShowTurtle extends Command {
	public ShowTurtle() {
		paramCode = "";
	}
	
	public double execute() {
		myTurtle.setVisible(true);
		return 1;
	}
}