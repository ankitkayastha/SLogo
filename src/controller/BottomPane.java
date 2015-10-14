package controller;


import java.util.*;

import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

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
		ScrollPane[] arr = left.getPaneArray();
		field.clear();
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
		arr[1].setContent(new ImageView(image));
	}
	
	public void handleKeyInput(KeyCode code, TextArea field) {
		if (code.equals(KeyCode.UP)) {
			//empty text area, which means should load last command
			if (field.getText().equals("")) {
				//System.out.println("Command History size is " + commandHistory.size());
				//System.out.println("At index 2 is " + commandHistory.get(2));
				field.setText(commandHistory.get(commandHistory.size() - 1));
				//System.out.println("After setting text, text is " + field.getText());
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
			//field.setText(commandHistory.get(commandHistory.size() - 1));
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
		//Group root = new Group();
		ScrollPane[] paneArr = left.getPaneArray();
		//Group root = rightPane.getRoot();
		ListView<String> list = rightPane.getListView();
		System.out.println("Listview now is " + list.getItems().toString());
		ObservableList<String> myObsList = rightPane.getObs();
		String command = field.getText();
		//System.out.println(command);
		commandHistory.add(command);
	//	System.out.println(commandHistory.toString());
		List<Text> myTextList = convertToText(commandHistory);
		//System.out.println(myTextList.size());
		//System.out.println(myTextList.toString());
		//System.out.println(myTextList.get(0).getText());
		//HBox myBox = new HBox();
		//myBox.getChildren().add(new Text("HI"));
		//myBox.getChildren().add(new Text("Hi there"));
		//left.getPaneArray()[0].setContent(myBox);
		//Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
		//paneArr[0].setContent(new ImageView(image));
		//left.getPaneArray()[0].setContent(new ImageView(image));
		//System.out.println(myTextList);
		//left.getPaneArray()[0].setContent(myTextList.get(0));
		//paneArr[index].setContent(new Text(field.getText()));
		//paneArr[0].setContent(myTextList.get(0));
	//	rightPane.getPane().getChildren().add(new Button("Hi"));
	//	rightPane.getPane().getContent().setVisible(true);
		//rightPane.getPane().getContent().get
		myObsList.add(field.getText());
		System.out.println("Observation list is " + myObsList.toString());
		list.setItems(myObsList);
		//pane.setContent(new Button("Hi"));
		//for (Text text : myTextList) {
			//text.setTranslateX(0);
			//text.setTranslateY(50);
			//paneArr[index].setContent(text);
			//paneArr[index].getContent().;
		//	paneArr[index].getContent().setAccessibleText("This hopefully works");
			//System.out.println("Adding " + paneArr[index].getContent().getAccessibleText() + " to pane with ID " + paneArr[index].getId());
		//}
		//System.out.println(paneArr[index].getContent().);
		//System.out.println("Hello there");
		field.clear();
	}
	
	private List<Text> convertToText(List<String> commandList) {
		List<Text> list = new ArrayList<Text>();
		for (String s : commandList) {
			Text textObj = new Text();
			textObj.setText(s);
		//	textObj.setTranslateX(20);
		//	textObj.setTranslateY(50);
			list.add(textObj);
		}
		
		return list;
	}
}
