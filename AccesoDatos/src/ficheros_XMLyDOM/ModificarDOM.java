package ficheros_XMLyDOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class ModificarDOM {

	public static void main(String[] args) {

		try {
			String nombreFichero = "coches.xml";
			File inputFile = new File(nombreFichero);
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(inputFile);

			// Primer nodo
			Node coches = doc.getFirstChild();
			Node cocheUtilitario = doc.getElementsByTagName("cochesutilitarios").item(0);

			// Modifico atributo
			NamedNodeMap attr = cocheUtilitario.getAttributes();
			Node nodeAttr = attr.getNamedItem("compania");
			nodeAttr.setTextContent("Citroen");

			// Creo transformer para exportar el resultado
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			// Creo un nuevo XML
			StreamResult result = new StreamResult(new File(nombreFichero));
			transformer.transform(source, result);

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

}
