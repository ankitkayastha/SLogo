package slogo_team03;

public class Stamp {
	private Color myColor;
	private int myPenSize;
	private int myShape;
	private double myX;
	private double myY;
	private double myAngle;

	public Stamp(double x, double y, double angle) {
		myX = x;
		myY = y;
		myAngle = angle;
	}

	public void setColor(Color color) {
		myColor = color;
	}

	public void setPenSize(int penSize) {
		myPenSize = penSize;
	}

	public void setShape(int shape) {
		myShape = shape;
	}

	public Color getMyColor() {
		return myColor;
	}

	public int getMyPenSize() {
		return myPenSize;
	}

	public int getMyShape() {
		return myShape;
	}

	public double getMyX() {
		return myX;
	}

	public double getMyY() {
		return myY;
	}

	public double getMyAngle() {
		return myAngle;
	}
	
	public String toString() {
		return "Color " + myColor.toString();
		
//		private Color myColor;
//		private int myPenSize;
//		private int myShape;
//		private double myX;
//		private double myY;
//		private double myAngle;
	}
}