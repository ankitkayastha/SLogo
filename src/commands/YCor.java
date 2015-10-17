package commands;
public class YCor extends Command {
	public YCor() {
		paramCode = "";
	}
	
	public double execute() {
		return myTurtle.getY();
	}
}