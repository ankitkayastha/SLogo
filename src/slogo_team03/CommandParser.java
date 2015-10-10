package slogo_team03;

import java.util.ArrayList;
import java.util.Arrays;

public class CommandParser {
	
	ArrayList<String> getInput(String commands) {
		String[] inputArray = commands.split("\\s+");
		ArrayList<String> commandArray = new ArrayList<String>(Arrays.asList(inputArray));
		return commandArray;
	}
}
