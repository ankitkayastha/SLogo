package commands;
import java.util.List;

public class Home extends Command {
	public Home(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
		double x = myTurtle.getX();
		double y = myTurtle.getY();
		
		myTurtle.setX(0);
		myTurtle.setY(0);
		
		return Math.sqrt(x*x + y*y);
	}
}