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
	private ImageView turtle;
	private Color lineColor;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	
	public DisplayTurtle() {
		myCanvas = new Canvas(500, 500);
		myCanvas.setTranslateX(0);
		myCanvas.setTranslateY(0);
		root = new Group();

	}
	/*use point list */
	public void move(CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi) {
		Image image = setImage(r.getString("image"));
		gc.fillRect(0, 0, 500, 500);
		//System.out.println("Turtle visibility from front " + vi.isVisible());
		
		List<Line> lineList = ci.getLineList();
		for (int i = 0; i < lineList.size(); i++) {
			Line line = lineList.get(i);
			drawLine(line, getLineColor());
		}
		double xpos = ci.getX();
		double ypos = ci.getY();
		if (vi.isVisible())
			gc.drawImage(image, xpos, ypos);
	
	}
		
		private void drawLine(Line line, Color color) {
			//Line line = new Line(startX, startY, endX, endY);
		//	line.setStroke(color);
			gc.setStroke(color);
			gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
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
		turtle = new ImageView(setImage(r.getString("image")));
		//gc = myCanvas.getGraphicsContext2D();
		//gc.getChildren().add(turtle);
		gc = myCanvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, 500, 500);
		//System.out.println("Filling color green");
		Image image = setImage(r.getString("image"));
		double xpos = Double.parseDouble(r.getString("xPos"));
		double ypos = Double.parseDouble(r.getString("yPos"));
		double width = image.getWidth();
		double height = image.getHeight();
		gc.drawImage(image, xpos, ypos);
		System.out.println("Image height = " + height);
		//gc.clearRect(xpos, ypos, width, height);
		//gc.drawImage(setImage(r.getString("image")), 300, 300);

		//turtle.setX(Double.parseDouble(r.getString("xPos")));
		//turtle.setY(Double.parseDouble(r.getString("yPos")));
		//turtle.setX(200);
		//turtle.setY(200);
		System.out.println(turtle.getX());
		System.out.println(turtle.getY());
		root.getChildren().add(myCanvas);
		//myCanvas.toBack();
	
		//root.setStyle("-fx-background-color: #000000;");
		//pane.setBackground(new Background(new BackgroundFill(Color.web("0x0000ff"), CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public Image setImage(String s) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(s));
		return image;
	}
	public ImageView getImageView() {
		return turtle;
	}
	public GraphicsContext getGC() {
		return this.gc;
	}
	
	public Group getPane() {
		return this.root;
	}
	
}
