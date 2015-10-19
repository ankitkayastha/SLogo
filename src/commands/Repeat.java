package commands;

import java.util.ArrayList;

public class Repeat extends SpecialCommand {
	public Repeat() {
		runList = new ArrayList<String>();
		parameterCode = "e[c]";
	}

	public double execute() {
		for (int i = 0; i < myParameters[0]; i++) {
			runList.addAll(myCommandLists.get(0));
		}
//		System.out.print("RepeatList:");
//		for (int i = 0; i < runList.size(); i++) {
//			System.out.print(" " + runList.get(i));
//		} System.out.println();
		return -1;
	}
}