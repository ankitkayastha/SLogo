package UserInterface.CenterPane;

import javafx.geometry.Point2D;
import javafx.scene.Group;
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
		myCanvas.setTranslateX(-300);
		myCanvas.setTranslateY(-350);
		root = new Group();
		
		//root = makeTurtle();
	}
	/*use point list */
	public void move(CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi) {
		System.out.println("Turtle visibility from front " + vi.isVisible());

		if (!vi.isVisible()) {
		
			turtle.setVisible(false);
		}
		else
			turtle.setVisible(true);
		List<Point2D> pointList = ci.getPointList();
		for (int i = 0; i < pointList.size(); i++) {
			/*System.out.println("Point is " + point.toString());
			System.out.println("Starting X is: " + turtle.getX());
			System.out.println("Ending X is: " + point.getX());
			System.out.println("Starting Y is: " + turtle.getY());
			System.out.println("Ending Y is: " + point.getY()); */
			turtle.setX(-1*pointList.get(i).getX());
			turtle.setY(-1*pointList.get(i).getY());
			turtle.setRotate(ai.getAngle() + 90);
			if (i != pointList.size() - 1)
				drawLine(pointList.get(i).getX(), pointList.get(i).getY(), pointList.get(i + 1).getX(), pointList.get(i + 1).getY(), getLineColor());

		}
	
	}
		
		private void drawLine(double startX, double startY, double endX, double endY, Color color) {
			//Line line = new Line(startX, startY, endX, endY);
		//	line.setStroke(color);
			gc.strokeLine(startX, startY, endX, endY);
			gc.setStroke(color);
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
		root.getChildren().add(turtle);

		root.getChildren().add(myCanvas);
		myCanvas.toBack();
		turtle.setX(Double.parseDouble(r.getString("xPos")));
		turtle.setY(Double.parseDouble(r.getString("yPos")));
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
