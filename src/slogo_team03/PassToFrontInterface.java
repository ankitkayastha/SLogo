package slogo_team03;

import java.util.Map;

import commands.UserCommand;

public interface PassToFrontInterface {
	public Map<String, Double> getVariableMap();

	public Map<String, UserCommand> getUserDefinedCommands();

	public String getLastCommand();
}