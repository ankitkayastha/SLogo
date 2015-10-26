package UserInterface.TopPane;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Hyperlink;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import UserInterface.CenterPane.DisplayTurtle;
import controller.IFront;
import controller.toppane.UpdateBackgroundColor;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;


public class MenuHandler implements IFront {
	private Group root;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");
	private DisplayTurtle display;
	private ReceiveFromFront rf;
	private PassToFrontInterface pf;
	private Menu backgroundColor;
	
	public MenuHandler(DisplayTurtle disp, ReceiveFromFront receive, PassToFrontInterface pass) {
		this.display = disp;
		this.rf = receive;
		this.pf = pass;
	}
	
	public Group getRoot() {
		return this.root;
	}
	
	private Rectangle[] makeColorNodes(Color[] options) {
		Rectangle[] rects = new Rectangle[options.length];
		for (int i = 0; i < rects.length; i++) {
			Rectangle rect = new Rectangle(50,10);
			rect.setFill(options[i]);
			//System.out.println(rect.getFill().);
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
	
	public void makeMenuBar() {
		MenuBar menuBar = new MenuBar();
		root = new Group();
		
		backgroundColor = new Menu(r.getString("backgroundTitle"));
		Map<Double, Color> backgroundColorMap = pf.getPalette();
		Color[] colors = new Color[backgroundColorMap.keySet().size()];
		List<String> indices = new ArrayList<String>();
		UpdateBackgroundColor update = new UpdateBackgroundColor(display, rf, pf);
		for (int i = 0; i < backgroundColorMap.keySet().size(); i++) {
			indices.add(Double.toString(i));
			colors[i] = backgroundColorMap.get((double) i);
		}
		Rectangle[] backgroundColors = makeColorNodes(colors);
		addMenuItem(backgroundColor, indices, backgroundColors);
		for (MenuItem m: backgroundColor.getItems()) {
			m.setOnAction((event) -> update.changeBackgroundAction(m.getText()));
		}
		
		
		Menu penColor = new Menu(r.getString("penTitle"));
		String[] penOptions = {"salmon", "green", "blue", "red", 
				"chocolate", "yellow", "pink", "purple", "orange"};
//		Rectangle[] penColors = makeColorNodes(penOptions);
		String[] penIndices = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
		addMenuItem(penColor, indices, backgroundColors);
		for (MenuItem m: backgroundColor.getItems()) {
			m.setOnAction((event) -> update.changeBackgroundAction(m.getText()));
		}
		
		Menu image = new Menu(r.getString("imageTitle"));
		String[] imageOptions = {r.getString("imageItem1"), r.getString("imageItem2"), r.getString("imageItem3")};
		Rectangle[] imageRects = makeImageNodes(imageOptions, 50, 50);
//		addMenuItem(image, imageOptions, imageRects);
		
		
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
//		addMenuItem(language, languageOptions, flagRects);
		
		Menu penProperties = new Menu(r.getString("penPropertyTitle"));
		
		Menu penUpDown = new Menu(r.getString("penUpDown"));
		List<String> penUpDownOptions = new ArrayList<String>();
		penUpDownOptions.add(r.getString("penUp"));
		penUpDownOptions.add(r.getString("penDown"));
		//String[] penUpDownOptions = {r.getString("penUp"), r.getString("penDown")};
		String[] arrowOptions = {r.getString("penUpImage"), r.getString("penDownImage")};
		Rectangle[] arrowRects = makeImageNodes(arrowOptions, 10,10);
		//addMenuItem(penUpDown, penUpDownOptions, arrowRects);
		
		Menu penThickness = new Menu(r.getString("penThickness"));
		String[] penThicknessOptions = {r.getString("thickness1"), r.getString("thickness2"), r.getString("thickness3"), r.getString("thickness4")};
		String[] penThicknessImage = {r.getString("thicknessImage"), r.getString("thicknessImage"), r.getString("thicknessImage"), r.getString("thicknessImage")};
		Rectangle[] penThicknessRects = makeImageNodes(penThicknessImage, 25, 25);
//		addMenuItem(penThickness, penThicknessOptions, penThicknessRects);
		
		Menu penType = new Menu(r.getString("penLineType"));
		String[] lineTypes = {r.getString("lineType1"), r.getString("lineType2"), r.getString("lineType3")};
		String[] lineTypeImage = {r.getString("lineImage1"), r.getString("lineImage2"), r.getString("lineImage3")};
		Rectangle[] lineRects = makeImageNodes(lineTypeImage, 60, 60);
//		addMenuItem(penType, lineTypes, lineRects);
		
		penProperties.getItems().addAll(penUpDown, penThickness, penType);
		
		Menu help = new Menu(r.getString("helpTitle"));
		String[] helpOptions = {r.getString("helpLink1"), r.getString("helpLink2")};
		String[] helpImages = {r.getString("linkImage1"), r.getString("linkImage2")};
		Rectangle[] helpRects = makeImageNodes(helpImages, 20, 20);
//		addMenuItem(help, helpOptions, helpRects);
		
		
		
		menuBar.getMenus().addAll(backgroundColor, image, penColor, language, penProperties, help);
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
	
	public void addMenuItem(Menu menu, List<String> options, Node[] graphics) {
		for (int i = 0; i < options.size(); i++) {
			MenuItem m = new MenuItem(options.get(i), graphics[i]);
			menu.getItems().add(m);
		}
	}


	@Override
	public void update() {
		Map<Double, Color> colorMap = pf.getPalette();
		ObservableList<MenuItem> list = backgroundColor.getItems();
		for (int i = 0; i < colorMap.keySet().size(); i++) {
			Rectangle rect = (Rectangle) list.get(i).getGraphic();
			rect.setFill(colorMap.get((double) i));
		}
	
			
	}
		
}
