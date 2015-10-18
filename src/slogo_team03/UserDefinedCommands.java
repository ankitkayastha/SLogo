package slogo_team03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDefinedCommands {
	private Map<String, List<String>> commandsMap;
	
	public UserDefinedCommands() {
		commandsMap = new HashMap<String, List<String>>();
	}
	
	public List<String> getCommandDefiniton(String name) {
		return commandsMap.get(name);
	}
	
	public void addCommandDefinition(String name, List<String> definition) {
		commandsMap.put(name, definition);
	}
	
	public List<String> removeCommandDefinition(String name) {
		return commandsMap.remove(name);
	}
	
	public Map<String, String> getCommandsMap() {
		HashMap<String, String> mapForFront = new HashMap<String, String>();
		for (String command : commandsMap.keySet()) {
			StringBuilder rebuiltDefinition = new StringBuilder();
			for (String definition : commandsMap.get(command)) {
				rebuiltDefinition.append(definition);
				rebuiltDefinition.append(" ");
			}
			mapForFront.put(command, rebuiltDefinition.toString());
		}
		return mapForFront;
	}
}
