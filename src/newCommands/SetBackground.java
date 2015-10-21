package newCommands;

import commands.Command;

public class SetBackground extends Command {
	public SetBackground() {
		super();
	}

	@Override
	public double execute() {
		myTurtle.setBackground(myParameters.get(0));
		return myParameters.get(0);
	}

	@Override
	public String toString() {
		return "SetBackground";
	}
}