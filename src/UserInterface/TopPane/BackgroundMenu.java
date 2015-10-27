package UserInterface.TopPane;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import UserInterface.CenterPane.DisplayTurtle;
import controller.toppane.UpdateBackgroundColor;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public class BackgroundMenu extends AbstractMenu implements IMenu{
	ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");
	
	@Override
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf) {
		Menu backgroundColor = new Menu(r.getString("backgroundTitle"));
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
		return backgroundColor;
	}
}
