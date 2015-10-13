package UserInterface.BottomPane;

import UserInterface.LeftPane.LeftContent;
import controller.BottomPane;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class CommandPrompt {
	private Group root;
	private LeftContent left;
	private BottomPane bottomPaneController;
	public CommandPrompt() {
		root = makeCommandPromptArea();
		bottomPaneController = new BottomPane();
		left = new LeftContent();
	}
	
	public Group makeCommandPromptArea() {
		Group root = new Group();
		
		ButtonHandler buttonHandler = new ButtonHandler();
		Button[] buttonArr;
		TextArea field = new TextArea();
		field.setPrefSize(825, 50);
		String[] titles = {"Run", "Clear"};
		double[] translateX = {850, 850};
		double[] translateY = {0, 30};
		buttonArr = buttonHandler.makeButtons(2, titles, translateX, translateY);
		Button clear = buttonArr[1];
		Button run = buttonArr[0];
		field.setOnKeyPressed(event -> bottomPaneController.handleKeyInput(event.getCode(), field));
		
		clear.setOnAction((event) -> {
			bottomPaneController.clearButtonAction(field);
		});
		run.setOnAction((event) -> {
			bottomPaneController.runButtonAction(field, left.getPaneArray());
		});
		
		addToRoot(field, buttonArr, root);
		return root;
	}
	
	private void addToRoot(TextArea field, Button[] buttonArr, Group root) {
		for (int i = 0; i < buttonArr.length; i++) {
			root.getChildren().add(buttonArr[i]);
		}
		root.getChildren().add(field);
	}
}
