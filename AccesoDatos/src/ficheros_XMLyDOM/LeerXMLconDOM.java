package ficheros_XMLyDOM;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXMLconDOM {

	public static void main(String[] args) {

		String nombreFichero = "coches.xml";
		
		try {
			File archivo = new File(nombreFichero);
			DocumentBuilderFactory dbFactoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactoria.newDocumentBuilder();

			Document doc = dBuilder.parse(archivo);
			doc.getDocumentElement().normalize();
			System.out.print("Elemento Raiz: ");
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nList = doc.getElementsByTagName("cochesutilitarios");
			System.out.println("------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				System.out.println("\nElemento actual: ");
				System.out.print(nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					System.out.print("\ncompania: ");
					System.out.println(eElement.getAttribute("compania"));
					NodeList nombreCocheLista = eElement.getElementsByTagName("nombrecoche");
					for (int count = 0; count < nombreCocheLista.getLength(); count++) {
						Node node1 = nombreCocheLista.item(count);
						if (node1.getNodeType() == node1.ELEMENT_NODE) {
							Element coche = (Element) node1;

							System.out.print("Nombre coche: ");
							System.out.println(coche.getTextContent());
							System.out.print("Tipo: ");
							System.out.println(coche.getAttribute("tipo"));

							// el código está incompleto
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		} catch (SAXException sax) {
			sax.printStackTrace();
		}
	}

}
