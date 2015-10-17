package tyler;
public class XCor extends Command {
	public XCor() {
		paramCode = "";
	}
	
	public double execute() {
		return myTurtle.getX();
	}
}