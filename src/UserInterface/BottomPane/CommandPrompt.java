package UserInterface.BottomPane;

import controller.BottomPane;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import slogo_team03.AngleInterface;
import slogo_team03.CommandInputException;
import slogo_team03.CoordinateInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.ReceiveString;
import slogo_team03.VisibleInterface;

import java.util.ResourceBundle;

import UserInterface.CenterPane.DisplayTurtle;

public class CommandPrompt {
	private Group root;
	private TextArea field;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.BottomPane/bottomResource");
	
	public CommandPrompt() {
		root = new Group();
		field = new TextArea();
	}
	public Group getRoot() {
		return root;
	}
	
	public TextArea getField() {
		return field;
	}
	
	public void makeCommandPromptArea(BottomPane bottomController, DisplayTurtle display, ReceiveString rs, CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi) {
		ButtonHandler buttonHandler = new ButtonHandler();
		Button[] buttonArr;
		field.setPrefSize(Double.parseDouble(r.getString("inputBoxWidth")), Double.parseDouble(r.getString("inputBoxHeight")));
		String[] titles = {r.getString("runTitle"), r.getString("clearTitle")};
		double[] translateX = {Double.parseDouble(r.getString("runTranslateX")), Double.parseDouble(r.getString("clearTranslateX"))};
		double[] translateY = {Double.parseDouble(r.getString("runTranslateY")), Double.parseDouble(r.getString("clearTranslateY"))};
		buttonArr = buttonHandler.makeButtons(2, titles, translateX, translateY);
		Button clear = buttonArr[1];
		Button run = buttonArr[0];
		field.setOnKeyPressed(event -> bottomController.handleKeyInput(event.getCode(), field));
		
		clear.setOnAction((event) -> {
			bottomController.clearButtonAction(field, display.getPane());
		}); 
		addToRoot(field, buttonArr, root);
		run.setOnAction((event) -> {
			
			try {
				bottomController.runButtonAction(field, rs, ci, ai, pi, vi);
			} catch (CommandInputException e) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("Invalid Input");
				alert.setContentText("Please check your spelling of " + field.getText());
				alert.showAndWait();
			}
		});
	}
	
	private void addToRoot(TextArea field, Button[] buttonArr, Group root) {
		for (int i = 0; i < buttonArr.length; i++) {
			root.getChildren().add(buttonArr[i]);
		}
		root.getChildren().add(field);
	}
}
