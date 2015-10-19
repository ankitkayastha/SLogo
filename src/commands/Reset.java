package commands;

public class Reset extends ClearScreen {
	public Reset() {
		super();
	}

	public double execute() {
		myTurtle.reset();
		return super.execute();
	}
}