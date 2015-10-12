package UserInterface;
import UserInterface.BottomPane.CommandPrompt;
import UserInterface.CenterPane.DisplayTurtle;
import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import UserInterface.TopPane.MenuHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class TurtleView {
	private Scene myScene;
	public TurtleView() {
		BorderPane myPane = new BorderPane();
		LeftContent left = new LeftContent();
		CommandPrompt prompt = new CommandPrompt();
		CommandHistory history = new CommandHistory();
		DisplayTurtle turtleDisplay = new DisplayTurtle();
		MenuHandler menu = new MenuHandler();
		myPane.setCenter(turtleDisplay.makeTurtle());
		myPane.setLeft(left.makeScrollablePanes());
		myPane.setRight(history.makeScrollablePane());
		myPane.setTop(menu.makeMenuBar());
		//myPane.setTop(prompt.makeCommandPromptArea());
		myPane.setBottom(prompt.makeCommandPromptArea());
		myScene = new Scene(myPane, 900, 700);
	}
	
	public Scene getScene() {
		return myScene;
	}
}
