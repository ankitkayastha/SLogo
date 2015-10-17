package commands;
public class ClearScreen extends Command {
	public ClearScreen() {
		paramCode = "";
	}
	
	public double execute() {
		double x = myTurtle.getX();
		double y = myTurtle.getY();
		
		myTurtle.setX(0);
		myTurtle.setY(0);
		myTurtle.resetPointList();
//		myTurtle.resetPointList(Double.MAX_VALUE, Double.MAX_VALUE);
		
		return Math.sqrt(x*x + y*y);
	}
}