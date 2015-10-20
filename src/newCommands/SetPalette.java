package newCommands;

import commands.Command;

public class SetPalette extends Command {
	public SetPalette() {
		super();
	}

	@Override
	public double execute() {
		int param0 = (int) myParameters[0];
		int param1 = (int) myParameters[1];
		int param2 = (int) myParameters[2];
		int param3 = (int) myParameters[3];
		myTurtle.updatePalette(param0, param1, param2, param3);
		return param0;
	}

	@Override
	public String toString() {
		return "SetPalette";
	}
}