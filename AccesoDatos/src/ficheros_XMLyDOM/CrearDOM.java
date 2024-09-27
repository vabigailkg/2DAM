package ficheros_XMLyDOM;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CrearDOM {
	public static void main(String[] args) {

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.newDocument();
			// Elemento raiz
			Element elementoRaiz = doc.createElement("coches");
			doc.appendChild(elementoRaiz);

			// Creo Hijo
			Element cochesU = doc.createElement("cochesutilitarios");
			elementoRaiz.appendChild(cochesU);

			// Modifico atributo
			Attr attr = doc.createAttribute("compania");
			attr.setValue("Hyundai");
			cochesU.setAttributeNode(attr);

			// Creo hijo y lo introduzco
			Element nCoche = doc.createElement("nombrecoche");
			Attr attrType = doc.createAttribute("tipo");
			attrType.setValue("4x4");
			nCoche.setAttributeNode(attrType);
			nCoche.appendChild(doc.createTextNode("Tucson"));
			cochesU.appendChild(nCoche);

			// Otro hijo
			Element nCoche1 = doc.createElement("nombrecoche");
			Attr attrTypel = doc.createAttribute("tipo");
			attrTypel.setValue("normal");
			nCoche1.setAttributeNode(attrTypel);
			nCoche1.appendChild(doc.createTextNode("Coupe"));
			cochesU.appendChild(nCoche1);

			// Creo Transformer para escribir
			TransformerFactory transformerfactory = TransformerFactory.newInstance();
			Transformer transformer;

			transformer = transformerfactory.newTransformer();

			// Dom Source a traves del doc
			DOMSource source = new DOMSource(doc);

			// Streamresult con el File a crear
			StreamResult result = new StreamResult(new File("coches.xml"));

			// Lo envio al archivo
			try {
				transformer.transform(source, result);
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException s) {
			s.printStackTrace();
		}

	}
}