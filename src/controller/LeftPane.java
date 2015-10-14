package controller;

import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class LeftPane {
	
	public void addToScrollPane(ScrollPane pane, TextArea text) {
		pane.setContent(new Text(text.getText()));
	}
	
}
