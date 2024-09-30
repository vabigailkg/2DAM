package xpath;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ej_XPath {

	public static void main(String[] args) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;

		try {
			db = dbf.newDocumentBuilder();

			Document xpathDoc;
			xpathDoc = db.parse("C:\\Users\\in2dm3-v\\git\\2DAM\\AccesoDatos\\src\\xpath\\libro.xml");
			XPath xpath = XPathFactory.newInstance().newXPath();

			String expresion = "//libro/titulo/text()";

			NodeList libros = (NodeList) xpath.evaluate(expresion, xpathDoc, XPathConstants.NODESET);

			for (int i = 0; i < libros.getLength(); i++) {
				System.out.println(libros.item(i).getNodeValue());
			}

		} catch (SAXException | IOException | XPathExpressionException | ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

}
