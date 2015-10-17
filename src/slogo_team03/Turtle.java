package slogo_team03;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Turtle {
	private double x, y;
	private double angle;
	private boolean visible, penDown;
	private List<Point2D> pointList;
	private DecimalFormat df;
	private int myID;
	private static int ID = 0;
	private ResourceBundle r = ResourceBundle.getBundle("slogo_team03/TurtleResource");
	
	public Turtle() {
		x = Integer.parseInt(r.getString("startX"));
		y = Integer.parseInt(r.getString("startY"));
		angle = Integer.parseInt(r.getString("startAngle"));
		visible = Boolean.parseBoolean(r.getString("visible"));
		penDown = Boolean.parseBoolean(r.getString("penDown"));
		df = new DecimalFormat("#.#####");
		pointList = new ArrayList<Point2D>();
		addPoint(x, y);
		myID = ID;
		ID++;
	}
	
	public void addPoint(double x, double y) {
		pointList.add(new Point2D(format(x), format(x)));
	}
	
	public void resetPointList() {
		pointList.clear();
		pointList.add(new Point2D(0, 0));
	}
	
	public List<Point2D> getPointList() {
		return pointList;
	}
	
	public int getID() {
		return myID;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = format(x);
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = format(y);
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = format(angle);
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
	
	private double format(double d) {
		if (Double.valueOf(df.format(d)) == 0.00000)
			return 0;
		return Double.valueOf(df.format(d));
	}
}