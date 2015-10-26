package slogo_team03;

import java.util.Map;

import commands.UserCommand;
import javafx.scene.paint.Color;

public interface PassToFrontInterface {
	public Map<String, Double> getVariableMap();

	public Map<String, UserCommand> getUserDefinedCommands();

	public String getLastCommand();
	
	public Color getUpdatedBackgroundColor();
	
	public Map<Double, Color> getPalette();
}