package UserInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import UserInterface.BottomPane.CommandPrompt;
import UserInterface.CenterPane.DisplayTurtle;
import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import UserInterface.TopPane.MenuHandler;
import UserInterface.TopPane.TopContent;
import controller.BottomPane;
import controller.IFront;
import controller.toppane.UpdateBackgroundColor;
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
		DisplayTurtle turtleDisplay = new DisplayTurtle(world.getTurtle(), world.getTurtle(), world.getTurtle(), world.getTurtle(), world);
		myFrontObjects.add(left);
		myFrontObjects.add(history);
		myFrontObjects.add(turtleDisplay);
		MenuHandler menu = new MenuHandler(turtleDisplay, world, world);
		myFrontObjects.add(menu);

		CommandPrompt prompt = new CommandPrompt(myFrontObjects);
		BottomPane bottomController = new BottomPane(left, history, turtleDisplay);
		//UpdateBackgroundColor topController = new UpdateBackgroundColor(turtleDisplay);
		
		prompt.makeCommandPromptArea(bottomController, world, world);
		history.makeListView(prompt.getField());
		menu.makeMenuBar();
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