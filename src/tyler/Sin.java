package tyler;
public class Sin extends Command {
	public Sin() {
		paramCode = "e";
	}

	public double execute() {
		return Math.sin(Math.toRadians(myParameters[0]));
	}
}