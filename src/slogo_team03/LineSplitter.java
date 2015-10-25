package slogo_team03;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class LineSplitter {
	public List<Line> split(Line line) {
		List<Line> myList = new ArrayList<Line>();
		Color color = (Color) line.getFill();
		double penSize = line.getStrokeWidth();

		while (line.getEndX() > 250 && line.getEndY() > 250) {
			
		}

		for (int i = 0; i < myList.size(); i++) {
			myList.get(i).setFill(color);
			myList.get(i).setStrokeWidth(penSize);
		}
		return myList;
	}
}