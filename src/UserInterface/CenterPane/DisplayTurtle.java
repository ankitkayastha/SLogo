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
import slogo_team03.Turtle;

import java.util.*;

import controller.IFront; 

public class DisplayTurtle implements IFront {
	private Canvas myCanvas;
	private Group root;
	private GraphicsContext gc;
	private List<Rectangle> rect;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	private Image image = new Image(r.getString("image"));
	private CreateTooltip tip;
	private List<ITurtleProperties> tpInterface;
	private IPenUpDown pInterface;
	private InitialTurtle initial;
	private PassToFrontInterface passInterface;
	private StampInterface stampInterface;
	
	public DisplayTurtle(List<ITurtleProperties> tp, IPenUpDown pi, PassToFrontInterface pf, StampInterface si) {
		myCanvas = new Canvas(Double.parseDouble(r.getString("canvasWidth")), Double.parseDouble(r.getString("canvasHeight")));
		myCanvas.setTranslateX(Double.parseDouble(r.getString("canvasTranslateX")));
		myCanvas.setTranslateY(Double.parseDouble(r.getString("canvasTranslateY")));
		rect = new ArrayList<Rectangle>(tp.size()); //(40, 40);
		for (int i = 0; i < tp.size(); i++) {
			Rectangle rectangle = new Rectangle(40, 40);
			rect.add(rectangle);
		}
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
		List<ITurtleProperties> turtleList = passInterface.getTurtleList();
		for (Rectangle r : rect) {
			root.getChildren().remove(r);
		}
		rect.clear();

		for (int i = 0; i < turtleList.size(); i++) {
			Rectangle rectangle = new Rectangle(40, 40);
			rectangle.setFill(new ImagePattern(image));
			rect.add(rectangle);
			root.getChildren().add(rectangle);
			Turtle currentTurtle = (Turtle) turtleList.get(i);
			System.out.println("X: " + currentTurtle.getX() + ", Y: " + currentTurtle.getY() + ", ID: " + currentTurtle.getID());
		}
		
		
		gc.setFill(passInterface.getUpdatedBackgroundColor());
		gc.fillRect(Double.parseDouble(r.getString("originX")), Double.parseDouble(r.getString("originY")), Double.parseDouble(r.getString("canvasWidth")), Double.parseDouble(r.getString("canvasHeight")));
		for (int i = 0; i < rect.size(); i++) {
			Rectangle rectangle = rect.get(i);
			ITurtleProperties turtleProp = turtleList.get(i);
		
			tip.update(turtleProp, pInterface, rectangle);
//			gc.setFill(passInterface.getUpdatedBackgroundColor());
//			gc.fillRect(Double.parseDouble(r.getString("originX")), Double.parseDouble(r.getString("originY")), Double.parseDouble(r.getString("canvasWidth")), Double.parseDouble(r.getString("canvasHeight")));
			List<Line> lineList = turtleProp.getLineList();
			for (int j = 0; j < lineList.size(); j++) {
				Line line = lineList.get(j);
				drawLine(line);
			}
			double xpos = 250 + turtleProp.getX() - rectangle.getWidth() / 2;
			double ypos = 250 - turtleProp.getY() - rectangle.getHeight() / 2;
			rectangle.setVisible(turtleProp.isVisible());
			if (turtleProp.isVisible()) {
				rectangle.setX(xpos);
				rectangle.setY(ypos);
				rectangle.setRotate(turtleProp.absoluteAngleFrontend());
			}
			for (Stamp s : stampInterface.getStampList()) {
				drawStamp(gc, this.image, (90 - s.getMyAngle()) % 360, 250 + s.getMyX() - rectangle.getWidth() / 2, 250 - s.getMyY() - rectangle.getHeight() / 2);
			}
		}

	}

	private void drawLine(Line line) {
		gc.setStroke(line.getFill());
		gc.setLineWidth(line.getStrokeWidth());
		gc.setLineDashes(5d, 5d);
		gc.strokeLine(line.getStartX() + 250, 250 - line.getStartY(), line.getEndX() + 250, 250 - line.getEndY());
	}

	public void setImage(String s) {
		for (Rectangle rectangle: rect) {
			rectangle.setFill(Color.WHITE);
			Image i = new Image(getClass().getClassLoader().getResourceAsStream(s), 40, 40, false, false);
			this.image = i;
			rectangle.setFill(new ImagePattern(this.image));
		}
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
