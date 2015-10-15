package controller;

import UserInterface.RightPane.CommandHistory;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class RightPane {
	
	public void actOnClick(CommandHistory right) {
		ObservableList<String> obsList = right.getObs();
		//obsList.
		//pane.setContent(new Text(text.getText()));
	}
	
	public void changed(ObservableValue<? extends String> observable, String oldString, String newString) {
		System.out.println(newString);
	}
	
}
