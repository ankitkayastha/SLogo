package tyler;

import java.util.ArrayList;

public class If extends SpecialCommand {
	public If() {
		runList = new ArrayList<String>();
		paramCode = "e[c]";
	}

	public double execute() {
		if (myParameters[0] != 0 && commandLists.get(0).size() != 0) {
			runList.addAll(commandLists.get(0));
			return -1;
		}
		return 0;
	}
}