package commands;

public class Or extends Command {
	public Or() {
		super();
	}

	public double execute() {
		if (myParameters[0] != 0 || myParameters[1] != 0)
			return 1;
		else
			return 0;
	}
	
	@Override
	public String toString() {
		return "Or";
	}
}