package tyler;
public class Sum extends Command {
	public Sum() {
		paramCode = "ee";
	}
	
	public double execute() {
		return myParameters[0] + myParameters[1];		
	}
}