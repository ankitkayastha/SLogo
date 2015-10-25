package UserInterface.TopPane;
import java.util.List;
import java.util.ResourceBundle;

import controller.TopPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import slogo_team03.AngleInterface;
import slogo_team03.CoordinateInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.VisibleInterface;

public class MenuHandler {
	private MenuBar menuBar;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");
	
	public MenuHandler() {
		menuBar = new MenuBar();
	}
	
	public Menu addMenuItem(Menu menu, List<String> options, TopPane controller, CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi,
			EventHandler<ActionEvent> handler, Color color) {
		Rectangle rect = new Rectangle(10,10);
		rect.setFill(color);
		for (String s:options) {
			MenuItem m = new MenuItem(s, rect);
			m.setOnAction(handler);
			menu.getItems().add(m);
		}
		return menu;
	}
}
