package controller;

import java.util.*;

import UserInterface.CenterPane.DisplayTurtle;
import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

import slogo_team03.AngleInterface;
import slogo_team03.CommandInputException;
import slogo_team03.CoordinateInterface;
import slogo_team03.PassToFrontInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.ReceiveString;
import slogo_team03.TrigonometricException;
import slogo_team03.VisibleInterface;

public class BottomPane {
	private List<String> commandHistory;
	private LeftContent left;
	private CommandHistory rightPane;
	private DisplayTurtle display;

	public BottomPane(LeftContent leftCont, CommandHistory right, DisplayTurtle display) {
		this.commandHistory = new ArrayList<String>();
		this.left = leftCont;
		this.rightPane = right;
		this.display = display;
	}

	public void clearButtonAction(TextArea field, Group root) {
		field.clear();

	}

	public void handleKeyInput(KeyCode code, TextArea field) {
		if (code.equals(KeyCode.UP)) {
			// empty text area, which means should load last command
			if (field.getText().equals("")) {
				field.setText(commandHistory.get(commandHistory.size() - 1));
			} else if (commandHistory.contains(field.getText())) { // text area
																	// has
																	// command
																	// previously
																	// stored in
																	// list
				// first command, continue to show first command
				if (commandHistory.indexOf(field.getText()) == 0) {
					field.setText(commandHistory.get(0));
				}
				// command is somehwere else in list, show previous command
				String command = field.getText();
				int index = commandHistory.indexOf(command);
				if (index - 1 >= 0)
					field.setText(commandHistory.get(index - 1));

			}
		} else if (code.equals(KeyCode.DOWN)) {
			if (!field.getText().equals("")) {
				String command = field.getText();
				int index = commandHistory.indexOf(command);
				if (index + 1 < commandHistory.size())
					field.setText(commandHistory.get(index + 1));
				else
					field.clear();
			}
		}
	}

	public void runButtonAction(TextArea field, ReceiveString rs, CoordinateInterface ci, AngleInterface ai,
			PenUpDownInterface pi, VisibleInterface vi, PassToFrontInterface pf)
					throws CommandInputException, TrigonometricException {
		ListView<String> list = rightPane.getListView();
		List<ListView<String>> myLists = left.getListViewObs();
		ListView<String> variableNames = myLists.get(1);
		ObservableList<String> varNames = left.getListViewObservable(1);
		ListView<String> variableVals = myLists.get(2);
		ObservableList<String> varObs = left.getListViewObservable(2);
		ObservableList<String> myObsList = rightPane.getObs();
		String command = field.getText();
		commandHistory.add(command);
		myObsList.add(field.getText());
		list.setItems(myObsList);

		// pass updated variables

		for (int i = 0; i < varNames.size(); i++) {
			rs.receiveCommand("make " + varNames.get(i) + " " + Double.parseDouble(varObs.get(i)));
		}

		rs.receiveCommand(command);

		Map<String, Double> updatedMap = pf.getVariableMap();
		varObs.clear();
		varNames.clear();
		for (String s : updatedMap.keySet()) {
			varObs.add(updatedMap.get(s).toString());
			varNames.add(s);
		}
		variableVals.setItems(varObs);
		variableNames.setItems(varNames);

		display.move(ci, ai, pi, vi);
		field.clear();
	}

}
