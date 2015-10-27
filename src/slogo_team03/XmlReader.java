package slogo_team03;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import commands.UserCommand;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class XmlReader {
	private UserDefinedVariables userDefinedVariables;
	private UserDefinedCommands userDefinedCommands;

	public XmlReader(UserDefinedVariables userDefinedVariables, UserDefinedCommands userDefinedCommands) {
		this.userDefinedVariables = userDefinedVariables;
		this.userDefinedCommands = userDefinedCommands;
	}

	public void readLibraryFile(String path) {
		// Initial steps to read in XML file
		Document doc = generateDocument(path);

		// Read the variables and add them to the variable map
		readUserDefinedVariables(doc);

		// Read the commands and add them to the command map
		readUserDefinedCommands(doc);
	}
	
	public void readWorkspaceFile(String path) {
		Document doc = generateDocument(path);
		
		
	}

	private Document generateDocument(String path) {
		try {
			File libraryFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(libraryFile);
			doc.getDocumentElement().normalize();
			return doc;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getElementFromParent(Element parent, String name) {
		return parent.getElementsByTagName(name).item(0).getTextContent();
	}
	
	private void readUserDefinedVariables(Document doc) {
		NodeList variableList = doc.getElementsByTagName("Variable");
		for (int i = 0; i < variableList.getLength(); i++) {
			Node variable = variableList.item(i);

			if (variable.getNodeType() == Node.ELEMENT_NODE) {

				Element eVariable = (Element) variable;
				String variableName = getElementFromParent(eVariable, "VariableName");
				double variableDefinition = Double.parseDouble(getElementFromParent(eVariable, "VariableDefinition"));

				userDefinedVariables.addVariable(variableName, variableDefinition);
			}

		}
	}
	
	private void readUserDefinedCommands (Document doc) {
		NodeList commandList = doc.getElementsByTagName("Command");

		for (int i = 0; i < commandList.getLength(); i++) {
			Node command = commandList.item(i);

			if (command.getNodeType() == Node.ELEMENT_NODE) {
				Element eCommand = (Element) command;
				String commandName = getElementFromParent(eCommand, "CommandName");

				String commandParamCode = getElementFromParent(eCommand, "CommandParamCode");

				String unconvertedDefinition = getElementFromParent(eCommand, "CommandDefinition");
				ArrayList<String> commandDefinition = new ArrayList<String>(Arrays.asList(unconvertedDefinition.split(" ")));

				String unconvertedVariables = getElementFromParent(eCommand, "CommandVariables");
				ArrayList<String> commandVariables = new ArrayList<String>(Arrays.asList(unconvertedVariables.split(" ")));

				UserCommand commandObject = new UserCommand(commandName, commandParamCode, commandDefinition, commandVariables);
				userDefinedCommands.addCommand(commandObject);
			}
		}
	}
}
