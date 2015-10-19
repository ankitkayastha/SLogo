package commands;

public class XCor extends Command {
	public XCor() {
		parameterCode = "";
	}

	public double execute() {
		return myTurtle.getX();
	}
}