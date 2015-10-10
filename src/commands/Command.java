package commands;
import java.util.List;

import slogo_team03.CommandFactory;
import slogo_team03.Turtle;

public abstract class Command {
	protected int parametersNeeded;
	protected List<String> restOfInput;
	protected double[] myParameters;
	protected Turtle myTurtle;
	
	public Command(List<String> input) {
		restOfInput = input;
		myParameters = new double[5];
	}
	
	public abstract double execute();
	
	public void setTurtle(Turtle turtle) {
		myTurtle = turtle;
	}
	
	public boolean validParameters() {
		if (!enoughParameters()) {
			return false;
		}
		
		CommandFactory factory = new CommandFactory();
		for (int i = 0; i < parametersNeeded; i++) {
			if (restOfInput.size() == 0) {
				return false;
			}
			
			if (!isNumeric(restOfInput.get(0))) {
				String commandName = restOfInput.remove(0);
				Command newCommand = factory.createCommand(commandName, restOfInput);
				if (newCommand == null) {
					i--;
					continue;
				}
				newCommand.setTurtle(myTurtle);
				myParameters[i] = newCommand.execute();
			}
			else {
				myParameters[i] = Double.parseDouble(restOfInput.remove(0));
			}
		}
		return true;
	}

	protected boolean enoughParameters() {
		return (restOfInput.size() >= parametersNeeded);
	}
	
	public boolean isNumeric(String s) {  
	    return s.matches("[-+]?\\d*\\.?\\d+");  
	}
}