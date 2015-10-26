package controller.toppane;

import UserInterface.CenterPane.DisplayTurtle;
import slogo_team03.CommandInputException;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;
import slogo_team03.TrigonometricException;

public class UpdateBackgroundColor {
	private DisplayTurtle turtle;
	private ReceiveFromFront rf;
	private PassToFrontInterface pf;
	public UpdateBackgroundColor(DisplayTurtle t, ReceiveFromFront receive, PassToFrontInterface pass) {
		this.turtle = t;
		rf = receive;
		pf = pass;
	}


	public void changeBackgroundAction(String index) {
		try {
			rf.receiveCommand("setbg " + index);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CommandInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TrigonometricException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		turtle.getGC().setFill(pf.getUpdatedBackgroundColor());
		turtle.getGC().fillRect(0, 0, 500, 500);
		turtle.update();

	}
}
