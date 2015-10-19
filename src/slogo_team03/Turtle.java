package slogo_team03;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.shape.Line;

public class Turtle implements CoordinateInterface, AngleInterface, PenUpDownInterface, VisibleInterface {
	private double x, y;
	private double angle;
	private boolean visible, penDown;
	private List<Line> lineList;
	private List<Double> angleRotateList;
	private DecimalFormat df;
	private int myID;
	private static int ID = 0;
	private ResourceBundle r = ResourceBundle.getBundle("slogo_team03/TurtleResource");

	public Turtle() {
		myID = ID++;
		initialize();
	}
	
	public void setTurtle(Turtle copyTurtle) {
		x = copyTurtle.getX();
		y = copyTurtle.getY();
		angle = copyTurtle.getAngle();
		visible = copyTurtle.isVisible();
		penDown = copyTurtle.isPenDown();
		df = new DecimalFormat("#.#####");
		lineList = new ArrayList<Line>();
		angleRotateList = new ArrayList<Double>();
	 }

	public void reset() {
		initialize();
	}

	private void initialize() {
		x = Integer.parseInt(r.getString("startX"));
		y = Integer.parseInt(r.getString("startY"));
		angle = Integer.parseInt(r.getString("startAngle"));
		visible = Boolean.parseBoolean(r.getString("visible"));
		penDown = Boolean.parseBoolean(r.getString("penDown"));
		df = new DecimalFormat("#.#####");
		lineList = new ArrayList<Line>();
		angleRotateList = new ArrayList<Double>();
	}

	public double absoluteAngleFrontend() {
		return (90 - getAngle()) % 360;
	}

	public void addAngle(double angle) {
		angleRotateList.add(angle);
	}

	public void addLine(double x0, double y0, double x1, double y1) {
		if (penDown) {
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