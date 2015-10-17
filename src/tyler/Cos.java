package tyler;
public class Cos extends Command {
	public Cos() {
		paramCode = "e";
	}

	public double execute() {
		return Math.cos(Math.toRadians(myParameters[0]));
	}
}