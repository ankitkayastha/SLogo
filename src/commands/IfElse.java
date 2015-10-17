package commands;

import java.util.ArrayList;

public class IfElse extends SpecialCommand {
	public IfElse() {
		runList = new ArrayList<String>();
		paramCode = "e[c][c]";
	}

	public double execute() {
		if (commandLists.get(0).size() != 0) {
			if (myParameters[0] != 0) {
				runList.addAll(commandLists.get(0));
				return -1;
			} else {
				runList.addAll(commandLists.get(1));
				return -1;
			}
		}
		return 0;
	}
}