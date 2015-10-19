package commands;
public class Pi extends Command {
	public Pi() {
		parameterCode = "";
	}

	public double execute() {
		return Math.PI;
	}
}