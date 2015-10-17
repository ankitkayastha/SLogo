package tyler;

import java.util.ArrayList;
import java.util.List;

public class For extends SpecialCommand {
	public For() {
		runList = new ArrayList<String>();
		paramCode = "[veee][c]";
	}

	public double execute() {
		if (commandLists.get(0).size() == 0)
			return 0;

//		if (variableMap.containsKey(myVariable)) {		This code needs to be refactored into Parser.
//			return result;
//		}

		for (int i = (int) myParameters[2]; i <= myParameters[3]; i += myParameters[4]) {
			variableMap.put(myVariable, (double) i);
			List<String> runList = new ArrayList<String>(commandLists.get(0));
//			result = myParser.evaluateCommands(runList);
		}

		variableMap.remove(myVariable);
		return -1;
	}
}
