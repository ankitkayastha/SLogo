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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import UserInterface.TurtleView;
import UserInterface.CenterPane.DisplayTurtle;
import controller.IFront;
import controller.toppane.UpdateBackgroundColor;
import controller.toppane.UpdateFile;
import controller.toppane.UpdateHelpPage;
import controller.toppane.UpdateImage;
import controller.toppane.UpdateLanguage;
import controller.toppane.UpdatePenColor;
import controller.toppane.UpdatePenProperties;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import slogo_team03.FileInterface;
import slogo_team03.Main;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;


public class MenuHandler implements IFront {
	private Group root;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");
	private DisplayTurtle display;
	private ReceiveFromFront rf;
	private PassToFrontInterface pf;
	private FileInterface fi;
	private Menu backgroundColor;
	private Menu penColor;
	private Menu image;
	private Menu penUpDown;
	private Menu penSize;
	private Menu penType;
	
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

	private Rectangle[] makeImageNodes(List<String> options, int width, int length) {
		Rectangle[] rects = new Rectangle[options.size()];
		for (int i = 0; i < rects.length; i++) {
			Rectangle rect = new Rectangle(width,length);
			rect.setFill(new ImagePattern(new Image(getClass().getClassLoader().getResourceAsStream(options.get(i)))));
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


		penColor = new Menu(r.getString("penTitle"));

		UpdatePenColor updatePen = new UpdatePenColor(rf);
		Rectangle[] penColors = makeColorNodes(colors);
		addMenuItem(penColor, indices, penColors);
		for (MenuItem m: penColor.getItems()) {
			m.setOnAction((event) -> updatePen.changePenColorAction(m.getText()));
		}

		image = new Menu(r.getString("imageTitle"));
		List<String> imageOptions = new ArrayList<String>();
		imageOptions.add(r.getString("imageItem1"));
		imageOptions.add(r.getString("imageItem2"));
		imageOptions.add(r.getString("imageItem3"));
		UpdateImage imageChanger = new UpdateImage(display);
		Rectangle[] imageRects = makeImageNodes(imageOptions, 50, 50);
		addMenuItem(image, imageOptions, imageRects);
		for (MenuItem m : image.getItems()) {
			m.setOnAction((event) -> imageChanger.refreshImage(m.getText()));
		}


		Menu language = new Menu(r.getString("languageTitle"));
		UpdateLanguage updateLang = new UpdateLanguage(rf);

		List<String> languageOptions = new ArrayList<String>();
		List<String> flagOptions = new ArrayList<String>();

		for (int i = 1; i <= 8; i++) {
			languageOptions.add(r.getString("languageItem" + Integer.toString(i)));
			flagOptions.add(r.getString("languageFlag" + Integer.toString(i)));
		}

		Rectangle[] flagRects = makeImageNodes(flagOptions, 75, 50);
		addMenuItem(language, languageOptions, flagRects);
		for (MenuItem m: language.getItems()) {
			m.setOnAction((event) -> updateLang.changeLanguage(m.getText()));
		}



		Menu penProperties = new Menu(r.getString("penPropertyTitle"));
		penUpDown = new Menu(r.getString("penUpDown"));
		List<String> penUpDownOptions = new ArrayList<String>();
		penUpDownOptions.add(r.getString("penUp"));
		penUpDownOptions.add(r.getString("penDown"));

		List<String> arrowOptions = new ArrayList<String>();
		arrowOptions.add(r.getString("penUpImage"));
		arrowOptions.add( r.getString("penDownImage"));
		UpdatePenProperties updatePenProp = new UpdatePenProperties(display, rf);
		Rectangle[] arrowRects = makeImageNodes(arrowOptions, 10,10);
		addMenuItem(penUpDown, penUpDownOptions, arrowRects);
		for (MenuItem m : penUpDown.getItems()) {
			m.setOnAction((event) -> updatePenProp.changePenUpDown(m.getText()));
		}
		
		
		penSize = new Menu(r.getString("penSize"));
		//String[] penThicknessOptions = {r.getString("thickness1"), r.getString("thickness2"), r.getString("thickness3"), r.getString("thickness4")};
		List<String> penThicknessOptions = new ArrayList<String>();
		for (int i = 1; i <= 4; i++) {
			penThicknessOptions.add(r.getString("thickness" + Integer.toString(i)));
		}
		List<String> penThicknessImage = new ArrayList<String>();
		for (int i = 0; i < 4; i++) {
			penThicknessImage.add(r.getString("thicknessImage"));
		}
		//String[] penThicknessImage = {r.getString("thicknessImage"), r.getString("thicknessImage"), r.getString("thicknessImage"), r.getString("thicknessImage")};
		Rectangle[] penThicknessRects = makeImageNodes(penThicknessImage, 25, 25);
		addMenuItem(penSize, penThicknessOptions, penThicknessRects);
		for (MenuItem m : penSize.getItems()) {
			m.setOnAction((event) -> updatePenProp.changePenThickness(m.getText()));
		}
		
		
		
		penType = new Menu(r.getString("penLineType"));
		//String[] lineTypes = {r.getString("lineType1"), r.getString("lineType2"), r.getString("lineType3")};
		List<String> lineTypes = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			lineTypes.add(r.getString("lineType" + Integer.toString(i)));
		}
		List<String> lineTypeImage = new ArrayList<String>();
		for (int i = 1; i <= 3; i++) {
			lineTypeImage.add(r.getString("lineImage" + Integer.toString(i)));
		}
		//String[] lineTypeImage = {r.getString("lineImage1"), r.getString("lineImage2"), r.getString("lineImage3")};
		Rectangle[] lineRects = makeImageNodes(lineTypeImage, 60, 60);
		addMenuItem(penType, lineTypes, lineRects);
		for (MenuItem m : penType.getItems()) {
			updatePenProp.changeLineType(m.getText());
		}
		
		penProperties.getItems().addAll(penUpDown, penSize, penType);
		

		Menu help = new Menu(r.getString("helpTitle"));
		List<String> helpOptions = new ArrayList<String>();
		List<String> helpPics = new ArrayList<String>();
		helpOptions.add(r.getString("link1"));
		helpOptions.add(r.getString("link2"));
		helpPics.add(r.getString("linkImage1"));
		helpPics.add(r.getString("linkImage2"));
		Rectangle[] helpRects = makeImageNodes(helpPics, 20, 20);
		addMenuItem(help, helpOptions, helpRects);
		UpdateHelpPage updateHelp = new UpdateHelpPage();
		for (MenuItem m: help.getItems()) {
			m.setOnAction((event) -> updateHelp.openPage(m.getText()));
		}
		
		/*Menu file = new Menu(r.getString("fileTitle"));
		List<String> fileOptions = new ArrayList<String>();
		List<String> fileImages = new ArrayList<String>();
		fileOptions.add(r.getString("saveFile"));
		fileOptions.add(r.getString("loadFile"));
		fileImages.add(r.getString("saveImage"));
		fileImages.add(r.getString("loadImage"));
		UpdateFile updateFile = new UpdateFile(fi);
		Rectangle[] fImages = makeImageNodes(fileImages, 20, 20);
		addMenuItem(file, fileOptions, fImages);

		for (int i = 0; i < fileOptions.size(); i++) {
			if (i == 0) {
				file.getItems().get(i).setOnAction((event) -> updateFile.saveFile());
			}
			else {
				file.getItems().get(i).setOnAction((event) -> updateFile.loadFile());
			}
		}
		*/
		
		
		Menu changeShape = new Menu(r.getString("changeShape"));
		List<String> shapeItems = new ArrayList<String>();
		shapeItems.add(r.getString("circle"));
		List<String> shapeImages = new ArrayList<String>();
		shapeImages.add(r.getString("circleImage"));
		Rectangle[] shapeRects = makeImageNodes(shapeImages, 20, 20);
		addMenuItem(changeShape, shapeItems, shapeRects);
		
		
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
		
		menuBar.getMenus().addAll(backgroundColor, image, penColor, language, penProperties, changeShape, help, newWorkspace);
		root.getChildren().add(menuBar);

	}
	
	
	
	
	private void addMenuItem(Menu menu, List<String> options, Node[] graphics) {
		for (int i = 0; i < options.size(); i++) {
			MenuItem m = new MenuItem(options.get(i), graphics[i]);
			menu.getItems().add(m);
		}
	}


	@Override
	public void update() {
		Map<Double, Color> colorMap = pf.getPalette();
		ObservableList<MenuItem> backgroundList = backgroundColor.getItems();
		ObservableList<MenuItem> penList = penColor.getItems();

		for (int i = 0; i < colorMap.keySet().size(); i++) {
			Rectangle rect = (Rectangle) backgroundList.get(i).getGraphic();
			Rectangle penRect = (Rectangle) penList.get(i).getGraphic();
			rect.setFill(colorMap.get((double) i));
			penRect.setFill(colorMap.get((double) i));
		}


	}

}
