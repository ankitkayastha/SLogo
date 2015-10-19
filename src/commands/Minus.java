package commands;

public class Minus extends Command {
	public Minus() {
		super();
	}

	public double execute() {
		return myParameters[0] * -1;
	}
	
	@Override
	public String toString() {
		return "Minus";
	}
}