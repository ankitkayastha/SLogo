package controller.toppane;

import UserInterface.CenterPane.DisplayTurtle;
import slogo_team03.CommandInputException;
import slogo_team03.ReceiveFromFront;
import slogo_team03.MathException;

public class UpdatePenProperties {
	
	private ReceiveFromFront rf;
	private DisplayTurtle displayTurt;
	public UpdatePenProperties(DisplayTurtle display, ReceiveFromFront receive) {
		displayTurt = display;
		rf = receive;
	}
	public void changePenUpDown(String text) {
		if (text.equals("Pen Up"))
			try {
				rf.receiveCommand("pu");
				displayTurt.update(); //update tool tip
			} catch (NumberFormatException | CommandInputException | MathException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				rf.receiveCommand("pd");
				displayTurt.update(); //update tool tip
			} catch (NumberFormatException | CommandInputException | MathException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void changeLineType(String text) {
		
	}
	
	public void changePenThickness(String text) {
		try {
			rf.receiveCommand("setps " + text);
		} catch (NumberFormatException | CommandInputException | MathException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
