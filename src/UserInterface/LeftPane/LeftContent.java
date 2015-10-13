package UserInterface.LeftPane;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class LeftContent {
	private Group root;
	private ScrollPane[] myPaneArr;
	public LeftContent() {
		root = makeScrollablePanes();
	}
	
	public Group makeScrollablePanes() {
		ScrollPaneHandler myScrollPaneHandler = new ScrollPaneHandler();
		TextHandler myTextHandler = new TextHandler();
		double[] prefWidth = {150, 150};
		double[] prefHeight = {675/2 - 35, 675/2 - 35};
		double[] translateYPane = {0, 675/2 - 35};
		myPaneArr = myScrollPaneHandler.createScrollPanes(2, prefWidth, prefHeight, translateYPane);
		String[] titles = {"User Defined Functions", "Variables"};
		double[] yCor = {20, 675/2 - 20};
		double[] xCor = {10, 20};
		Text[] textArr = myTextHandler.createTextObjects(2, titles, yCor, xCor);

		Group root = new Group();
		addToRoot(myPaneArr, textArr, root);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
		getPaneArray()[0].setContent(new ImageView(image));
		return root;
	}
	
	public ScrollPane[] getPaneArray() {
		//System.out.println(myPaneArr[0].getId());
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
		myPaneArr[0].setContent(new ImageView(image));
		System.out.println("Returning array with size " + myPaneArr.length);
		return myPaneArr;
	}
	private void addToRoot(ScrollPane[] paneArray, Text[] textArr, Group root) {
		for (ScrollPane pane: paneArray) {
			root.getChildren().add(pane);
		}
		for (Text text: textArr) {
			root.getChildren().add(text);
		}
	}
}
