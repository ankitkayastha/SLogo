package commands;
import java.text.DecimalFormat;
import java.util.List;

public class XCor extends Command {
	public XCor(List<String> input) {
		super(input);
		parametersNeeded = 0;
	}
	
	public double execute() {
//		double x = myTurtle.getX();
//		DecimalFormat df = new DecimalFormat("#.#####");      
//		x = Double.valueOf(df.format(x));
//		return x;	//Should the turtle's value of x also be reset to x here?
//		
		return myTurtle.getX();
	}
}