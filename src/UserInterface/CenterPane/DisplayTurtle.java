package UserInterface.CenterPane;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import slogo_team03.AngleInterface;
import slogo_team03.CoordinateInterface;
import slogo_team03.PassToFrontInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.VisibleInterface;

import java.util.*;

import controller.IFront; 

public class DisplayTurtle implements IFront {
	private Canvas myCanvas;
	private Group root;
	private GraphicsContext gc;
	private Color lineColor;
	private Rectangle rect;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	private Image image = new Image(r.getString("image"));
	private CreateTooltip tip;
	private CoordinateInterface cInterface;
	private AngleInterface aInterface;
	private PenUpDownInterface pInterface;
	private VisibleInterface vInterface;
	private InitialTurtle initial;
	private PassToFrontInterface passInterface;
	
	public DisplayTurtle(CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi, PassToFrontInterface pf) {
		myCanvas = new Canvas(Double.parseDouble(r.getString("canvasWidth")), Double.parseDouble(r.getString("canvasHeight")));
		myCanvas.setTranslateX(Double.parseDouble(r.getString("canvasTranslateX")));
		myCanvas.setTranslateY(Double.parseDouble(r.getString("canvasTranslateY")));
		rect = new Rectangle(40, 40);
		tip = new CreateTooltip();
		initial = new InitialTurtle();
		gc = myCanvas.getGraphicsContext2D();
		root = initial.makeTurtle(ci, ai, pi, vi, rect, tip, myCanvas, gc);
		cInterface = ci;
		aInterface = ai;
		pInterface = pi;
		vInterface = vi;
		passInterface = pf;
	}

	public void update() {
		tip.update(cInterface, aInterface, pInterface, vInterface, rect);
		gc.setFill(passInterface.getUpdatedBackgroundColor());
		gc.fillRect(Double.parseDouble(r.getString("originX")), Double.parseDouble(r.getString("originY")), Double.parseDouble(r.getString("canvasWidth")), Double.parseDouble(r.getString("canvasHeight")));
		List<Line> lineList = cInterface.getLineList();
		for (int i = 0; i < lineList.size(); i++) {
			Line line = lineList.get(i);
			drawLine(line);
		}
		double xpos = 250 + cInterface.getX() - rect.getWidth() / 2;
		double ypos = 250 - cInterface.getY() - rect.getHeight() / 2;
		rect.setVisible(vInterface.isVisible());
		if (vInterface.isVisible()) {
			rect.setX(xpos);
			rect.setY(ypos);
			rect.setRotate(aInterface.absoluteAngleFrontend());
		}
	}

	private void drawLine(Line line) {
		gc.setStroke(line.getFill());
		gc.setLineWidth(line.getStrokeWidth());
		gc.strokeLine(line.getStartX() + 250, 250 - line.getStartY(), line.getEndX() + 250, 250 - line.getEndY());
	}

	public void setLineColor(Color color) {
		this.lineColor = color;
	}

	public Color getLineColor() {
		return this.lineColor;
	}
	

	public void setImage(String s) {
		rect.setFill(Color.WHITE);
		Image i = new Image(getClass().getClassLoader().getResourceAsStream(s), 40, 40, false, false);
		this.image = i;
		rect.setFill(new ImagePattern(this.image));
	}

	public Image getImage() {
		return this.image;
	}

	public GraphicsContext getGC() {
		return this.gc;
	}

	public Group getGroup() {
		return this.root;
	}

}
