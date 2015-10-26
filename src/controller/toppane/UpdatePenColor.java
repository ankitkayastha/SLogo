package controller.toppane;

import slogo_team03.CommandInputException;
import slogo_team03.ReceiveFromFront;
import slogo_team03.TrigonometricException;

public class UpdatePenColor {
	private ReceiveFromFront rf;
	public UpdatePenColor(ReceiveFromFront receive) {
		rf = receive;
	}
	
	
	public void changePenColorAction(String index) {
		try {
			rf.receiveCommand("setpc " + index);
		} catch (NumberFormatException | CommandInputException | TrigonometricException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
