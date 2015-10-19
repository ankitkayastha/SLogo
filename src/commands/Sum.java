package commands;
public class Sum extends Command {
	public Sum() {
		parameterCode = "ee";
	}
	
	public double execute() {
		return myParameters[0] + myParameters[1];		
	}
}