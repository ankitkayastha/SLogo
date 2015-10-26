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
	private File inputFile;
	private UserDefinedVariables userDefinedVariables;
	private UserDefinedCommands userDefinedCommands;

	public XmlReader(UserDefinedVariables userDefinedVariables, UserDefinedCommands userDefinedCommands) {
		this.userDefinedVariables = userDefinedVariables;
		this.userDefinedCommands = userDefinedCommands;
	}
	
	public void readFile(String path) {
		try {	
			
			// Initial steps to read in XML file
			inputFile = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			
			// Read the variables and add them to the variable map
			NodeList variableList = doc.getElementsByTagName("Variable");
			for (int i = 0; i < variableList.getLength(); i++) {
				
				Node variable = variableList.item(i);
				
				if (variable.getNodeType() == Node.ELEMENT_NODE) {
					
					Element eVariable = (Element) variable;
					String variableName = eVariable.getElementsByTagName("VariableName").item(0).getTextContent();
					double variableDefinition = Double.parseDouble(eVariable.getElementsByTagName("VariableDefinition").item(0).getTextContent());
					
					userDefinedVariables.addVariable(variableName, variableDefinition);
				}
				
			}
			
			// Read the commands and add them to the command map
			NodeList commandList = doc.getElementsByTagName("Command");
			
			for (int i = 0; i < commandList.getLength(); i++) {
				
				Node command = commandList.item(i);
				
				if (command.getNodeType() == Node.ELEMENT_NODE) {
					Element eCommand = (Element) command;
					String commandName = eCommand.getElementsByTagName("CommandName").item(0).getTextContent();
					
					String commandParamCode = eCommand.getElementsByTagName("CommandParamCode").item(0).getTextContent();
					
					String unconvertedDefinition = eCommand.getElementsByTagName("CommandDefinition").item(0).getTextContent();
					ArrayList<String> commandDefinition = new ArrayList<String>(Arrays.asList(unconvertedDefinition.split(" ")));
					
					String unconvertedVariables = eCommand.getElementsByTagName("CommandVariables").item(0).getTextContent();
					ArrayList<String> commandVariables = new ArrayList<String>(Arrays.asList(unconvertedVariables.split(" ")));
					
					UserCommand commandObject = new UserCommand(commandName, commandParamCode, commandDefinition, commandVariables);
					userDefinedCommands.addCommand(commandObject);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
