package newCommands;

import commands.Command;

public class SetPenSize extends Command {
	public SetPenSize() {
		super();
	}

	@Override
	public double execute() {
		int param0 = (int) myParameters[0];
		myTurtle.setPenSize(param0);
		return param0;
	}

	@Override
	public String toString() {
		return "SetPenSize";
	}
}