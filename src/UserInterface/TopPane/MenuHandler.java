package UserInterface.TopPane;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import java.util.ResourceBundle;
import javafx.geometry.Insets;
import UserInterface.TurtleView;
import UserInterface.CenterPane.DisplayTurtle;
import controller.TopPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slogo_team03.ReceiveString;
import slogo_team03.Turtle;

public class MenuHandler {
	private Group root;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");
	//private TopPane control;
	
	public MenuHandler() {
		//root = new Group();
		//this.control = controller;
	}
	
	public Group getRoot() {
		return this.root;
	}
	
	public void makeMenuBar(TopPane c, ReceiveString rs) {
		MenuBar menuBar = new MenuBar();
		root = new Group();
		
		Menu backgroundColor = new Menu(r.getString("backgroundTitle"));
		ColorPicker cp = new ColorPicker(Color.WHITE);
		MenuItem changeColor = new MenuItem();
		changeColor.setGraphic(cp);
		backgroundColor.getItems().add(changeColor);
		cp.setOnAction((event) -> {
			c.changeBackgroundAction(cp.getValue());
		}); 
			
		Menu image = new Menu(r.getString("imageTitle"));
		addImageItems(image, new String[] {r.getString("imageItem1"), r.getString("imageItem2"), r.getString("imageItem3")}, 
				c);
		//image.setOnAction((event) -> c.changeImage(image.getItems().));
		Menu penColor = new Menu(r.getString("penTitle"));
		ColorPicker cp1 = new ColorPicker();
		MenuItem changeColor1 = new MenuItem();
		changeColor1.setGraphic(cp1);
		penColor.getItems().add(changeColor1);
		cp1.setOnAction((event) -> {
			//Turtle.setPenColor(cp1.getValue());
			c.changePenColorAction(cp1.getValue());
		});
		
		Menu language = new Menu(r.getString("languageTitle"));
		addLanguageItems(language, new String[] {r.getString("languageItem1"),
						r.getString("languageItem2"),
						r.getString("languageItem3"),
						r.getString("languageItem4"),
						r.getString("languageItem5"),
						r.getString("languageItem6"),
						r.getString("languageItem7"),
						r.getString("languageItem8")}, c, rs);
		
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
	}
	
	private Menu addItems(Menu menu, String[] options) {
		for (String s:options) {
			menu.getItems().add(new MenuItem(s));
		}
		return menu;
	}
	
	
	private Menu addLanguageItems(Menu menu, String[] options, TopPane controller, ReceiveString rs) {
		for (String s:options) {
			MenuItem m = new MenuItem(s);
			m.setOnAction((event) -> controller.changeLanguage(s, rs));
			menu.getItems().add(m);
		}
		return menu;
	}
	
	private Menu addImageItems(Menu menu, String[] options, TopPane controller) {
		for (String s:options) {
			MenuItem m = new MenuItem(s);
			m.setOnAction((event) -> controller.changeImage(s));
			menu.getItems().add(m);
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
