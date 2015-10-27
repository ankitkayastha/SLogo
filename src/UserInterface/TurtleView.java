package UserInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import UserInterface.BottomPane.CommandPrompt;
import UserInterface.CenterPane.DisplayTurtle;
import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import UserInterface.TopPane.MenuHandler;
import controller.BottomPane;
import controller.IFront;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import slogo_team03.TurtleWorld;


public class TurtleView {
	private Scene myScene;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface/TurtleViewResource");
	private List<IFront> myFrontObjects;
	
	public TurtleView() {
		myFrontObjects = new ArrayList<IFront>();
		TurtleWorld world = new TurtleWorld();
		BorderPane myPane = new BorderPane();
		LeftContent left = new LeftContent(world);
		CommandHistory history = new CommandHistory(world);
		DisplayTurtle turtleDisplay = new DisplayTurtle(world.getTurtle(), world, world, world);
		myFrontObjects.add(left);
		myFrontObjects.add(history);
		myFrontObjects.add(turtleDisplay);
		MenuHandler menu = new MenuHandler(turtleDisplay, world, world);
		myFrontObjects.add(menu);

		CommandPrompt prompt = new CommandPrompt(myFrontObjects);
		BottomPane bottomController = new BottomPane(left, history, turtleDisplay);
		myPane.setCenter(turtleDisplay.getGroup());
		myPane.setLeft(left.makeListViews());
		myPane.setRight(history.makeListView(prompt.getField()));
		myPane.setTop(menu.makeMenuBar());
		myPane.setBottom(prompt.makeCommandPromptArea(bottomController, world, world));
		myScene = new Scene(myPane, Integer.parseInt(r.getString("sceneWidth")), Integer.parseInt(r.getString("sceneHeight")));
	}
	
	public Scene getScene() {
		return myScene;
	}
	
}