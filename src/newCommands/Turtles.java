package newCommands;

import commands.Command;
import slogo_team03.Turtle;

public class Turtles extends Command {
	public Turtles() {
		super();
	}

	@Override
	public double execute() {
		return Turtle.getNumTurtles();
	}

	@Override
	public String toString() {
		return "Turtles";
	}
}