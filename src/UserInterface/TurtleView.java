package UserInterface;
import java.util.ResourceBundle;

import UserInterface.BottomPane.CommandPrompt;
import UserInterface.CenterPane.DisplayTurtle;
import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import UserInterface.TopPane.MenuHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TurtleView {
	private Scene myScene;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface/TurtleViewResource");
	
	public TurtleView() {
		BorderPane myPane = new BorderPane();
		LeftContent left = new LeftContent();
		CommandHistory history = new CommandHistory();
		CommandPrompt prompt = new CommandPrompt(left, history);

		history.makeListView();
	//	Group rightPane = history.makeScrollablePane();
		DisplayTurtle turtleDisplay = new DisplayTurtle();
		MenuHandler menu = new MenuHandler();
		myPane.setCenter(turtleDisplay.makeTurtle());
		myPane.setLeft(left.makeScrollablePanes());
		myPane.setRight(history.getListView());
		myPane.setTop(menu.makeMenuBar());
		//myPane.setTop(prompt.makeCommandPromptArea());
		myPane.setBottom(prompt.makeCommandPromptArea());
		myScene = new Scene(myPane, Integer.parseInt(r.getString("sceneWidth")), Integer.parseInt(r.getString("sceneHeight")), Color.BLACK);
	}
	
	public Scene getScene() {
		return myScene;
	}
	
}
