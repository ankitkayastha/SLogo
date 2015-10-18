package slogo_team03;

import java.util.HashMap;
import java.util.List;


import javafx.scene.shape.Line;

public class TurtleMap {
	private HashMap<Integer, Turtle> turtles;

	public TurtleMap() {
		turtles = new HashMap<Integer, Turtle>();
	}
	
	private Turtle getTurtle(int turtleID) {
		if (turtles.containsKey(turtleID)) {
			return turtles.get(turtleID);
		}
		return null;
	}
	
	public void addTurtle(Turtle t) {
		turtles.put(t.getID(), t);
	}
	
	public boolean isTurtleVisible(int turtleID) {
		return this.getTurtle(turtleID).isVisible();
	}
	
	public boolean isPenDown(int turtleID) {
		return this.getTurtle(turtleID).isPenDown();
	}
	
	public List<Line> getTurtleCoordinateList(int turtleID) {
		return this.getTurtle(turtleID).getLineList();
	}
	
}
