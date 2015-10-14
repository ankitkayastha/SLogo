package UserInterface.LeftPane;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class LeftContent {
	private Group root;
	
	public LeftContent() {
		root = makeScrollablePanes();
	}
	
	public Group makeScrollablePanes() {
		ScrollPaneHandler myScrollPaneHandler = new ScrollPaneHandler();
		TextHandler myTextHandler = new TextHandler();
		double[] prefWidth = {150, 150};
		double[] prefHeight = {675/2 - 35, 675/2 - 35};
		double[] translateYPane = {0, 675/2 - 35};
		ScrollPane[] paneArr = myScrollPaneHandler.createScrollPanes(2, prefWidth, prefHeight, translateYPane);
		String[] titles = {"User Defined Functions", "Variables"};
		double[] translateYText = {20, 675/2 + 20};
		TextAlignment[] alignments = {TextAlignment.JUSTIFY, TextAlignment.JUSTIFY};
		Text[] textArr = myTextHandler.createTextObjects(2, titles, translateYText, alignments);
		Group root = new Group();
		addToRoot(paneArr, textArr, root);
		return root;
	}
	
	public void addToRoot(ScrollPane[] paneArray, Text[] textArr, Group root) {
		for (ScrollPane pane: paneArray) {
			root.getChildren().add(pane);
		}
		for (Text text: textArr) {
			root.getChildren().add(text);
		}
	}
}