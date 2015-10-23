package UserInterface.CenterPane;

import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import slogo_team03.AngleInterface;
import slogo_team03.CoordinateInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.VisibleInterface;

public class CreateTooltip {
	
	public void update(CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi, Node node) {
		String penStatus;
		if (pi.isPenDown())
			penStatus = "Down";
		else
			penStatus = "Up";
		Tooltip tip = new Tooltip();
		tip.setText("Turtle X Coordinate: " + ci.getX() + "\n" + "Turtle Y Coordinate: " + ci.getY() + "\n" + 
		"Heading: " + ai.absoluteAngleFrontend() + "\n" + "Pen: " + penStatus);
		Tooltip.install(node, tip);
	}
}
