package slogo_team03;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import commands.Command;

public class TurtleWorld {
	private Turtle turtle;
	private CommandFactory factory;
	private List<String> inputList;
	private CommandParser parser;
	private TurtleMap turtles;

	public TurtleWorld() {
		turtle = new Turtle();
		factory = new CommandFactory();
		inputList = new ArrayList<String>();
		parser = new CommandParser();
		turtles = new TurtleMap();
		turtles.addTurtle(turtle);
	}

	public void receiveAndExecuteInput(String input) {
		inputList = parser.getInput(input);
		executeCommands(inputList);
	}

	private void executeCommands(List<String> commandList) {
		Command command = null;
		String commandName;

		while (commandList.size() > 0) {			
			commandName = commandList.remove(0);
			command = factory.createCommand(commandName, commandList);
			if (command == null) {
				System.out.println("Invalid Input: Your command '" + commandName + "' is not defined.");
				break;
			}

			command.setTurtle(turtle);
			System.out.println(command.execute());
		}
	}
	
	public TurtleMap getTurtlesMap() {
		return turtles;
	}
}