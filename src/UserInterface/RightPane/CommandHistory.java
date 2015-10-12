package UserInterface.RightPane;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class CommandHistory {
	private Group root;
	
	public CommandHistory() {
		root = makeScrollablePane();
	}
	
	public Group makeScrollablePane() {
		
		Group root = new Group();
		ScrollPane pane = new ScrollPane();
		double prefWidth = 150;
		double prefHeight = 675/2 - 35;
		String title = "Command History";
		Text text = new Text();
		text.setText(title);
		text.setTranslateY(10);
		text.setTextAlignment(TextAlignment.JUSTIFY);
		pane.setPrefSize(200, 600);
		root.getChildren().add(pane);
		root.getChildren().add(text);
		return root;
	}
}
