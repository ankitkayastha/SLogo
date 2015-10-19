package newCommands;

import commands.Command;

public class Shape extends Command {
	public Shape() {
		super();
	}

	@Override
	public double execute() {
		return myTurtle.getShape();
	}

	@Override
	public String toString() {
		return "GetShape";
	}
}