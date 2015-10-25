package controller;

import UserInterface.CenterPane.DisplayTurtle;

import javafx.scene.paint.Color;
import slogo_team03.AngleInterface;
import slogo_team03.CoordinateInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.ReceiveFromFront;
import slogo_team03.VisibleInterface;

public class TopPane {
	private DisplayTurtle turtle;

	public TopPane(DisplayTurtle t) {
		this.turtle = t;
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

	public void changeImageAction(String s) {
		turtle.setImage(s);
	}
}
