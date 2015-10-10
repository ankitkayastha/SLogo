package UserInterface;
import UserInterface.BottomPane.CommandPrompt;
import UserInterface.LeftPane.LeftContent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class TurtleView {
	private Scene myScene;
	public TurtleView() {
		BorderPane myPane = new BorderPane();
		LeftContent left = new LeftContent();
		CommandPrompt prompt = new CommandPrompt();
		//myPane.setCenter(value);
		myPane.setLeft(left.makeScrollablePanes());
		//myPane.setRight(value);
		//myPane.setTop(prompt.makeCommandPromptArea());
		//BorderPane.setMargin(prompt.makeCommandPromptArea(), new Insets(12, 12, 12, 12));
		myPane.setBottom(prompt.makeCommandPromptArea());
		myScene = new Scene(myPane, 900, 675);
	}
	
	public Scene getScene() {
		return myScene;
	}
}
