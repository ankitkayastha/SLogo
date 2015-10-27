package UserInterface.CenterPane;

import java.util.ResourceBundle;

import javafx.scene.Group;
import java.util.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import slogo_team03.ITurtleProperties;
import slogo_team03.IPenUpDown;

public class InitialTurtle {
	
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	
	public Group makeTurtle(List<ITurtleProperties> tp, List<IPenUpDown> pi, List<Rectangle> rect, CreateTooltip tip, Canvas myCanvas, GraphicsContext gc) {
		Group root = new Group();
		for (int i = 0; i < tp.size(); i++) {
			Rectangle rectangle = rect.get(i);
			Image image = changeImage(r.getString("image"));
			rectangle.setFill(new ImagePattern(image));
			tip.update(tp.get(i), pi.get(i), rectangle);

			double width = image.getWidth();
			double height = image.getHeight();
			gc = myCanvas.getGraphicsContext2D();
			gc.setFill(Color.GREEN);
			gc.fillRect(0, 0, 500, 500);
			double xpos = Double.parseDouble(r.getString("xPos")) + 250 - width / 2;
			double ypos = Double.parseDouble(r.getString("yPos")) + 250 - height / 2;
			rectangle.setX(xpos);
			rectangle.setY(ypos);
			root.getChildren().add(rectangle);
		}
		root.getChildren().add(myCanvas);
		return root;
		
	}
	
	private Image changeImage(String s) {
		return new Image(getClass().getClassLoader().getResourceAsStream(s), 40, 40, false, false);
	}
}
