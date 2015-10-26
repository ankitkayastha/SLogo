package slogo_team03;

import javafx.scene.paint.Color;

public class Stamp {
	private Color myColor;
	private double myShape;
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

	public void setShape(double shape) {
		myShape = shape;
	}

	public Color getMyColor() {
		return myColor;
	}

	public double getMyShape() {
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
	
	@Override
	public String toString() {
		return "Color: (" + myColor.getRed() + ", " + myColor.getGreen() + ", " + myColor.getBlue() + ") Shape: "
				+ myShape + ", X: " + myX + ", Y: " + myY + ", Angle: " + myAngle;
	}
}