package UserInterface.CenterPane;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ResourceBundle;

public class DisplayTurtle {
	private Canvas myCanvas;
	private Group root;
	private GraphicsContext gc;
	private ImageView turtle;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	
	public DisplayTurtle() {
		myCanvas = new Canvas(500, 500);
		myCanvas.setTranslateX(-300);
		myCanvas.setTranslateY(-350);
		root = new Group();
		//root = makeTurtle();
	}

	public void makeTurtle() {
		turtle = new ImageView(setImage(r.getString("image")));
		//gc = myCanvas.getGraphicsContext2D();
		//gc.getChildren().add(turtle);
		gc = myCanvas.getGraphicsContext2D();
		gc.setFill(Color.GREEN);
		gc.fillRect(0, 0, 500, 500);
		System.out.println("Filling color green");
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
