package UserInterface.LeftPane;

import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TextHandler {
	public Text[] createTextObjects(int n, String[] titles, double[] translateY, TextAlignment[] alignments) {
		Text[] myTextArr = new Text[n];
		for (int i = 0; i < n; i++) {
			Text textObj = new Text();
			textObj.setText(titles[i]);
			textObj.setTranslateY(translateY[i]);
			textObj.setTranslateX(1);
			textObj.setTextAlignment(alignments[i]);
			myTextArr[i] = textObj;
		}
		return myTextArr;
	}
}
