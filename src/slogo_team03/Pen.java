package slogo_team03;

import java.util.ArrayList;
import java.util.List;

public class Pen {
	private boolean penDown;
	private int backgroundColor;
	private int penColor;
	private int penSize;
	private int shape;
	private List<Color> paletteList;
//	private Map<Double,>
	
	public Pen() {
		backgroundColor = 0;
		penColor = 0;
		penSize = 1;
		shape = 4;
		paletteList = new ArrayList<Color>();
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

	public void addToPaletteList(int index, int red, int green, int blue) {
		paletteList.add(new Color(index, red, green, blue));
	}
	
	public void clearPaletteList() {
		paletteList.clear();
	}

	public void setPenDown(boolean pendown) {
		penDown = pendown;
	}
}