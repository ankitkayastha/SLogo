package UserInterface.CenterPane;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ResourceBundle;

public class DisplayTurtle {
	public StackPane pane;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");
	
	public DisplayTurtle() {
		pane = new StackPane();
		//root = makeTurtle();
	}

	public void makeTurtle() {
		ImageView turtle = new ImageView(setImage(r.getString("RCD")));
		pane.getChildren().add(turtle);
		//turtle.setX(Double.parseDouble(r.getString("xPos")));
		//turtle.setY(Double.parseDouble(r.getString("yPos")));
		System.out.println(turtle.getLayoutX());
		System.out.println(turtle.getLayoutY());
		//root.setStyle("-fx-background-color: #000000;");
		//pane.setBackground(new Background(new BackgroundFill(Color.web("0x0000ff"), CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public Image setImage(String s) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(s));
		return image;
	}
	
	public StackPane getPane() {
		return this.pane;
	}
	
}
