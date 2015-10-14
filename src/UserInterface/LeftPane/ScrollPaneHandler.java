package UserInterface.LeftPane;

import javafx.scene.control.ScrollPane;

public class ScrollPaneHandler {
	public ScrollPane[] createScrollPanes(int n, double[] prefWidth, double[] prefHeight, double[] translateY) {
		ScrollPane[] myArr = new ScrollPane[n];
		for (int i = 0; i < n; i++) {
			ScrollPane pane = new ScrollPane();
			pane.setPrefSize(prefWidth[i], prefHeight[i]);
			pane.setTranslateY(translateY[i]);
			pane.setId(Integer.toString(i));
			myArr[i] = pane;
		}
		return myArr;
	}
}
