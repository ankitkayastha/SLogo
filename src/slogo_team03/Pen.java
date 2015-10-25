package slogo_team03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Pen {
	private boolean penDown;
	private Color backgroundColor;
	private Color penColor;
	private double penSize;
	private double shape;
	private Map<Double, Color> palette;
	private List<Stamp> stampList;
	private List<Line> lineList;
	private double backgroundColorIndex;
	private double penColorIndex;

	public Pen() {
		createPalette();
		backgroundColorIndex = 0;
		penColorIndex = 0;
		penColor = palette.get(penColorIndex);
		penSize = 1;
		shape = 4;
		stampList = new ArrayList<Stamp>();
		lineList = new ArrayList<Line>();
	}
	
	public Map<Double, Color> getPalette() {
		return palette;
	}

	private void createPalette() {
		palette = new HashMap<Double, Color>();
		updatePalette(0, 0, 0, 0);
		updatePalette(1, 255, 255, 255);
		updatePalette(2, 255, 0, 0);
		updatePalette(3, 0, 255, 0);
		updatePalette(4, 0, 0, 255);
	}

	public void addToLineList(List<Line> list) {
		lineList.addAll(list);
	}

	public void clearLineList() {
		lineList.clear();
	}

	public List<Line> getLineList() {
		return new ArrayList<Line>(lineList);
	}

	public void addStamp(Stamp stamp) {
		stamp.setColor(palette.get(penColorIndex));
		stamp.setShape(shape);
		stampList.add(stamp);
	}

	public double clearStampList() {
		if (stampList.size() > 0) {
			// printStampList();
			stampList.clear();
			return 1;
		} else {
			return 0;
		}
	}

	// private void printStampList() {
	// for (int i = 0; i < stampList.size(); i++) {
	// System.out.println(stampList.get(i).toString());
	// }
	// }

	public List<Stamp> getStampList() {
		return stampList;
	}

	public void updatePalette(double index, int red, int green, int blue) {
		palette.put(index, Color.rgb(red, green, blue));
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public double getBackgroundColorIndex() {
		return backgroundColorIndex;
	}

	public void setBackgroundColor(double index) {
		backgroundColorIndex = index;
		backgroundColor = palette.get(index);
	}

	public Color getPenColor() {
		return penColor;
	}

	public double getPenColorIndex() {
		return penColorIndex;
	}

	public void setPenColor(double index) {
		penColorIndex = index;
		penColor = palette.get(penColorIndex);
	}

	public double getPenSize() {
		return penSize;
	}

	public void setPenSize(double pixels) {
		penSize = pixels;
	}

	public double getShape() {
		return shape;
	}

	public void setShape(double index) {
		shape = index;
	}

	public boolean isPenDown() {
		return penDown;
	}

	public void setPenDown(boolean pendown) {
		penDown = pendown;
	}
}