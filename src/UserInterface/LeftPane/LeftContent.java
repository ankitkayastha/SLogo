package UserInterface.LeftPane;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ResourceBundle;


public class LeftContent {
	private Group root;
	private ScrollPane[] myPaneArr;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.LeftPane/LeftResource");
	public LeftContent() {
		root = makeScrollablePanes();
	}
	
	public Group makeScrollablePanes() {
		ScrollPaneHandler myScrollPaneHandler = new ScrollPaneHandler();
		TextHandler myTextHandler = new TextHandler();
		double[] prefWidth = {Double.parseDouble(r.getString("prefWidth")), Double.parseDouble(r.getString("prefWidth"))};
		double[] prefHeight = {Double.parseDouble(r.getString("prefHeight")), Double.parseDouble(r.getString("prefHeight"))};
		double[] translateYPane = {Double.parseDouble(r.getString("translateTopY")), Double.parseDouble(r.getString("translateBottomY"))};
		myPaneArr = myScrollPaneHandler.createScrollPanes(2, prefWidth, prefHeight, translateYPane);
		String[] titles = {r.getString("topTitle"), r.getString("bottomTitle")};
		double[] yCor = {Double.parseDouble(r.getString("yTopCor")), Double.parseDouble(r.getString("yBottomCor"))};
		double[] xCor = {Double.parseDouble(r.getString("xTopCor")), Double.parseDouble(r.getString("xBottomCor"))};
		Text[] textArr = myTextHandler.createTextObjects(2, titles, yCor, xCor);

		Group root = new Group();
		addToRoot(myPaneArr, textArr, root);
		//Image image = new Image(getClass().getClassLoader().getResourceAsStream("turtle.png"));
		//getPaneArray()[0].setContent(new ImageView(image));
		//myPaneArr[0].setContent(new Text("Hi"));
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
