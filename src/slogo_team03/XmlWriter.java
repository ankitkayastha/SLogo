package slogo_team03;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import commands.UserCommand;

public class XmlWriter {

	private Map<String, UserCommand> userCommands;
	private Map<String, Double> userVariables;

	public XmlWriter (UserDefinedCommands commands, UserDefinedVariables variables) {
		userCommands = commands.getCommandMap();
		userVariables = variables.getVariableMap();
	}

	public void writeXmlFile(String path) {
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

			// Root element of File
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("SLogo");
			doc.appendChild(rootElement);

			// Create the UserDefinedVariables section
			Element variables = doc.createElement("UserVariables");
			rootElement.appendChild(variables);

			// Populate the UserDefinedVariables section with all the variable entries
			for (String variableName : userVariables.keySet()) {
				
				Element variable = doc.createElement("Variable");
				variables.appendChild(variable);

				Element name = doc.createElement("VariableName");
				name.appendChild(doc.createTextNode(variableName));
				variable.appendChild(name);

				Element definition = doc.createElement("VariableDefinition");
				definition.appendChild(doc.createTextNode(userVariables.get(variableName).toString()));
				variable.appendChild(definition);

			}
			
			// Create the UserDefinedCommands section
			Element commands = doc.createElement("UserCommands");
			rootElement.appendChild(commands);
			
			// Populate the UserDefinedCommands section with all command entries
			for (String commandName : userCommands.keySet()) {
				
				Element command = doc.createElement("Command");
				commands.appendChild(command);
				
				Element name = doc.createElement("CommandName");
				name.appendChild(doc.createTextNode(commandName));
				command.appendChild(name);
				
				Element paramCode = doc.createElement("CommandParamCode");
				String code = userCommands.get(commandName).getParameterCode();
				paramCode.appendChild(doc.createTextNode(code));
				command.appendChild(paramCode);
				
				Element definition = doc.createElement("CommandDefinition");
				List<String> unconvertedDefinition = userCommands.get(commandName).getDefinition();
				String convertedDefinition = commandDefinitionToString(unconvertedDefinition);
				definition.appendChild(doc.createTextNode(convertedDefinition));
				command.appendChild(definition);
			}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));

			transformer.transform(source, result);

			System.out.println("File saved!");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
	}

	private String commandDefinitionToString(List<String> definition) {
		StringBuilder sb = new StringBuilder();
		for (String d : definition) {
			sb.append(d);
			sb.append(" ");
		}
		return sb.toString();
	}
}


