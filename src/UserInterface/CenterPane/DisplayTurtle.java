package UserInterface.CenterPane;

import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import slogo_team03.AngleInterface;
import slogo_team03.CoordinateInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.VisibleInterface;

import java.util.List;
import java.util.ResourceBundle;

public class DisplayTurtle {
	private Canvas myCanvas;
	private Group root;
	private GraphicsContext gc;
	private Color lineColor;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	private Image image = new Image(r.getString("image"));
	
	public DisplayTurtle() {
		myCanvas = new Canvas(500, 500);
		myCanvas.setTranslateX(0);
		myCanvas.setTranslateY(0);
		root = new Group();
	}
	
	private void rotate(GraphicsContext gc, double angle, double pivotX, double pivotY) {
		Rotate rot = new Rotate(angle, pivotX, pivotY);
		gc.setTransform(rot.getMxx(), rot.getMyx(), rot.getMxy(), rot.getMyy(), rot.getTx(), rot.getTy());
	}
	/*use point list */
	public void move(CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi) {
		Image image = getImage();
		gc.fillRect(0, 0, 500, 500);
		//System.out.println("Turtle visibility from front " + vi.isVisible());
		
		List<Line> lineList = ci.getLineList();
		for (int i = 0; i < lineList.size(); i++) {
			Line line = lineList.get(i);
			drawLine(line, getLineColor());
		}
		double xpos = 250 + ci.getX() - image.getWidth()/2;
		System.out.println("x coor is " + ci.getX());
		double ypos = 250 - ci.getY() - image.getHeight()/2;
		if (vi.isVisible()) {
			System.out.println(ai.getAngle());
			drawRotatedImage(gc, image, (90 - ai.getAngle()) % 360, xpos, ypos);
		}
	}
	
	
	private void drawRotatedImage(GraphicsContext gc, Image image, double angle, double tlx, double tly) {
		gc.save(); //saves current state on stack
		rotate(gc, angle, tlx + image.getWidth() / 2, tly + image.getHeight() / 2); 
		gc.drawImage(image, tlx, tly);
	}
	
	private void drawLine(Line line, Color color) {
		gc.setStroke(color);
		gc.strokeLine(line.getStartX() + 250, 250 - line.getStartY(), line.getEndX() + 250, 250 - line.getEndY());
	}
		//draw lines
		
		//true-pen down - draw lines
		//if false, pen up, only need final location (last point in point list)
		//true  -if visible
	public void setLineColor(Color color) {
		this.lineColor = color;
	}
	public Color getLineColor() {
		return this.lineColor;
	}
	public void makeTurtle() {
		Image image = setImage(r.getString("image"));
		double width = image.getWidth();
		double height = image.getHeight();
		gc = myCanvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, 500, 500);		
		double xpos = Double.parseDouble(r.getString("xPos")) + 250 - width/2;
		double ypos = Double.parseDouble(r.getString("yPos")) + 250 - height/2;
		
		gc.drawImage(image, xpos, ypos);

		root.getChildren().add(myCanvas);
	}
	
	public Image setImage(String s) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(s));
		return image;
	}
	public Image getImage() {
		System.out.println(image.toString());
		return this.image;
	}
	public GraphicsContext getGC() {
		return this.gc;
	}
	
	public Group getPane() {
		return this.root;
	}
	
}
