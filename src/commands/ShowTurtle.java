package commands;

public class ShowTurtle extends MultipleTurtleCommand {
	public ShowTurtle() {
		super();
	}

	public double execute() {
		myTurtle.setVisible(true);
		return 1;
	}
	
	@Override
	public String toString() {
		return "ShowTurtle";
	}
}