package UserInterface.CenterPane;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ResourceBundle;

public class DisplayTurtle {
	public static StackPane root;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");

	public DisplayTurtle() {
		root = makeTurtle();
	}

	public StackPane makeTurtle() {
		StackPane root = new StackPane();
		ImageView turtle = new ImageView(setImage(r.getString("image")));
		root.getChildren().add(turtle);
		turtle.setX(Double.parseDouble(r.getString("xPos")));
		turtle.setY(Double.parseDouble(r.getString("yPos")));
		//root.setStyle("-fx-background-color: #000000;");
		root.setBackground(new Background(new BackgroundFill(Color.web("0xf00fff"), CornerRadii.EMPTY, Insets.EMPTY)));
		return root;
	}
	
	private Image setImage(String s) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(s));
		return image;
	}
	
	//public static void changeColor
	public static StackPane getPane() {
		return root;
	}
	
}
