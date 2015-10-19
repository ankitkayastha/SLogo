package commands;

public class Sum extends Command {
	public Sum() {
		parameterCode = "ee";
	}

	public double execute() {
//		System.out.println("Sum: " + myParameters[0] + " + " + myParameters[1] + " = " + (myParameters[0] + myParameters[1]));
		return myParameters[0] + myParameters[1];
	}
}