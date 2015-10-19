package commands;

public class Cos extends Command {
	public Cos() {
		super();
	}

	public double execute() {
		return Math.cos(Math.toRadians(myParameters[0]));
	}

	@Override
	public String toString() {
		return "Cosine";
	}
}