package commands;

public class Log extends Command {
	public Log() {
		parameterCode = "e";
	}

	public double execute() {
		return Math.log(myParameters[0]);
	}
}