package commands;

public class Log extends Command {
	public Log() {
		super();
	}

	public double execute() {
		return Math.log(myParameters[0]);
	}
	
	@Override
	public String toString() {
		return "NaturalLog";
	}
}