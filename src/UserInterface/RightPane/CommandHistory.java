package UserInterface.RightPane;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;

import java.util.List;
import java.util.ResourceBundle;


import UserInterface.LeftPane.ListViewHandler;

public class CommandHistory {
	
	private ListViewHandler listViewHandler;
	private List<ListView<String>> commandHist;
	
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.RightPane/RightResource");
	private Group root;
	public CommandHistory() {
		root = new Group();
		listViewHandler = new ListViewHandler();
	}
	
	public void makeListView(TextArea field) {
		Text title = new Text();
		title.setText("Command History");
		title.setTranslateX(Double.parseDouble(r.getString("translateX")));
		title.setTranslateY(Double.parseDouble(r.getString("translateY")));
		double[] prefWidth = {Double.parseDouble(r.getString("prefWidth"))};
		double[] prefHeight = {Double.parseDouble(r.getString("prefHeight"))};
		double[] translateY = {Double.parseDouble(r.getString("historyTranslateY"))};
		double[] translateX = {Double.parseDouble(r.getString("historyTranslateX"))};
		commandHist = listViewHandler.createListView(1, prefWidth, prefHeight, translateY, translateX);
		for (ListView<String> list: commandHist) {
			list.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> field.setText(newVal));
			root.getChildren().add(list);
		}
		root.getChildren().add(title);
		//use lambda
	}
	public Group getRoot() {
		return root;
	}
	public List<ObservableList<String>> getObs() {
		return listViewHandler.getObsList();
	}
	
	public List<ListView<String>> getListView() {
		return commandHist;
	}

}
