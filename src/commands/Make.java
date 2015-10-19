package commands;

public class Make extends Command {
	public static int i = 1;
	public Make() {
		parameterCode = "ve";
	}

	public double execute() {
//		System.out.println(i++ + " " + myVariable + " " + myParameters[1]);
		variableMap.addVariable(myVariable, myParameters[1]);
//		System.out.println(variableMap);
		return myParameters[1];
	}
}