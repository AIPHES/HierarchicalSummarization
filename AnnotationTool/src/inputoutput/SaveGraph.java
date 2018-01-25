package inputoutput;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import data.Bubble;
import data.Nugget;
import data.NuggetList;
import data.NuggetStructure;

/**
 * @author Thomas Arnold (arnold@aiphes.tu-darmstadt.de)
 * 29.09.2017
 */

/*
 * Save internal hierarchy ns and the list of trashed nuggets into simple XML format (filename) 
 */

public class SaveGraph {

	public static void saveGraph(NuggetStructure ns, NuggetList trash, String filename) {
		
		try {
			
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element root = doc.createElement("root");
			Element node;
			doc.appendChild(root);
			
			for (Bubble b : ns.getMyBubbles()) {
				
				node = doc.createElement("Bubble");
				node.setAttribute("name", b.getName());
				root.appendChild(node);
				createNode(node, b, doc);
			}
			
			Element trashNode = doc.createElement("Trash");
			root.appendChild(trashNode);
			for (Nugget n : trash.getNuggetList()) {
				node = doc.createElement("Nugget");
				node.setAttribute("id", String.valueOf(n.getData().getId()));
				trashNode.appendChild(node);
			}
			
			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();			
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));

			// Output to console for testing
			// StreamResult result = new StreamResult(System.out);

			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void createNode(Element node, Bubble b, Document doc) {
		
		Element newNode;
		
		for (Nugget n : b.getMyNuggets()) {
			
			newNode = doc.createElement("Nugget");
			newNode.setAttribute("id", String.valueOf(n.getData().getId()));
			node.appendChild(newNode);
		}
		
		for (Bubble child : b.getNextBubbles()) {
			
			newNode = doc.createElement("Bubble");
			newNode.setAttribute("name", child.getName());
			node.appendChild(newNode);
			
			createNode(newNode, child, doc);
		}
		
	}
	
}
