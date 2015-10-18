package commands;

public class Make extends Command {
	public Make() {
		paramCode = "ve";
	}

	public double execute() {
		variableMap.addVariable(myVariable, myParameters[1]);
		System.out.println(variableMap);
		return myParameters[1];
	}
}