package commands;
import java.util.List;

import slogo_team03.CommandErrorChecker;
import slogo_team03.CommandFactory;
import slogo_team03.Turtle;

public abstract class Command {
	protected int parametersNeeded;
	protected List<String> restOfInput;
	protected double[] myParameters;
	protected Turtle myTurtle;
	protected CommandErrorChecker myErrorChecker;
	protected CommandFactory factory = new CommandFactory();


	public Command(List<String> input) {
		restOfInput = input;
		myParameters = new double[5];
	}

	public abstract double execute();

	public void setTurtle(Turtle turtle) {
		myTurtle = turtle;
	}

	public boolean checkAndPutParameters() {
		if (myErrorChecker.areParametersValid()) {
			putParameters();
			return true;
		}
		return false;
	}
	
	protected void putParameters() {
		for (int i = 0; i < parametersNeeded; i++) {
			if (isCommand(restOfInput.get(0))) {
				String commandName = restOfInput.remove(0);
				Command newCommand = factory.createCommand(commandName, restOfInput);
				newCommand.setTurtle(myTurtle);
				myParameters[i] = newCommand.execute();
			}
			else {
				myParameters[i] = Double.parseDouble(restOfInput.remove(0));
			}
		}
	}
	
	private boolean isCommand(String s) {
		return (!isNumeric(s));
	}

	private boolean isNumeric(String s) {  
		return s.matches("[-+]?\\d*\\.?\\d+");  
	}
}