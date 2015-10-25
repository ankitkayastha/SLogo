package newCommands;

import java.util.List;

import commands.Command;
import commands.SpecialCommand;

public abstract class MultipleTurtleCommand extends SpecialCommand {
	public abstract List<Integer> getTurtleList();
}
