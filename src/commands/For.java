package commands;

import java.util.ArrayList;
import java.util.List;

public class For extends SpecialCommand {
	public For() {
		runList = new ArrayList<String>();
		paramCode = "[veee][c]";
	}
	
	public double execute() {
		List<String> tempList = new ArrayList<String>(commandLists.get(0));
		
		if (tempList.size() == 0) {
			return 0;
		}
		
		for (int i = (int) myParameters[2]; i <= myParameters[3]; i += myParameters[4]) {
			for (int j = 0; j < tempList.size(); j++) {
				if (tempList.get(j).equals(myVariable)) {
					runList.add(Integer.toString(i));
				} else {
					runList.add(tempList.get(j));
				}
			}
		}
		return -1;
	}
}