package UserInterface.TopPane;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Hyperlink;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import controller.TopPane;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slogo_team03.AngleInterface;
import slogo_team03.CoordinateInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.ReceiveString;
import slogo_team03.VisibleInterface;

public class TopContent {
	private Group root;
	private MenuHandler mh;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");

	public TopContent() {
		mh = new MenuHandler();
		root = makeTopContent(null, null, null, null, null, null);
	}
	
	
	public Group makeTopContent(TopPane c, ReceiveString rs) {
		
		MenuBar menuBar = new MenuBar();
		root = new Group();
		
		Menu backgroundColor = new Menu(r.getString("backgroundTitle"));
		String[] backgroundO = {"salmon", "green", "blue", "red", 
				"chocolate", "yellow", "pink", "purple", "orange"};
		Rectangle[] rects = new Rectangle[backgroundO.length];
		for (int i = 0; i < rects.length; i++) {
			Rectangle rect = new Rectangle(10,10);
			rect.setFill(Color.web(backgroundO[i]));
			rects[i] = rect;
		}
		String[] indices = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		addMenuItem(backgroundColor, indices, rects);
		
		
		
		
//		Menu backgroundColor = new Menu(r.getString("backgroundTitle"));
//		ColorPicker cp = new ColorPicker(Color.WHITE);
//		MenuItem changeColor = new MenuItem();
//		changeColor.setGraphic(cp);
//		backgroundColor.getItems().add(changeColor);
//		cp.setOnAction((event) -> {
//			c.changeBackgroundAction(cp.getValue(), ci, ai, pi, vi);
//		}); 
			
		Menu image = new Menu(r.getString("imageTitle"));
		
		
		addImageItems(image, new String[] {r.getString("imageItem1"), r.getString("imageItem2"), r.getString("imageItem3")}, 
				c, ci, ai,pi,vi);
		
		Menu penColor = new Menu(r.getString("penTitle"));
		ColorPicker cp1 = new ColorPicker();
		MenuItem changeColor1 = new MenuItem();
		changeColor1.setGraphic(cp1);
		penColor.getItems().add(changeColor1);
		cp1.setOnAction((event) -> {
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
		return root;
	}
	
	private List<String> getOptions(String[] options) {
		List<String> o = new ArrayList<String>();
		for (String s:options) {
			o.add(r.getString(s));
		}
		return o;
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
	
	private Menu addImageItems(Menu menu, String[] options, TopPane controller, CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi) {
		for (String s:options) {
			MenuItem m = new MenuItem(s);
			m.setOnAction((event) -> controller.changeImageAction(s, ci, ai, pi, vi));
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
	
	public Menu addMenuItem(Menu menu, String[] options, Node[] images) {
		for (int i = 0; i < options.length; i++) {
			MenuItem m = new MenuItem(options[i], images[i]);
			//m.setOnAction(event);
			menu.getItems().add(m);
		}
		
	}
}
