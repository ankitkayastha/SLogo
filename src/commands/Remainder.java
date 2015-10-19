package commands;

public class Remainder extends Command {
	public Remainder() {
		super();
	}

	public double execute() {
		if (myParameters[0] < myParameters[1])
			return myParameters[1];
		else {
			return myParameters[0] % myParameters[1];
		}
	}
	
	@Override
	public String toString() {
		return "Remainder";
	}
}