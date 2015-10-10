import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TurtleWorld {
	private Turtle turtle;
	private CommandFactory factory;
	private List<String> inputList;
	
	public TurtleWorld() {
		turtle = new Turtle();
		factory = new CommandFactory();
		inputList = new ArrayList<String>();	
	}
	
	public void getInput(String input) {
		String[] inputArray = input.split("\\s+");
		inputList = new ArrayList<String>(Arrays.asList(inputArray));
		Command command = null;
		String commandName;
		
		while (inputList.size() > 0) {			
			commandName = inputList.remove(0);
			command = factory.createCommand(commandName, inputList);
			if (command == null) {
				System.out.println("Invalid Input: " + commandName);
				continue;
			}
			
			command.setTurtle(turtle);
			System.out.println(command.execute());
		}
	}
	
	public boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
}