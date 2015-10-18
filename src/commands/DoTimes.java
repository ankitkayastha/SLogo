package commands;

import java.util.ArrayList;
import java.util.List;

public class DoTimes extends SpecialCommand {
	public DoTimes() {
		runList = new ArrayList<String>();
		paramCode = "[ve][c]";
	}

	public double execute() {
		List<String> tempList = new ArrayList<String>(myCommandLists.get(0));
		
		if (tempList.size() == 0) {
			return 0;
		}
		
		System.out.println("My Variable: " + myVariable);
		
		for (int i = 1; i <= myParameters[2]; i++) {
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