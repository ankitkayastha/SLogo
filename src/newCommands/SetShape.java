package newCommands;

import commands.Command;

public class SetShape extends Command {
	public SetShape() {
		super();
	}

	@Override
	public double execute() {
		int param0 = (int) myParameters[0];
		myTurtle.setShape(param0);
		return param0;
	}

	@Override
	public String toString() {
		return "SetShape";
	}
}