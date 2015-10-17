package commands;

import java.util.ArrayList;

public class To extends SpecialCommand {
	public To() {
		runList = new ArrayList<String>();
		paramCode = "n[v][c]";
	}

	public double execute() {
		boolean wellDefined = true;

		if (wellDefined) {
			return 1;
		} else {
			return 0;
		}
	}
}