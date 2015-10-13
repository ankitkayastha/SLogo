package UserInterface.RightPane;

import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import java.util.ResourceBundle;


public class CommandHistory {
	private Group root;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.RightPane/RightResource");
	
	public CommandHistory() {
		root = makeScrollablePane();
	}
	
	public Group makeScrollablePane() {
		
		Group root = new Group();
		Text title = new Text();
		title.setTranslateY(Integer.parseInt(r.getString("translateY")));
		title.setTranslateX(Integer.parseInt(r.getString("translateX")));
		title.setText(r.getString("title"));
		ScrollPane pane = new ScrollPane();
		pane.setPrefSize(Double.parseDouble(r.getString("prefWidth")), Double.parseDouble(r.getString("prefHeight")));
		root.getChildren().add(pane);
		root.getChildren().add(title);
		return root;
	}
}
