package newCommands;

import commands.Command;

public class SetPenSize extends Command {
	public SetPenSize() {
		super();
	}

	@Override
	public double execute() {
		myTurtle.setPenSize(myParameters.get(0));
		return myParameters.get(0);
	}

	@Override
	public String toString() {
		return "SetPenSize";
	}
}