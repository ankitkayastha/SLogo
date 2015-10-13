package UserInterface.CenterPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ResourceBundle;

public class DisplayTurtle {
	private Group root;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.CenterPane/centerResource");

	public DisplayTurtle() {
		root = makeTurtle();
	}

	public Group makeTurtle() {
		Group root = new Group();
		ImageView turtle = new ImageView(setImage(r.getString("image")));
		root.getChildren().add(turtle);
		turtle.setX(Double.parseDouble(r.getString("xPos")));
		turtle.setY(Double.parseDouble(r.getString("yPos")));
		return root;
	}
	
	private Image setImage(String s) {
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(s));
		return image;
	}
}
