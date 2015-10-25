package UserInterface.TopPane;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
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
	
	public void makeMenuBar(TopPane c, ReceiveFromFront rs) {
		MenuBar menuBar = new MenuBar();
		root = new Group();
//		HBox box = new HBox();
//		Menu backgroundColor = new Menu(r.getString("backgroundTitle"));
//		
//		ListView<String> list = new ListView<String>();
//		list.setPrefSize(120, 200);
//		ListView<Integer> indeces = new ListView<Integer>();
//		indeces.setPrefSize(50,  200);
//		ObservableList<Integer> ind = FXCollections.observableArrayList();
//		for (int i = 0; i < 10; i++) {
//			ind.add(i);
//		}
//		ObservableList<String> obs = FXCollections.observableArrayList("salmon", "green", "blue", "red", 
//				"chocolate", "yellow", "pink", "purple", "orange");
//		list.setItems(obs);
//		indeces.setItems(ind);
//		list.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
//			@Override
//			public ListCell<String> call (ListView<String> list) {
//				return new ColorRectCell();
//			}
//		}
//		);
//		box.getChildren().addAll(indeces, list);
//		ColorPicker cp = new ColorPicker(Color.WHITE);
//		MenuItem changeColor = new MenuItem();
//		//changeColor.setGraphic(cp);
//		changeColor.setGraphic(box);
//		backgroundColor.getItems().add(changeColor);
//		cp.setOnAction((event) -> {
//			c.changeBackgroundAction(cp.getValue());
//		}); 
		
		
		Menu backgroundColor = new Menu(r.getString("backgroundTitle"));
		String[] backgroundO = {"salmon", "green", "blue", "red", 
				"chocolate", "yellow", "pink", "purple", "orange"};
		Rectangle[] rects = new Rectangle[backgroundO.length];
		for (int i = 0; i < rects.length; i++) {
			Rectangle rect = new Rectangle(50,10);
			rect.setFill(Color.web(backgroundO[i]));
			rects[i] = rect;
		}
		String[] indices = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		addMenuItem(backgroundColor, indices, rects);
			
		Menu penColor = new Menu(r.getString("penTitle"));
		String[] penO = {"salmon", "green", "blue", "red", 
				"chocolate", "yellow", "pink", "purple", "orange"};
		Rectangle[] penRects = new Rectangle[backgroundO.length];
		for (int i = 0; i < rects.length; i++) {
			Rectangle rect = new Rectangle(50,10);
			rect.setFill(Color.web(penO[i]));
			penRects[i] = rect;
		}
		String[] penIndices = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		addMenuItem(penColor, penIndices, penRects);
		
		
		Menu image = new Menu(r.getString("imageTitle"));
		addImageItems(image, new String[] {r.getString("imageItem1"), r.getString("imageItem2"), r.getString("imageItem3")}, 
				c);
		
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