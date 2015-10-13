package UserInterface.BottomPane;

import UserInterface.LeftPane.LeftContent;
import controller.BottomPane;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.ResourceBundle;


public class CommandPrompt {
	private Group root;
	private LeftContent left;
	private BottomPane bottomPaneController;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.BottomPane/bottomResource");
	
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
		field.setPrefSize(Double.parseDouble(r.getString("inputBoxWidth")), Double.parseDouble(r.getString("inputBoxHeight")));
		String[] titles = {r.getString("runTitle"), r.getString("clearTitle")};
		double[] translateX = {Double.parseDouble(r.getString("runTranslateX")), Double.parseDouble(r.getString("clearTranslateX"))};
		double[] translateY = {Double.parseDouble(r.getString("runTranslateY")), Double.parseDouble(r.getString("clearTranslateY"))};
		buttonArr = buttonHandler.makeButtons(2, titles, translateX, translateY);
		Button clear = buttonArr[1];
		Button run = buttonArr[0];
		clear.setOnAction((event) -> {
			bottomPaneController.clearButtonAction(field);
		});
		run.setOnAction((event) -> {
			bottomPaneController.runButtonAction(field, left.getPaneArray(), 0);
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
