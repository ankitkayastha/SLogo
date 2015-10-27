package UserInterface.TopPane;

import javafx.scene.Group;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Map;

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
	private DisplayTurtle display;
	private ReceiveFromFront rf;
	private PassToFrontInterface pf;
	private FileInterface fi;
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
