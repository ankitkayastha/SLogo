package UserInterface.CenterPane;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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
	private StackPane stack;
	private Rectangle rect;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	private Image image = new Image(r.getString("image"));

	public DisplayTurtle() {
		myCanvas = new Canvas(500, 500);
		myCanvas.setTranslateX(0);
		myCanvas.setTranslateY(0);
		root = new Group();
		stack = new StackPane();
	}


	public void move(CoordinateInterface ci, AngleInterface ai, PenUpDownInterface pi, VisibleInterface vi) {
		Image image = getImage();
		
		gc.fillRect(0, 0, 500, 500);

		List<Line> lineList = ci.getLineList();
		for (int i = 0; i < lineList.size(); i++) {
			Line line = lineList.get(i);
			drawLine(line);
		}
		double xpos = 250 + ci.getX() - rect.getWidth() / 2;
		double ypos = 250 - ci.getY() - rect.getHeight() / 2;
		System.out.println("XPos" + xpos);
		System.out.println("YPos" + ypos);

		if (vi.isVisible()) {
			rect.setX(xpos);
			rect.setY(ypos);
			rect.setRotate(ai.absoluteAngleFrontend());
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

	public void makeTurtle() {
		Image image = changeImage(r.getString("image"));
		rect = new Rectangle(40, 40);
		rect.setFill(new ImagePattern(image));
		Tooltip t = new Tooltip("Turtle X Coordinate: ");
		Tooltip.install(rect, t);
		double width = image.getWidth();
		double height = image.getHeight();
		gc = myCanvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, 500, 500);


		double xpos = Double.parseDouble(r.getString("xPos")) + 250 - width / 2;
		double ypos = Double.parseDouble(r.getString("yPos")) + 250 - height / 2;
		System.out.println(xpos);
		System.out.println(ypos);
		rect.setX(xpos);
		rect.setY(ypos);
		

		stack.getChildren().add(myCanvas);
		root.getChildren().add(stack);
		root.getChildren().add(rect);
	}

	private Image changeImage(String s) {
		return new Image(getClass().getClassLoader().getResourceAsStream(s), 40, 40, false, false);
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

	public Group getPane() {
		return this.root;
	}

}
