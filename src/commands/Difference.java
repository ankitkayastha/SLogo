package commands;

public class Difference extends Command {
	public Difference() {
		super();
	}

	public double execute() {
		return myParameters[0] - myParameters[1];
	}
	
	@Override
	public String toString() {
		return "Difference";
	}
}