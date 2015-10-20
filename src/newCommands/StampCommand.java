package newCommands;

import commands.Command;

public class StampCommand extends Command {
	public StampCommand() {
		super();
	}

	@Override
	public double execute() {
		return myTurtle.stamp();
	}

	@Override
	public String toString() {
		return "Stamp";
	}
}