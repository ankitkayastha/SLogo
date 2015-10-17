package tyler;

import java.util.List;

public abstract class SpecialCommand extends Command {
	protected List<String> runList;

	public SpecialCommand() {
	}

	public abstract double execute();

	public List<String> getRunList() {
		return runList;
	}
}