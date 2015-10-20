package commands;

public class Sum extends Command {
	public Sum() {
		super();
	}

	public double execute() {
		return myParameters[0] + myParameters[1];
	}
	
	@Override
	public String toString() {
		return "Sum";
	}
}