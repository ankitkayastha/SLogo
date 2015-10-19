package newCommands;

import commands.Command;

public class SetBackground extends Command {
	public SetBackground() {
		super();
	}

	@Override
	public double execute() {
		int param0 = (int) myParameters[0];
		myTurtle.setBackground(param0);
		return param0;
	}

	@Override
	public String toString() {
		return "SetBackground";
	}
}