package UserInterface;
import java.util.ResourceBundle;

import UserInterface.BottomPane.CommandPrompt;
import UserInterface.CenterPane.DisplayTurtle;
import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import UserInterface.TopPane.MenuHandler;
import controller.BottomPane;
import javafx.scene.Scene;
import javafx.scene.layout.*;


public class TurtleView {
	private Scene myScene;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface/TurtleViewResource");
	
	public TurtleView() {
		BorderPane myPane = new BorderPane();
		LeftContent left = new LeftContent();
		CommandHistory history = new CommandHistory();
		CommandPrompt prompt = new CommandPrompt();
		BottomPane bottomController = new BottomPane(left, history);
		prompt.makeCommandPromptArea(bottomController);
		history.makeListView(prompt.getField());
		DisplayTurtle turtleDisplay = new DisplayTurtle();
		MenuHandler menu = new MenuHandler();
		myPane.setCenter(turtleDisplay.makeTurtle());
		myPane.setLeft(left.makeScrollablePanes());
		myPane.setRight(history.getRoot());
		myPane.setTop(menu.makeMenuBar());
		myPane.setBottom(prompt.getRoot());
		myScene = new Scene(myPane, Integer.parseInt(r.getString("sceneWidth")), Integer.parseInt(r.getString("sceneHeight")));
	}
	
	public Scene getScene() {
		return myScene;
	}
}
