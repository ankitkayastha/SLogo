package newCommands;

import commands.Command;

public class ClearStamps extends Command {
	public ClearStamps() {
		super();
	}

	@Override
	public double execute() {
		return myTurtle.clearStamps();
	}

	@Override
	public String toString() {
		return "ClearStamps";
	}
}