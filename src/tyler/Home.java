package tyler;
public class Home extends Command {
	public Home() {
		paramCode = "";
	}
	
	public double execute() {
		double x = myTurtle.getX();
		double y = myTurtle.getY();
		
		myTurtle.setX(0);
		myTurtle.setY(0);
		myTurtle.addPoint(0, 0);
		
		return Math.sqrt(x*x + y*y);
	}
}