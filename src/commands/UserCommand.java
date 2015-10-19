package commands;

import java.util.ArrayList;
import java.util.List;

public class UserCommand extends Command {
	private String myName;
	private List<String> myDefinition;

	public UserCommand(String name) {
		myName = name;
		myDefinition = new ArrayList<String>();
	}

	public List<String> assignValuesToCommandList(double... params) {
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < myDefinition.size(); i++) {
			String current = myDefinition.get(0);
			if (isVariable(current)) {
				int index = variableList.indexOf(current);
				tempList.add(Double.toString(params[index]));
			} else {
				tempList.add(current);
			}
		}
		return myDefinition;
	}

	private void setParamCode(int numParams) {
		parameterCode = "";
		for (int i = 0; i < numParams; i++) {
			parameterCode += "e";
		}
	}

	@Override
	public double execute() {
		// Unneeded method
		return 0;
	}

	public int numberOfParameters() {
		return parameterCode.length();
	}

	public List<String> getDefinition() {
		return myDefinition;
	}

	public boolean isVariable(String s) {
		return s.matches(":[a-zA-Z_]+");
	}
}