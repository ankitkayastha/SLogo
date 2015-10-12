package UserInterface.CenterPane;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DisplayTurtle {
	private Group root;
	
	public DisplayTurtle() {
		root = makeTurtle();
	}
	
public Group makeTurtle() {
		Group root = new Group();
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
		ImageView turtle = new ImageView(image);
		root.getChildren().add(turtle);
		turtle.setX(900/2);
		turtle.setY(675/2);
		return root;
	}
}
