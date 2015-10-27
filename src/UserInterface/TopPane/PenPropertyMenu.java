package UserInterface.TopPane;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import UserInterface.CenterPane.DisplayTurtle;
import controller.toppane.UpdatePenProperties;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Rectangle;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public class PenPropertyMenu extends AbstractMenu implements IMenu {

	ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");

	@Override
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf) {
		Menu penProperties = new Menu(r.getString("penPropertyTitle"));
		Menu penUpDown = new Menu(r.getString("penUpDown"));
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
		
		
		Menu penSize = new Menu(r.getString("penSize"));
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
		
		
		
		Menu penType = new Menu(r.getString("penLineType"));
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
		return penProperties;
	}

}
