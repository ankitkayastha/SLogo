package commands;
public class ATan extends Command {
	public ATan() {
		parameterCode = "e";
	}

	public double execute() {
		return Math.atan(Math.toRadians(myParameters[0]));
	}
}