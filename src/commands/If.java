package commands;

import java.util.ArrayList;

public class If extends SpecialCommand {
	public If() {
		runList = new ArrayList<String>();
		parameterCode = "e[c]";
	}

	public double execute() {
		if (myParameters[0] != 0 && myCommandLists.get(0).size() != 0) {
			runList.addAll(myCommandLists.get(0));
			return -1;
		}
		return 0;
	}
}