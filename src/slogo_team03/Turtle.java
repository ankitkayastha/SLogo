package slogo_team03;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.shape.Line;

public class Turtle implements CoordinateInterface, AngleInterface, PenUpDownInterface, VisibleInterface {
	private double x, y;
	private double angle;
	private boolean visible;
	private static Pen pen;
	private List<Line> lineList;
	private DecimalFormat df;
	private int myID;
	private static int ID = -1;
	private ResourceBundle r = ResourceBundle.getBundle("slogo_team03/TurtleResource");

	public Turtle() {
		myID = ++ID;
		initialize();
	}
	
	public void setTurtle(Turtle copyTurtle) {
		x = copyTurtle.getX();
		y = copyTurtle.getY();
		angle = copyTurtle.getAngle();
		visible = copyTurtle.isVisible();
		pen.setPenDown(copyTurtle.isPenDown());
		df = new DecimalFormat("#.#####");
		lineList = new ArrayList<Line>();
	 }

	public void reset() {
		initialize();
	}

	private void initialize() {
		x = Integer.parseInt(r.getString("startX"));
		y = Integer.parseInt(r.getString("startY"));
		angle = Integer.parseInt(r.getString("startAngle"));
		visible = Boolean.parseBoolean(r.getString("visible"));
		pen.setPenDown(Boolean.parseBoolean(r.getString("penDown")));
		df = new DecimalFormat("#.#####");
		lineList = new ArrayList<Line>();
	}

	public double absoluteAngleFrontend() {
		return (90 - getAngle()) % 360;
	}

	public void addLine(double x0, double y0, double x1, double y1) {
		if (pen.isPenDown()) {
			lineList.add(new Line(format(x0), format(y0), format(x1), format(y1)));
		}
	}

	public void resetLineList() {
		lineList.clear();
	}

	public List<Line> getLineList() {
		return lineList;
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
		return pen.isPenDown();
	}

	public void setPenDown(boolean penDown) {
		pen.setPenDown(penDown);
	}

	private double format(double d) {
		if (Double.valueOf(df.format(d)) == 0.00000)
			return 0;
		return Double.valueOf(df.format(d));
	}
	
	public static int getNumTurtles() {
		return ID;
	}
}