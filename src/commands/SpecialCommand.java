package commands;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecialCommand extends Command {
	protected List<String> runList;

	public SpecialCommand() {
		super();
		runList = new ArrayList<String>();
	}

	public abstract double execute();

	public List<String> getRunList() {
		return runList;
	}
	
	
}