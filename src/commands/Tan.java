package commands;

public class Tan extends Command {
	public Tan() {
		super();
	}

	public double execute() {
		return Math.tan(Math.toRadians(myParameters[0]));
	}

	@Override
	public String toString() {
		return "Tangent";
	}
}