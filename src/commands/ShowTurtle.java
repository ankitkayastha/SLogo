package commands;

import slogo_team03.MultipleTurtCommand;

public class ShowTurtle extends MultipleTurtCommand {
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