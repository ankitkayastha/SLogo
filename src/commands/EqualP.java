package commands;

public class EqualP extends Command {
	public EqualP() {
		super();
	}

	public double execute() {
		if (myParameters[0] == myParameters[1])
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "Equal";
	}
}