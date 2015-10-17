package commands;
public class ATan extends Command {
	public ATan() {
		paramCode = "e";
	}

	public double execute() {
		return Math.atan(Math.toRadians(myParameters[0]));
	}
}