package commands;

import java.util.ArrayList;

public class Repeat extends SpecialCommand {
	public Repeat() {
		runList = new ArrayList<String>();
		paramCode = "e[c]";
	}

	public double execute() {
		for (int i = 0; i < myParameters[0]; i++) {
			runList.addAll(myCommandLists.get(0));
		}
		return -1;
	}
}