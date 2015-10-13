package resources.languages;
import java.util.ResourceBundle;

public class getBundle {
	public static ResourceBundle resource = ResourceBundle.getBundle("resources.languages/English");
	
	public static void setBundle(String s) {
		resource = ResourceBundle.getBundle("resources.languages/" + s);
	}
}
