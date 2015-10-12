package UserInterface.TopPane;

import javafx.scene.Group;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Hyperlink;

public class MenuHandler {
	private Group root;
	
	public MenuHandler() {
		root = makeMenuBar();
	}
	
	public Group makeMenuBar() {
		Group root = new Group();
		MenuBar menuBar = new MenuBar();
		Menu backgroundColor = new Menu("Background Color");
		addItems(backgroundColor, new String[] {"Blue", "Yellow", "White"});
		Menu image = new Menu("Change Image");
		addItems(image, new String[] {"Turtle", "RCD", "Circle"});
		Menu penColor = new Menu("Change Pen Color");
		addItems(penColor, new String[] {"Black", "Red", "Yellow", "Orange"});
		Menu language = new Menu("Change Language");
		addItems(language, new String[] {"Chinese", "English", "French", "German", "Italian", "Portuguese", "Russian", "Spanish"});
		menuBar.getMenus().addAll(backgroundColor, image, penColor, language);
		root.getChildren().add(menuBar);
		Hyperlink link = new Hyperlink("Help page");
		link.setTranslateX(830);
		root.getChildren().add(link);
		return root;
	}
	
	private Menu addItems(Menu menu, String[] options) {
		for (String s:options) {
			menu.getItems().add(new CheckMenuItem(s));
		}
		return menu;
	}
}
