package commands;

import slogo_team03.TrigonometricException;

public class Tan extends Command {
	public Tan() {
		super();
	}

	public double execute() throws TrigonometricException {
		double angle = myParameters.get(0);
		if (angle % 180 == 90.0) {
			throw new TrigonometricException("tan(" + (int) angle + "\u00b0)");
		}
		return Math.tan(Math.toRadians(myParameters.get(0)));
	}

	@Override
	public String toString() {
		return "Tangent";
	}
}