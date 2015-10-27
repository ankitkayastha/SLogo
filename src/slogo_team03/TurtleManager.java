package slogo_team03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import commands.UserCommand;
import commands.Command;
import javafx.scene.shape.Line;

public class TurtleManager {
	private Map<Integer, Turtle> myTurtleMap;
	// private List<Turtle> myTurtleList;
	private List<Integer> myActiveList;
	private List<Integer> myTemporaryList;
	private List<Line> myLineList;
	private Stack<List<Integer>> temporaryListStack;
	// private Set<Integer> existingTurtles;

	public TurtleManager() {
		Turtle turtle = new Turtle(1);
		myTurtleMap = new HashMap<Integer, Turtle>();
		myTurtleMap.put(turtle.getID(), turtle);
		// myTurtleList = new ArrayList<Turtle>();
		// myTurtleList.add(turtle);
		myActiveList = new ArrayList<Integer>();
		myActiveList.add(1);
		myTemporaryList = new ArrayList<Integer>();
		temporaryListStack = new Stack<List<Integer>>();
		// existingTurtles = new HashSet<Integer>();
		// existingTurtles.add(1);
		// System.out.println(existingTurtles);
	}

	public Turtle firstTurtle() {
		return myTurtleMap.get(1);
	}

	public void setActiveList(List<Integer> activeList) {
		myActiveList.clear();
		for (int i = 0; i < activeList.size(); i++) {
			if (!myTurtleMap.containsKey(activeList.get(i))) {
				Turtle turtle = new Turtle(activeList.get(i));
				myTurtleMap.put(turtle.getID(), turtle);
				// existingTurtles.add(activeList.get(i));
			}
		}
		myActiveList = new ArrayList<Integer>(activeList);
		for (int i = 0; i < myActiveList.size(); i++) {
			System.out.println(myActiveList.get(i));
		}
	}

	public void setTemporaryList(List<Integer> temporaryList) {
		for (int i = 0; i < temporaryList.size(); i++) {
			if (!myTurtleMap.containsKey(temporaryList.get(i))) {
				Turtle turtle = new Turtle(temporaryList.get(i));
				myTurtleMap.put(turtle.getID(), turtle);
				// existingTurtles.add(temporaryList.get(i));
			}
		}
		if (temporaryListStack.isEmpty()) {
			myTemporaryList = new ArrayList<Integer>(temporaryList);
		} else {
			temporaryListStack.push(new ArrayList<Integer>(myTemporaryList));
			myTemporaryList = new ArrayList<Integer>(temporaryList);
		}
	}

	public void deleteTemporaryList() {
		if (temporaryListStack.isEmpty()) {
			myTemporaryList.clear();
		} else {
			myTemporaryList = new ArrayList<Integer>(temporaryListStack.pop());
		}
	}

	public List<Line> getLineList() {
		myLineList.clear();
		for (Integer key : myTurtleMap.keySet()) {
			myLineList.addAll(myTurtleMap.get(key).getLineList());
		}
		return myLineList;
	}

	public List<Turtle> getActiveList() {
		List<Turtle> turtleList = new ArrayList<Turtle>();
		for (Integer num : myActiveList) {
			turtleList.add(myTurtleMap.get(num));
		}
		return turtleList;
	}

	public List<Turtle> getTemporaryList() {
		List<Turtle> turtleList = new ArrayList<Turtle>();
		for (Integer num : myTemporaryList) {
			turtleList.add(myTurtleMap.get(num));
		} myTemporaryList.clear();
		
		System.out.println("HERE");
		for (int i = 0; i < turtleList.size(); i++) {
			System.out.println("INDEX"+i);
		}
//		if (temporaryListStack.isEmpty()) {
//			myTemporaryList.clear();
//		} else {
//			myTemporaryList = new ArrayList<Integer>(temporaryListStack.pop());
//		}
		return turtleList;
	}
	
	public List<ITurtleProperties> getTurtleList() {
		List<ITurtleProperties> turtleList = new ArrayList<ITurtleProperties>();
		for (Integer key : myTurtleMap.keySet()) {
			Turtle turtle = myTurtleMap.get(key);
			turtleList.add(turtle);
//			System.out.println("X: " + turtle.getX() + " Y: " + turtle.getY() + "ID: " + turtle.getID());
		}
		
		return turtleList;
	}

	// public List<Turtle> createTurtleList(List<Integer> turtleIndexList) {
	// List<Turtle> turtleList = new ArrayList<Turtle>();
	// for (int i = 0; i < turtleIndexList.size(); i++) {
	// turtleList.add(myTurtleList.get(turtleIndexList.get(i)));
	// }
	// return turtleList;
	// }
	
	public void reinitializeTurtles() {
		Turtle.resetTurtleCount();
		myTurtleMap.clear();
		myActiveList.clear();
		myTemporaryList.clear();
		//ADD MORE
	}
	
	public boolean tempListIsEmpty() {
		return myTemporaryList.isEmpty();
	}
}