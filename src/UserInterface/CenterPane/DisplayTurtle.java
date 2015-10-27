package UserInterface.CenterPane;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import slogo_team03.ITurtleProperties;
import slogo_team03.PassToFrontInterface;
import slogo_team03.IPenUpDown;
import slogo_team03.Stamp;
import slogo_team03.StampInterface;

import java.util.*;

import controller.IFront; 

public class DisplayTurtle implements IFront {
	private Canvas myCanvas;
	private Group root;
	private GraphicsContext gc;
	private Rectangle rect;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	private Image image = new Image(r.getString("image"));
	private CreateTooltip tip;
	private ITurtleProperties tpInterface;
	private IPenUpDown pInterface;
	private InitialTurtle initial;
	private PassToFrontInterface passInterface;
	private StampInterface stampInterface;
	
	public DisplayTurtle(ITurtleProperties tp, IPenUpDown pi, PassToFrontInterface pf, StampInterface si) {
		myCanvas = new Canvas(Double.parseDouble(r.getString("canvasWidth")), Double.parseDouble(r.getString("canvasHeight")));
		myCanvas.setTranslateX(Double.parseDouble(r.getString("canvasTranslateX")));
		myCanvas.setTranslateY(Double.parseDouble(r.getString("canvasTranslateY")));
		rect = new Rectangle(40, 40);
		tip = new CreateTooltip();
		initial = new InitialTurtle();
		gc = myCanvas.getGraphicsContext2D();
		root = initial.makeTurtle(tp, pi, rect, tip, myCanvas, gc);
		tpInterface = tp;
		pInterface = pi;
		passInterface = pf;
		stampInterface = si;
	}

	
	private void drawStamp(GraphicsContext gc, Image image, double angle, double tlx, double tly) {
		gc.save();
		rotate(gc, angle, tlx + image.getWidth() / 2, tly + image.getHeight() / 2);
		gc.drawImage(image, tlx, tly);
		gc.restore();
	}
	
	
	private void rotate(GraphicsContext gc, double angle, double pivotX, double pivotY) {
		Rotate rot = new Rotate(angle, pivotX, pivotY);
		gc.setTransform(rot.getMxx(), rot.getMyx(), rot.getMxy(), rot.getMyy(), rot.getTx(), rot.getTy());
	}
	
	
	public void update() {
		tip.update(tpInterface, pInterface, rect);
		gc.setFill(passInterface.getUpdatedBackgroundColor());
		gc.fillRect(Double.parseDouble(r.getString("originX")), Double.parseDouble(r.getString("originY")), Double.parseDouble(r.getString("canvasWidth")), Double.parseDouble(r.getString("canvasHeight")));
		List<Line> lineList = tpInterface.getLineList();
		for (int i = 0; i < lineList.size(); i++) {
			Line line = lineList.get(i);
			drawLine(line);
		}
		double xpos = 250 + tpInterface.getX() - rect.getWidth() / 2;
		double ypos = 250 - tpInterface.getY() - rect.getHeight() / 2;
		rect.setVisible(tpInterface.isVisible());
		if (tpInterface.isVisible()) {
			rect.setX(xpos);
			rect.setY(ypos);
			rect.setRotate(tpInterface.absoluteAngleFrontend());
		}
		for (Stamp s : stampInterface.getStampList()) {
			drawStamp(gc, this.image, (90 - s.getMyAngle()) % 360, 250 + s.getMyX() - rect.getWidth() / 2, 250 - s.getMyY() - rect.getHeight() / 2);
		}
	}

	private void drawLine(Line line) {
		gc.setStroke(line.getFill());
		gc.setLineWidth(line.getStrokeWidth());
		gc.setLineDashes(5d, 5d);
		gc.strokeLine(line.getStartX() + 250, 250 - line.getStartY(), line.getEndX() + 250, 250 - line.getEndY());
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
