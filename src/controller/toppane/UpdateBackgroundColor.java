package controller.toppane;

import UserInterface.CenterPane.DisplayTurtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import slogo_team03.CommandInputException;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;
import slogo_team03.TrigonometricException;

public class UpdateBackgroundColor implements EventHandler<ActionEvent> {
	private DisplayTurtle turtle;
	private ReceiveFromFront rf;
	private String index;
	private PassToFrontInterface pf;
	public UpdateBackgroundColor(DisplayTurtle t, ReceiveFromFront receive, PassToFrontInterface pass, String ind) {
		this.turtle = t;
		rf = receive;
		index = ind;
		pf = pass;
	}

	public void changeBackgroundAction(Color c) {
		turtle.getGC().setFill(c);
		turtle.getGC().fillRect(0, 0, 500, 500);
	}

	public void changePenColorAction(Color c) {
		turtle.setLineColor(c);
	}

	public void changeLanguage(String s, ReceiveFromFront rs) {
		rs.receiveLanguage(s);
	}


	public void handle(ActionEvent event, String index) {
		try {
			rf.receiveCommand("setbg " + index);
			changeBackgroundAction(pf.getUpdatedBackgroundColor());
		} catch (CommandInputException | TrigonometricException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void handle(ActionEvent event) {
		//handle(event, )
	}
}
