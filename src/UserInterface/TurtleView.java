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
import slogo_team03.FileInterface;
import slogo_team03.IPenUpDown;
import slogo_team03.ITurtleProperties;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;
import slogo_team03.StampInterface;


public class TurtleView {
	private Scene myScene;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface/TurtleViewResource");
	private List<IFront> myFrontObjects;
	private PassToFrontInterface pf;
	List<ITurtleProperties> tp;
	IPenUpDown pUD;
	StampInterface si;
	ReceiveFromFront rf;
	FileInterface fi;
	
	public TurtleView(PassToFrontInterface pass, List<ITurtleProperties> turtleProps, IPenUpDown penUpDown, StampInterface stamp,
			ReceiveFromFront receive, FileInterface file) {
		this.pf = pass;
		this.tp = turtleProps;
		this.pUD = penUpDown;
		this.si = stamp;
		this.rf = receive;
		this.fi = file;
		
		
		myFrontObjects = new ArrayList<IFront>();
		BorderPane myPane = new BorderPane();
		LeftContent left = new LeftContent(pf);
		CommandHistory history = new CommandHistory(pf);
		DisplayTurtle turtleDisplay = new DisplayTurtle(tp, pUD, pf, si, rf);
		myFrontObjects.add(left);
		myFrontObjects.add(history);
		myFrontObjects.add(turtleDisplay);
		MenuHandler menu = new MenuHandler(turtleDisplay, rf, pf, fi);
		myFrontObjects.add(menu);

		CommandPrompt prompt = new CommandPrompt(myFrontObjects);
		BottomPane bottomController = new BottomPane(left, history, turtleDisplay);
		myPane.setCenter(turtleDisplay.getGroup());
		myPane.setLeft(left.makeListViews());
		myPane.setRight(history.makeListView(prompt.getField()));
		myPane.setTop(menu.makeMenuBar());
		myPane.setBottom(prompt.makeCommandPromptArea(bottomController, rf, pf));
		myScene = new Scene(myPane, Integer.parseInt(r.getString("sceneWidth")), Integer.parseInt(r.getString("sceneHeight")));
	}
	
	public Scene getScene() {
		return myScene;
	}
	
}