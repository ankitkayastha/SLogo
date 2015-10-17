package commands;
public class Pi extends Command {
	public Pi() {
		paramCode = "";
	}

	public double execute() {
		return Math.PI;
	}
}