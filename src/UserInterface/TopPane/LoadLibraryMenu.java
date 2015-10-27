package UserInterface.TopPane;

import java.util.ArrayList;
import java.util.List;
import UserInterface.CenterPane.DisplayTurtle;
import controller.toppane.UpdateFile;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Rectangle;
import slogo_team03.FileInterface;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public class LoadLibraryMenu extends AbstractMenu implements IMenu{

	FileInterface fi;
	public LoadLibraryMenu(FileInterface fileInterface) {
		this.fi = fileInterface;
	}
	@Override
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf) {
		Menu load = new Menu(r.getString("loadTitle"));
		List<String> loadOptions = new ArrayList<String>();
		List<String> loadImages = new ArrayList<String>();
		loadOptions.add(r.getString("loadLibraryFile"));
		loadImages.add(r.getString("loadImage"));
		UpdateFile updateFile = new UpdateFile(fi);
		Rectangle[] fImages = makeImageNodes(loadImages, 20, 20);
		addMenuItem(load, loadOptions, fImages);
		for (MenuItem m : load.getItems()) {
			m.setOnAction((event) -> {
				try {
					updateFile.loadLibraryFile();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		return load;
	}

}
