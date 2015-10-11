package UserInterface.RightPane;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;

public class CommandHistory {
	private Group root;
	
	public CommandHistory() {
		root = makeScrollablePane();
	}
	
	public Group makeScrollablePane() {
		
		Group root = new Group();
		ScrollPane pane = new ScrollPane();
		pane.setPrefSize(200, 600);
		root.getChildren().add(pane);
		return root;
	}
}
