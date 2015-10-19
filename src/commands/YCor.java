package commands;
public class YCor extends Command {
	public YCor() {
		parameterCode = "";
	}
	
	public double execute() {
		return myTurtle.getY();
	}
}