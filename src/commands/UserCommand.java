package commands;

import java.util.List;

public class UserCommand extends Command {
	
	private String myName;
	private List<String> myDefinition;
	
	@Override
	public double execute() {
		// Unneeded method
		return 0;
	}
	
	public List<String> getDefinition() {
		return myDefinition;
	}

}
