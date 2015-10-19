package commands;

public class Pow extends Command {
	public Pow() {
		super();
	}

	public double execute() {
		return Math.pow(myParameters[0], myParameters[1]);
	}
	
	@Override
	public String toString() {
		return "Power";
	}
}