package UserInterface.CenterPane;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class CustomLine extends Line {
	
	public CustomLine(double startX, double startY, double endX, double endY, Color color) {
		super(startX, startY, endX, endY);
		
		Line line = new Line();
		line.setStroke(color);
		line.setStartX(startX);
		line.setStartY(startY);
		line.setEndX(endX);
		line.setEndY(endY);

	}
	public void setStroke(Color color) {
		
	}
}
