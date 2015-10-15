package controller;


import java.util.*;

import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

public class BottomPane {
	private List<String> commandHistory;
	private LeftContent left;
	private CommandHistory rightPane;
	public BottomPane(LeftContent leftCont, CommandHistory right) {
		this.commandHistory = new ArrayList<String>();
		this.left = leftCont;
		this.rightPane = right;
	}
	
	public void clearButtonAction(TextArea field) {
		field.clear();
	}
	
	public void handleKeyInput(KeyCode code, TextArea field) {
		if (code.equals(KeyCode.UP)) {
			//empty text area, which means should load last command
			if (field.getText().equals("")) {
				field.setText(commandHistory.get(commandHistory.size() - 1));
			}
			else if (commandHistory.contains(field.getText())) { //text area has command previously stored in list
				//first command, continue to show first command
				if (commandHistory.indexOf(field.getText()) == 0) {
					field.setText(commandHistory.get(0));
				}
				//command is somehwere else in list, show previous command
				String command = field.getText();
				int index = commandHistory.indexOf(command);
				if (index - 1 >= 0)
				field.setText(commandHistory.get(index - 1));
				
			}
		}
		else if (code.equals(KeyCode.DOWN)) {
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
	
	public void runButtonAction(TextArea field) {
		ListView<String> list = rightPane.getListView();
		List<ListView<String>> listViewObjs = left.getListViewObs();
		
		ObservableList<String> myObsList = rightPane.getObs();
		String command = field.getText();
		commandHistory.add(command);
		myObsList.add(field.getText());
		list.setItems(myObsList);
		
		field.clear();
	}
		

}
