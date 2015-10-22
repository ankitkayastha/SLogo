package newCommands;

import commands.Command;

public class SetPenColor extends Command {
	public SetPenColor() {
		super();
	}

	@Override
	public double execute() {
		myTurtle.setPenColor(myParameters.get(0));
		return myParameters.get(0);
	}

	@Override
	public String toString() {
		return "SetPenColor";
	}
}