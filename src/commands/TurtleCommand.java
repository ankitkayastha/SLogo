package commands;

import slogo_team03.TrigonometricException;

public abstract class TurtleCommand extends Command {

	@Override
	public String toString() {
		return "TurtleCommand";
	}

	@Override
	public abstract double execute() throws TrigonometricException;

}
