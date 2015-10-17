package slogo_team03;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.Command;

public class TurtleWorld implements ReceiveString {
	private Turtle turtle;
	private Parser parser;
	private Map<String, List<String>> userDefinedCommands;
	private Map<String, Double> variables;
	private TurtleMap turtles;

	public TurtleWorld() {
		turtle = new Turtle();
		parser = new Parser();
		userDefinedCommands = new HashMap<String, List<String>>();
		variables = new HashMap<String, Double>();
		turtles = new TurtleMap();
		turtles.addTurtle(turtle);
		Command.setMaps(userDefinedCommands, variables);
	}

	public void processInput(String input) {
		String[] inputArray = input.trim().split("\\s+");
		List<String>inputList = new ArrayList<String>(Arrays.asList(inputArray));
		setParser();
		System.out.println(parser.processInput(inputList));
	}

	private void setParser() {
		parser.setTurtle(turtle);
		parser.setUserDefinedCommands(userDefinedCommands);
		parser.setVariables(variables);
	}
	
	public Turtle getTurtle() {
		return turtle;
	}

	@Override
	public void receiveCommand(String s) {
		//System.out.println(s);
		processInput(s);
	}

	@Override
	public void receiveLanguage(String language) {
		parser.processLanguage(language);
	}

}