package controller;


import java.util.*;

import UserInterface.BottomPane.CommandPrompt;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class BottomPane {
	private List<String> commandHistory = new ArrayList<String>();;
	
	public void clearButtonAction(TextArea field) {
		field.clear();
	}
	
	public void runButtonAction(TextArea field, ScrollPane[] paneArr, int index) {
		Group root = new Group();
		String command = field.getText();
		commandHistory.add(command);
		List<Text> myTextList = convertToText(commandHistory);
		for (Text text : myTextList) {
			root.getChildren().add(text);
			System.out.println(text.getText());
		}
		paneArr[index].setContent(root);
		System.out.println("Adding to scrollable pane");
	}
	
	private List<Text> convertToText(List<String> commandList) {
		List<Text> list = new ArrayList<Text>();
		for (String s : commandList) {
			Text textObj = new Text(s);
			list.add(textObj);
		}
		
		return list;
	}
}
