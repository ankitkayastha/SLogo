package slogo_team03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pen {
	private boolean penDown;
	private int backgroundColor;
	private int penColor;
	private int penSize;
	private int shape;
	private Map<Integer, Color> palette;
	private List<Stamp> stampList;

	public Pen() {
		backgroundColor = 0;
		penColor = 0;
		penSize = 1;
		shape = 4;
		palette = new HashMap<Integer, Color>();
		stampList = new ArrayList<Stamp>();
	}

	public void addStamp(Stamp stamp) {
		stamp.setColor(palette.get(penColor));
		stamp.setPenSize(penSize);
		stamp.setShape(shape);
		stampList.add(stamp);
	}

	public double clearStampList() {
		if (stampList.size() > 0) {
			stampList.clear();
			return 1;
		} else {
			return 0;
		}
	}
	
	public List<Stamp> getStampList() {
		return stampList;
	}

	public void updatePalette(int index, int red, int green, int blue) {
		palette.put(index, new Color(red, green, blue));
	}

	public int getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(int index) {
		backgroundColor = index;
	}

	public int getPenColor() {
		return penColor;
	}

	public void setPenColor(int index) {
		penColor = index;
	}

	public int getPenSize() {
		return penSize;
	}

	public void setPenSize(int pixels) {
		penSize = pixels;
	}

	public int getShape() {
		return shape;
	}

	public void setShape(int index) {
		shape = index;
	}

	public boolean isPenDown() {
		return penDown;
	}

	public void setPenDown(boolean pendown) {
		penDown = pendown;
	}
}