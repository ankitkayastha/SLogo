package UserInterface.LeftPane;

import java.util.Map;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import slogo_team03.PassToFrontInterface;

public class UpdateVariables {
	
	public void update(PassToFrontInterface pf, LeftContent left) {
		ListView<String> variableNames = left.getListView(1);
		ObservableList<String> varNames = left.getListViewObservable(1);
		ListView<String> variableVals = left.getListView(2); 
		ObservableList<String> varObs = left.getListViewObservable(2);
		Map<String, Double> updatedMap = pf.getVariableMap();
		varObs.clear();
		varNames.clear();
		for (String s : updatedMap.keySet()) {
			varObs.add(updatedMap.get(s).toString());
			varNames.add(s);
		}
		variableVals.setItems(varObs);
		variableNames.setItems(varNames);
		
	}
}
