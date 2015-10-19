package commands;

import java.util.ArrayList;
import java.util.List;

public class UserCommand extends SpecialCommand {
	private String myName;
	private List<String> myDefinition;

	public UserCommand(String name) {
		myName = name;
		myDefinition = new ArrayList<String>();
	}

	public List<String> assignValuesToCommandList(double... params) {
		List<String> tempList = new ArrayList<String>();
		for (int i = 0; i < myDefinition.size(); i++) {
			String current = myDefinition.get(i);
			if (isVariable(current)) {
				if (variableMap.containsKey(current)) {
					tempList.add(current);				//Need to resolve issue with variables already defined
//					tempList.add(Double.toString(variableMap.getVariable(current)));
				} else {
					int index = variableList.indexOf(current);
					tempList.add(Double.toString(params[index]));
				}
			} else {
				tempList.add(current);
			}
		}
		return tempList;
	}

	public void setParameterCode(int numParams) {
		parameterCode = "";
		for (int i = 0; i < numParams; i++) {
			parameterCode += "e";
		}
	}

	@Override
	public double execute() {
		double[] params = new double[getNumberOfParameters()];
		for (int i = 0; i < params.length; i++) {
			params[i] = myParameters[i];
		}
		runList = assignValuesToCommandList(params);

		return -1;
	}

	public int getNumberOfParameters() {
		return parameterCode.length();
	}

	public List<String> getDefinition() {
		return myDefinition;
	}

	@Override
	public void addListOfCommands(List<String> cList) {
		setDefinition(cList);
	}

	public void setDefinition(List<String> definition) {
		myDefinition = new ArrayList<String>(definition);
	}

	private boolean isVariable(String s) {
		return s.matches(":[a-zA-Z_]+");
	}

	@Override
	public String toString() {
		return myName;
	}
}