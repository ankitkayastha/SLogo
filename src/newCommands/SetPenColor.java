package newCommands;

import commands.Command;

public class SetPenColor extends Command {
	public SetPenColor() {
		super();
	}

	@Override
	public double execute() {
		int param0 = (int) myParameters[0];
		myTurtle.setPenColor(param0);
		return param0;
	}

	@Override
	public String toString() {
		return "SetPenColor";
	}
}