package UserInterface;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LeftPane {
	private Group root;
	
	public LeftPane() {
		root = makeScrollablePanes();
	}
	
	public Group makeScrollablePanes() {
		ScrollPane pane = new ScrollPane();
		ScrollPane paneTwo = new ScrollPane();
		Text textOne = new Text();
		textOne.setText("User Defined Functions");
		Text textTwo = new Text();
		textTwo.setText("Variables");
		pane.setPrefSize(150, 675/2);
		paneTwo.setPrefSize(150, 675/2);
		paneTwo.setTranslateY(675/2);
		textOne.setTranslateY(20);
		textTwo.setTranslateY(675/2 + 20);
		textOne.setTextAlignment(TextAlignment.JUSTIFY);
		textTwo.setTextAlignment(TextAlignment.JUSTIFY);
		Group root = new Group();
		root.getChildren().add(pane);
		root.getChildren().add(paneTwo);
		root.getChildren().add(textOne);
		root.getChildren().add(textTwo);
		return root;
	}
}
