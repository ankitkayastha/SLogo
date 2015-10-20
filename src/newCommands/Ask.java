package newCommands;

//import commands.Command;
import commands.SpecialCommand;

public class Ask extends SpecialCommand {
	public Ask() {
		super();
	}

	@Override
	public double execute() {
		return 0;
	}

	@Override
	public String toString() {
		return "Ask";
	}
}