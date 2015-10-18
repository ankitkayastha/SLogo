package UserInterface.LeftPane;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.text.Text;

import java.util.ResourceBundle;
import java.util.*;

public class LeftContent {
	private Group root;
	private ListViewHandler myListViewHandler;
	private List<ObservableList<String>> myListViewObservable;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.LeftPane/LeftResource");
	private List<ListView<String>> myListViewObjects;
	public LeftContent() {
		myListViewHandler = new ListViewHandler();
		root = makeListViews();
	}
	
	public Group makeListViews() {
		TextHandler myTextHandler = new TextHandler();
		double[] prefWidth = {Double.parseDouble(r.getString("prefTopWidth")), Double.parseDouble(r.getString("prefBottomWidth")), Double.parseDouble(r.getString("prefBottomWidth"))};
		double[] prefHeight = {Double.parseDouble(r.getString("prefHeight")), Double.parseDouble(r.getString("prefHeight")), Double.parseDouble(r.getString("prefHeight"))};
		double[] translateYPane = {Double.parseDouble(r.getString("translateTopY")), Double.parseDouble(r.getString("translateBottomY")), Double.parseDouble(r.getString("translateBottomY"))};
		double[] translateXPane = {Double.parseDouble(r.getString("translateTopX")), Double.parseDouble(r.getString("translateBottomLeftX")), Double.parseDouble(r.getString("translateBottomRightX"))};
		myListViewObjects = myListViewHandler.createListView(3, prefWidth, prefHeight, translateYPane, translateXPane);
		myListViewObservable = myListViewHandler.getObsList();
		ListView<String> variableValueList = myListViewObjects.get(2);
		variableValueList.setEditable(true);
		variableValueList.setCellFactory(TextFieldListCell.forListView());

		String[] titles = {r.getString("topTitle"), r.getString("bottomTitle")};
		double[] yCor = {Double.parseDouble(r.getString("yTopCor")), Double.parseDouble(r.getString("yBottomCor"))};
		double[] xCor = {Double.parseDouble(r.getString("xTopCor")), Double.parseDouble(r.getString("xBottomCor"))};
		Text[] textArr = myTextHandler.createTextObjects(2, titles, yCor, xCor);

		Group root = new Group();
		addToRoot(myListViewObjects, textArr, root);

		return root;
	}
	public ObservableList<String> getListViewObservable(int index) {
		return myListViewObservable.get(index);
	}
	public ListView<String> getListView(int index) {
		return myListViewObjects.get(index);
	}
	
	public List<ListView<String>> getListViewObs() {
		return myListViewObjects;
	}
	private void addToRoot(List<ListView<String>> listView, Text[] textArr, Group root) {
		for (ListView<String> list: listView) {
			root.getChildren().add(list);
		}
		for (Text text: textArr) {
			root.getChildren().add(text);
		}
	}
}
