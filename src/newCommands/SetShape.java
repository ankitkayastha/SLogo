package newCommands;

import commands.Command;

public class SetShape extends Command {
	public SetShape() {
		super();
	}

	@Override
	public double execute() {
		myTurtle.setShape(myParameters.get(0));
		return myParameters.get(0);
	}

	@Override
	public String toString() {
		return "SetShape";
	}
}