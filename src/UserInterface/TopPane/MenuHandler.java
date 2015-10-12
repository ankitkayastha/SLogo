package UserInterface.TopPane;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Hyperlink;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
		Hyperlink link = addLink("Help page", 830);
		WebView browser = new WebView();
		WebEngine webEngine = browser.getEngine();
		link.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				createPopup(browser);
				webEngine.load("http://www.cs.duke.edu/courses/cps108/current/assign/03_slogo/commands.php");
			}
		});
		root.getChildren().addAll(link);
		return root;
	}
	
	private Menu addItems(Menu menu, String[] options) {
		for (String s:options) {
			menu.getItems().add(new MenuItem(s));
		}
		return menu;
	}
	
	private Hyperlink addLink(String s, double translateX) {
		Hyperlink link = new Hyperlink(s);
		link.setTranslateX(translateX);
		return link;
	}
	
	private void createPopup(WebView w) {
		FlowPane pane = new FlowPane();
		pane.getChildren().add(w);
		Scene s = new Scene(pane, 800, 600);
		Stage newStage = new Stage();
		newStage.setScene(s);
		newStage.initModality(Modality.NONE);
		newStage.setTitle("Command List");
		newStage.show();
	}
}
