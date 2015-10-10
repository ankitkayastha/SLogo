package UserInterface;
import UserInterface.LeftPane.LeftPane;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class TurtleView {
	private Scene myScene;
	public TurtleView() {
		BorderPane myPane = new BorderPane();
		LeftPane left = new LeftPane();
		//myPane.setCenter(value);
		myPane.setLeft(left.makeScrollablePanes());
		//myPane.setRight(value);
		//myPane.setTop(value);
		//myPane.setBottom(value);
		myScene = new Scene(myPane, 900, 675);
	}
	
	public Scene getScene() {
		return myScene;
	}
}
