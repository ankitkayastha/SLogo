package UserInterface.TopPane;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import UserInterface.TurtleView;
import UserInterface.CenterPane.DisplayTurtle;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public class NewWorkspaceMenu extends AbstractMenu implements IMenu{

	ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");

	@Override
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf) {
		Menu newWorkspace = new Menu(r.getString("newWorkspaceTitle"));
		List<String> workspaceItems = new ArrayList<String>();
		workspaceItems.add(r.getString("addWorkspace"));
		List<String> workspaceImages = new ArrayList<String>();
		workspaceImages.add(r.getString("plus"));
		Rectangle[] workspaceRects = makeImageNodes(workspaceImages, 20, 20);
		addMenuItem(newWorkspace, workspaceItems, workspaceRects);
		for (MenuItem m : newWorkspace.getItems()) {
			m.setOnAction((event) -> 
			{
				Stage stage = new Stage();
				TurtleView view = new TurtleView();
				stage.setScene(view.getScene());
				stage.show();
				}
			);
		}
		return newWorkspace;
	}

}