package tyler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurtleWorld {
	private Turtle turtle;
	private Parser parser;
	private List<String> inputList;
	private Map<String, List<String>> userDefinedCommands;
	private Map<String, Double> variables;

	public TurtleWorld() {
		turtle = new Turtle();
		parser = new Parser();
		userDefinedCommands = new HashMap<String, List<String>>();
		variables = new HashMap<String, Double>();
		Command.setMaps(userDefinedCommands, variables);
	}

	public void processInput(String input) {
		String[] inputArray = input.trim().split("\\s+");
		inputList = new ArrayList<String>(Arrays.asList(inputArray));
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
}