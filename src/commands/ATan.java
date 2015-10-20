package commands;

public class ATan extends Command {
	public ATan() {
		super();
	}

	public double execute() {
		return Math.atan(Math.toRadians(myParameters[0]));
	}
	
	@Override
	public String toString() {
		return "ArcTangent";
	}
}