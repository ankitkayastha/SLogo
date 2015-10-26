package UserInterface.CenterPane;

import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import slogo_team03.AngleInterface;
import slogo_team03.CoordinateInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.VisibleInterface;

public class InitialTurtle {
	
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	
	public Group makeTurtle(CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi, Rectangle rect, CreateTooltip tip, Canvas myCanvas, GraphicsContext gc) {
		Group root = new Group();
		Image image = changeImage(r.getString("image"));
		tip.update(ci, ai, pi, vi, rect);
		rect.setFill(new ImagePattern(image));

		double width = image.getWidth();
		double height = image.getHeight();
		gc = myCanvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, 500, 500);
		double xpos = Double.parseDouble(r.getString("xPos")) + 250 - width / 2;
		double ypos = Double.parseDouble(r.getString("yPos")) + 250 - height / 2;
		rect.setX(xpos);
		rect.setY(ypos);
		root.getChildren().addAll(myCanvas, rect);
		return root;
		
	}
	
	private Image changeImage(String s) {
		return new Image(getClass().getClassLoader().getResourceAsStream(s), 40, 40, false, false);
	}
}
