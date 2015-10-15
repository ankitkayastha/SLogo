package UserInterface.LeftPane;

import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import java.util.*;

public class ListViewHandler {
	public List<ListView<String>> createListView(int n, double[] prefWidth, double[] prefHeight, double[] translateY) {
		List<ListView<String>> myList = new ArrayList<ListView<String>>();
		
		for (int i = 0; i < n; i++) {
			ListView<String> list = new ListView<String>();
			list.setPrefSize(prefWidth[i], prefHeight[i]);
			list.setTranslateY(translateY[i]);
			list.setId(Integer.toString(i));
			myList.add(list);
		}
		return myList;
	}
}
