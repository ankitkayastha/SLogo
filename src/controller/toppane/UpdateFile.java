package controller.toppane;

import java.io.File;
import java.io.IOException;

import javafx.stage.FileChooser;
import slogo_team03.FileInterface;

public class UpdateFile {
	private File inputFile;
	private FileInterface fi;
	public UpdateFile(FileInterface fileInterface) {
		this.fi = fileInterface;
	}

	public void loadFile() throws IOException{
		FileChooser fc = new FileChooser();
		fc.setTitle("Load File");
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fc.getExtensionFilters().add(extFilter);
		inputFile = fc.showOpenDialog(null);
		if (!(inputFile==null)) {
			try {
				fi.readXmlFile(inputFile.getAbsolutePath());
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean saveFile() throws IOException {
		FileChooser fc = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
		fc.getExtensionFilters().add(extFilter);
		inputFile = fc.showOpenDialog(null);
		if (inputFile == null) {
			return false;
		}
		fi.writeXmlFile(inputFile.getName());
		return true;
	}
}
