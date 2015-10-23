package UserInterface;
import java.util.ResourceBundle;

import UserInterface.BottomPane.CommandPrompt;
import UserInterface.CenterPane.DisplayTurtle;
import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import UserInterface.TopPane.MenuHandler;
import controller.BottomPane;
import controller.TopPane;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import slogo_team03.TurtleWorld;


public class TurtleView {
	private Scene myScene;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface/TurtleViewResource");
	
	public TurtleView() {
		TurtleWorld world = new TurtleWorld();
		BorderPane myPane = new BorderPane();
		LeftContent left = new LeftContent();
		CommandHistory history = new CommandHistory();
		CommandPrompt prompt = new CommandPrompt();
		DisplayTurtle turtleDisplay = new DisplayTurtle();
		BottomPane bottomController = new BottomPane(left, history, turtleDisplay);
		prompt.makeCommandPromptArea(bottomController, turtleDisplay, world, world.getTurtle(), world.getTurtle(), world.getTurtle(), world.getTurtle(), world);
		history.makeListView(prompt.getField());
		TopPane topController = new TopPane(turtleDisplay);
		MenuHandler menu = new MenuHandler();
		menu.makeMenuBar(topController, world, world.getTurtle(), world.getTurtle(),world.getTurtle(),world.getTurtle());
		turtleDisplay.makeTurtle(world.getTurtle(), world.getTurtle(), world.getTurtle(), world.getTurtle());
		myPane.setCenter(turtleDisplay.getGroup());
		myPane.setLeft(left.makeListViews());
		myPane.setRight(history.getRoot());
		myPane.setTop(menu.getRoot());
		myPane.setBottom(prompt.getRoot());
		myScene = new Scene(myPane, Integer.parseInt(r.getString("sceneWidth")), Integer.parseInt(r.getString("sceneHeight")));
	}
	
	public Scene getScene() {
		return myScene;
	}
	
}
