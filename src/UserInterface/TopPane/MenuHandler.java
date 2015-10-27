package UserInterface.TopPane;

import javafx.scene.Group;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Map;

import UserInterface.CenterPane.DisplayTurtle;
import controller.IFront;

import javafx.collections.ObservableList;

import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;


public class MenuHandler implements IFront {
	private Group root;
	private DisplayTurtle display;
	private ReceiveFromFront rf;
	private PassToFrontInterface pf;
	private Menu backgroundColor;
	private Menu penColor;
	
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


		ImageMenu iMenu = new ImageMenu();
		Menu image = iMenu.makeMenu(display, pf, rf);

		LanguageMenu langMenu = new LanguageMenu();
		Menu language = langMenu.makeMenu(display, pf, rf);


		PenPropertyMenu penPropMenu = new PenPropertyMenu();
		Menu penProperties = penPropMenu.makeMenu(display, pf, rf);


		HelpMenu hMenu = new HelpMenu();
		Menu help = hMenu.makeMenu(display, pf, rf);
		
		

		ChangeShapeMenu csMenu = new ChangeShapeMenu();
		Menu changeShape = csMenu.makeMenu(display, pf, rf);		
		
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
