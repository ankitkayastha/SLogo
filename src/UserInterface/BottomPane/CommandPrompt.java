package UserInterface.BottomPane;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CommandPrompt {
	private Group root;
	
	public CommandPrompt() {
		root = makeCommandPromptArea();
	}
	
	public Group makeCommandPromptArea() {
		Group root = new Group();
		//ScrollPane field = new ScrollPane();
		
		ButtonHandler buttonHandler = new ButtonHandler();
		Button[] buttonArr;
		TextArea field = new TextArea();
		field.setPrefSize(825, 50);
		String[] titles = {"Run", "Clear"};
		double[] translateX = {850, 850};
		double[] translateY = {0, 30};
		buttonArr = buttonHandler.makeButtons(2, titles, translateX, translateY);
		Button clear = buttonArr[1];
		clear.setOnAction((event) -> {
			field.clear();
		});
		
		addToRoot(field, buttonArr, root);
		return root;
	}
	
	private void addToRoot(TextArea field, Button[] buttonArr, Group root) {
		for (int i = 0; i < buttonArr.length; i++) {
			root.getChildren().add(buttonArr[i]);
		}
		//root.getChildren().add(pane);
		root.getChildren().add(field);
	}
}
