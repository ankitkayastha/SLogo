package UserInterface.LeftPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
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
		root = makeScrollablePanes();
	}
	
	public Group makeScrollablePanes() {
		TextHandler myTextHandler = new TextHandler();
		double[] prefWidth = {Double.parseDouble(r.getString("prefWidth")), Double.parseDouble(r.getString("prefWidth"))};
		double[] prefHeight = {Double.parseDouble(r.getString("prefHeight")), Double.parseDouble(r.getString("prefHeight"))};
		double[] translateYPane = {Double.parseDouble(r.getString("translateTopY")), Double.parseDouble(r.getString("translateBottomY"))};
		myListViewObjects = myListViewHandler.createListView(2, prefWidth, prefHeight, translateYPane);
		myListViewObservable = myListViewHandler.getObsList();
		ListView<String> variableList = myListViewObjects.get(1);
		ObservableList<String> variables = myListViewObservable.get(1);
		variableList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldString, String newString) {
				ObservableList<String> variables = myListViewObservable.get(1);
				int indexSelected = myListViewObjects.get(1).getSelectionModel().getSelectedIndex();

				//	double varValue = Double.parseDouble(myListViewObservable.get(1).get(indexSelected));
				TextInputDialog dialog = new TextInputDialog();
				dialog.setContentText("Please enter a new value: ");
				Optional<String> input = dialog.showAndWait();
				//double newValue = 0;
				if (input.isPresent()) {
				//	newValue = Double.parseDouble(input.get());
					System.out.println(indexSelected);
					variables.set(indexSelected, input.get());
					myListViewObjects.get(1).setItems(variables);
					//System.out.println("Index out of bounds exception here");

				}
			}

		});
		String[] titles = {r.getString("topTitle"), r.getString("bottomTitle")};
		double[] yCor = {Double.parseDouble(r.getString("yTopCor")), Double.parseDouble(r.getString("yBottomCor"))};
		double[] xCor = {Double.parseDouble(r.getString("xTopCor")), Double.parseDouble(r.getString("xBottomCor"))};
		Text[] textArr = myTextHandler.createTextObjects(2, titles, yCor, xCor);

		Group root = new Group();
		addToRoot(myListViewObjects, textArr, root);
		
		
		/*myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldString, String newString) {
				field.setText(newString);
				System.out.println(myListView.getSelectionModel().getSelectedIndex());

				//System.out.println(newString);
			}
		}); */

		
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
