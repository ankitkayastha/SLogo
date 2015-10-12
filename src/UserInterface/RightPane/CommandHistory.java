package UserInterface.RightPane;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

public class CommandHistory {
	private Group root;
	
	public CommandHistory() {
		root = makeScrollablePane();
	}
	
	public Group makeScrollablePane() {
		
		Group root = new Group();
		Text title = new Text();
		title.setTranslateY(50);
		title.setTranslateX(50);
		title.setText("Command History");
		ScrollPane pane = new ScrollPane();
		pane.setPrefSize(200, 600);
		pane.setTranslateY(60);
		root.getChildren().add(pane);
		root.getChildren().add(title);

		return root;
	}
}
