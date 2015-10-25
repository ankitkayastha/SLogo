package slogo_team03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import commands.UserCommand;
import commands.Command;
import javafx.scene.shape.Line;

public class TurtleManager {
	private List<Turtle> myTurtleList;
	private List<Integer> myActiveList;
	private List<Integer> myTemporaryList;
	private List<Line> myLineList;
	private Stack<List<Integer>> temporaryListStack;

	public TurtleManager() {
		Turtle turtle = new Turtle();
		myTurtleList = new ArrayList<Turtle>();
		myTurtleList.add(turtle);
		myActiveList = new ArrayList<Integer>();
		myTemporaryList = new ArrayList<Integer>();
		temporaryListStack = new Stack<List<Integer>>();
	}

	public Turtle firstTurtle() {
		return myTurtleList.get(0);
	}

	public void setActiveList(List<Integer> activeList) {
		myActiveList = new ArrayList<Integer>(activeList);
	}

	public void setTemporaryList(List<Integer> temporaryList) {
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
		for (Turtle t : myTurtleList) {
			myLineList.addAll(t.getLineList());
		}
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
		for (Integer I : myActiveList) {
			turtleList.add(myTurtleList.get(I));
		}
		return turtleList;
	}

	public List<Turtle> getTurtleList() {
		return myTurtleList;
	}

	public List<Turtle> createTurtleList(List<Integer> turtleIndexList) {
		List<Turtle> turtleList = new ArrayList<Turtle>();
		for (int i = 0; i < turtleIndexList.size(); i++) {
			turtleList.add(myTurtleList.get(turtleIndexList.get(i)));
		}
		return turtleList;
	}
}