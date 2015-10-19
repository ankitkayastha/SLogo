package slogo_team03;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserDefinedVariables {
	private Map<String, Double> variableMap;

	public UserDefinedVariables() {
		variableMap = new HashMap<String, Double>();
	}

	public double getVariable(String name) {
		return variableMap.get(name);
	}

	public void addVariable(String name, double value) {
		variableMap.put(name, value);
	}

	public double removeVariable(String name) {
		return variableMap.remove(name);
	}

	public Map<String, Double> getVariableMap() {
		return Collections.unmodifiableMap(variableMap);
	}
}
