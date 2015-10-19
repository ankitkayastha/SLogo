package commands;

public class NotEqualP extends Command {
	public NotEqualP() {
		super();
	}

	public double execute() {
		if (myParameters[0] != myParameters[1])
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "NotEqual";
	}
}