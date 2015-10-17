package commands;
public class Tan extends Command {
	public Tan() {
		paramCode = "e";
	}

	public double execute() {
		return Math.tan(Math.toRadians(myParameters[0]));
	}
}