package slogo_team03;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;

public class Turtle {
	private double x, y;
	private double angle;
	private boolean visible, penDown;
	private List<Point2D> pointList;
	private static int ID = 0;
	
	public Turtle() {
		x = 0;
		y = 0;
		angle = 90;
		visible = true;
		penDown = true;
		resetPointList();
		ID = ID++;
	}
	
	public void resetPointList(double a, double b) {
		pointList = new ArrayList<Point2D>();
		pointList.add(new Point2D(a, b));
	}
	
	public void resetPointList() {
		pointList = new ArrayList<Point2D>();
		pointList.add(new Point2D(this.x, this.y));
	}
	
	public List<Point2D> getPointList() {
		return pointList;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isPenDown() {
		return penDown;
	}

	public void setPenDown(boolean penDown) {
		this.penDown = penDown;
	}
	
	public void addPoint(double x, double y) {
		pointList.add(new Point2D(x, y));
	}
	
	public int getID() {
		return this.ID;
	}
}