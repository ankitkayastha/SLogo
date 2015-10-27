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
	
	public void addToTurtleMap(Turtle t) {
		myTurtleMap.put(t.getID(), t);
	}
	
	public void addToActiveList(Turtle t) {
		myActiveList.add(t.getID());
	}
	
	public void resetTurtleMap() {
		myTurtleMap = new HashMap<Integer, Turtle>();
	}
	
	public void resetActiveList() {
		myActiveList = new ArrayList<Integer>();
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
		// System.out.println(existingTurtles);
		for (int i = 0; i < myTemporaryList.size(); i++) {
			// System.out.println(myTemporaryList.get(i));
		}
		// System.out.println(existingTurtles);
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
		// for (Turtle t : myTurtleList) {
		// myLineList.addAll(t.getLineList());
		// }
		return myLineList;
	}

	// public void executeActiveTurtles(Command command) {
	// if (command instanceof TurtleCommand) {
	//
	// }
	// List<Turtle> turtleList = getTurtleList(myActiveList);
	// for
	//
	// }

	public List<Turtle> getActiveList() {
		List<Turtle> turtleList = new ArrayList<Turtle>();
		for (Integer num : myActiveList) {
			turtleList.add(myTurtleMap.get(num));
		}
		return turtleList;
	}

	// public List<Turtle> getActiveList() {
	// List<Turtle> turtleList = new ArrayList<Turtle>();
	// for (Integer I : myActiveList) {
	// turtleList.add(myTurtleList.get(I));
	// }
	// return turtleList;
	// }

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
}