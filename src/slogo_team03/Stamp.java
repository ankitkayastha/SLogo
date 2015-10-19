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

	// public Stamp(Color color, int penSize, int shape) {
	// myColor = color;
	// myPenSize = penSize;
	// myShape = shape;
	// }
	//
	// public void setLocation(double x, double y) {
	// myX = x;
	// myY = y;
	// }
	//
	// public void setHeading(double angle) {
	// myAngle = angle;
	// }

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
}