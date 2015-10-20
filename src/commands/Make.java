package commands;

public class Make extends Command {
	public Make() {
		super();
	}

	public double execute() {
		variableMap.addVariable(myVariable, myParameters[1]);
		return myParameters[1];
	}
	
	@Override
	public String toString() {
		return "MakeVariable";
	}
}