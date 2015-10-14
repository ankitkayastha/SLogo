package slogo_team03;
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
	private static Color penColor;
	private ResourceBundle r = ResourceBundle.getBundle("slogo_team03/TurtleResource");
	
	public Turtle() {
		x = Integer.parseInt(r.getString("startX"));
		y = Integer.parseInt(r.getString("startY"));
		angle = Integer.parseInt(r.getString("startAngle"));
		visible = Boolean.parseBoolean(r.getString("visible"));
		penDown = Boolean.parseBoolean(r.getString("penDown"));
		penColor = Color.BLUE;
		resetPointList();
	}
	
	public void resetPointList(double a, double b) {
		pointList = new ArrayList<Point2D>();
		pointList.add(new Point2D(a, b));
	}
	
	public void resetPointList() {
		pointList = new ArrayList<Point2D>();
		pointList.add(new Point2D(this.x, this.y));
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
	
	public static void setPenColor(Color c) {
		penColor = c;
	}
	
	public void addPoint(double x, double y) {
		pointList.add(new Point2D(x, y));
	}
}