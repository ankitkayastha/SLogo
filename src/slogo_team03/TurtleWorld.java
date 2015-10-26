package slogo_team03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import commands.Command;

public class TurtleWorld implements ReceiveString, PassToFrontInterface, FileInterface {
	private Turtle turtle;
	private UserDefinedCommands userDefinedCommands;
	private UserDefinedVariables variables;
	private Parser parser;
	private TurtleMap turtles;
	private XmlWriter xmlWriter;
	private XmlReader xmlReader;

	public TurtleWorld() {
		userDefinedCommands = new UserDefinedCommands();
		variables = new UserDefinedVariables();
		parser = new Parser(userDefinedCommands, variables);
		turtle = new Turtle();
		turtles = new TurtleMap();
		turtles.addTurtle(turtle);
		Command.setMaps(userDefinedCommands, variables);
		xmlWriter = new XmlWriter(userDefinedCommands, variables);
		xmlReader = new XmlReader(variables, userDefinedCommands);
	}

	public void interpretInput(List<String> inputList) throws CommandInputException, TrigonometricException {
		Command.setMaps(userDefinedCommands, variables);
		parser.setTurtle(turtle); // Should this be here?
		parser.processInput(inputList);
	}

	private List<String> removeCommentsAndWhitespace(String input) {
		String processedInput = "";
		for (int i = 0; i + 1 <= input.length(); i++) {
			if (input.substring(i, i + 1).equals("#")) {
				i++;
				while (i + 1 < input.length() && !input.substring(i, i + 1).equals("\n")) {
					i++;
				}
			} else {
				processedInput += input.substring(i, i + 1);
			}
		}
		String[] inputArray = processedInput.trim().split("\\s+");
		List<String> inputList = new ArrayList<String>(Arrays.asList(inputArray));
		return inputList;
	}

	public double getAngle() {
		return turtle.absoluteAngleFrontend();
	}

	public Turtle getTurtle() {
		return turtle;
	}

	@Override
	public void receiveCommand(String input) throws CommandInputException, TrigonometricException {
		interpretInput(removeCommentsAndWhitespace(input));
		xmlWriter.writeXmlFile("D:\\Daniel\\Duke University\\2015 - 2016\\Compsci 308\\SLogo\\slogo_team03\\File.xml");
	}

	@Override
	public void receiveLanguage(String language) {
		parser.processLanguage(language);
		xmlReader.readFile("D:\\Daniel\\Duke University\\2015 - 2016\\Compsci 308\\SLogo\\slogo_team03\\File.xml");
		
	}

	@Override
	public Map<String, Double> getVariableMap() {
		return variables.getVariableMap();
	}

	@Override
	public Map<String, String> getUserDefinedCommands() {
		return null;
	}
	
	public void readXmlFile(String path) {
		xmlReader.readFile(path);
	}
	
	public void writeXmlFile(String path) {
		xmlWriter.writeXmlFile(path);
	}
}