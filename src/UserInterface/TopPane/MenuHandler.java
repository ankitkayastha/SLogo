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
	private Menu backgroundColor;
	private Menu penColor;
	private Menu image;

	
	public MenuHandler(DisplayTurtle disp, ReceiveFromFront receive, PassToFrontInterface pass) {
		this.display = disp;
		this.rf = receive;
		this.pf = pass;
	}

	public Group getRoot() {
		return this.root;
	}

	public void makeMenuBar() {
		MenuBar menuBar = new MenuBar();
		root = new Group();

		BackgroundMenu bgMenu = new BackgroundMenu();
		backgroundColor = bgMenu.makeMenu(display, pf, rf);
		


		PenColorMenu pcMenu = new PenColorMenu();
		penColor = pcMenu.makeMenu(display, pf, rf);

		PenPropertyMenu penPropMenu = new PenPropertyMenu();
		Menu penProperties = penPropMenu.makeMenu(display, pf, rf);


		HelpMenu hMenu = new HelpMenu();
		Menu help = hMenu.makeMenu(display, pf, rf);
		
		
		
		Menu changeShape = new Menu(r.getString("changeShape"));
		List<String> shapeItems = new ArrayList<String>();
		shapeItems.add(r.getString("circle"));
		List<String> shapeImages = new ArrayList<String>();
		shapeImages.add(r.getString("circleImage"));
		Rectangle[] shapeRects = makeImageNodes(shapeImages, 20, 20);
		addMenuItem(changeShape, shapeItems, shapeRects);
		
		
		NewWorkspaceMenu nwMenu = new NewWorkspaceMenu();
		Menu newWorkspace = nwMenu.makeMenu(display, pf, rf);
		
		menuBar.getMenus().addAll(backgroundColor, image, penColor, language, penProperties, changeShape, help, newWorkspace);
		root.getChildren().add(menuBar);

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
