package UserInterface.TopPane;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

import java.util.ResourceBundle;

import controller.IFront;
import controller.TopPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import slogo_team03.AngleInterface;
import slogo_team03.CoordinateInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.ReceiveFromFront;
import slogo_team03.VisibleInterface;

public class MenuHandler implements IFront {
	private Group root;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");

	public Group getRoot() {
		return this.root;
	}
	
	private Rectangle[] makeColorNodes(String[] options) {
		Rectangle[] rects = new Rectangle[options.length];
		for (int i = 0; i < rects.length; i++) {
			Rectangle rect = new Rectangle(50,10);
			rect.setFill(Color.web(options[i]));
			rects[i] = rect;
		}
		return rects;
	}
	
	private Rectangle[] makeImageNodes(String[] options, int width, int length) {
		Rectangle[] rects = new Rectangle[options.length];
		for (int i = 0; i < rects.length; i++) {
			Rectangle rect = new Rectangle(width,length);
			rect.setFill(new ImagePattern(new Image(getClass().getClassLoader().getResourceAsStream(options[i]))));
			rects[i] = rect;
		}
		return rects;
	}
	
	public void makeMenuBar(TopPane c, ReceiveFromFront rs) {
		MenuBar menuBar = new MenuBar();
		root = new Group();
		
		Menu backgroundColor = new Menu(r.getString("backgroundTitle"));
		String[] backgroundOptions = {"salmon", "green", "blue", "red", 
				"chocolate", "yellow", "pink", "purple", "orange"};
		Rectangle[] backgroundColors = makeColorNodes(backgroundOptions);
		String[] indices = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		addMenuItem(backgroundColor, indices, backgroundColors);
		
		
		
		Menu penColor = new Menu(r.getString("penTitle"));
		String[] penOptions = {"salmon", "green", "blue", "red", 
				"chocolate", "yellow", "pink", "purple", "orange"};
		Rectangle[] penColors = makeColorNodes(penOptions);
		String[] penIndices = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		addMenuItem(penColor, penIndices, penColors);
		
		
		Menu image = new Menu(r.getString("imageTitle"));
		String[] imageOptions = {r.getString("imageItem1"), r.getString("imageItem2"), r.getString("imageItem3")};
		Rectangle[] imageRects = makeImageNodes(imageOptions, 50, 50);
		addMenuItem(image, imageOptions, imageRects);
		
		
		Menu language = new Menu(r.getString("languageTitle"));
		String[] languageOptions = {r.getString("languageItem1"),
				r.getString("languageItem2"),
				r.getString("languageItem3"),
				r.getString("languageItem4"),
				r.getString("languageItem5"),
				r.getString("languageItem6"),
				r.getString("languageItem7"),
				r.getString("languageItem8")};
		String[] flagOptions = {r.getString("languageFlag1"),
				r.getString("languageFlag2"),
				r.getString("languageFlag3"),
				r.getString("languageFlag4"),
				r.getString("languageFlag5"),
				r.getString("languageFlag6"),
				r.getString("languageFlag7"),
				r.getString("languageFlag8")};
		Rectangle[] flagRects = makeImageNodes(flagOptions, 75, 50);
		addMenuItem(language, languageOptions, flagRects);
		
		Menu help = new Menu(r.getString("helpTitle"));
		String[] helpOptions = {r.getString("helpLink1"), r.getString("helpLink2")};
		String[] helpImages = {r.getString("linkImage1"), r.getString("linkImage2")};
		Rectangle[] helpRects = makeImageNodes(helpImages, 20, 20);
		addMenuItem(help, helpOptions, helpRects);
		
		
		
		menuBar.getMenus().addAll(backgroundColor, image, penColor, language, help);
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
		return menu;
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		
	}
	
	private class penAction implements EventHandler<ActionEvent> {
        @Override      
        public void handle (ActionEvent event) {       
                 
        }      
    }
}