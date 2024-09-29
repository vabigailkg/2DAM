package ejercicios;

import java.io.File;
import java.io.IOException;

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
import org.xml.sax.SAXException;

/**
 * B. Añadir un nuevo CD al documento XML dado. (Con datos de prueba)
 */
public class EjerB_AgregarXML {

	public static void main(String[] args) {
		// Declaramos el fichero
		String nombreFichero = "C:\\Users\\vanes\\git\\2DAM\\Entrega_1_9\\src\\ejercicios\\cd_catalog.xml";

		try {
			// Instanciamos el fichero y los objetos para usar el xml
			File fichero = new File(nombreFichero);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();

			// Parseamos el documento xml
			Document doc;
			doc = dBuilder.parse(fichero);
			doc.getDocumentElement().normalize();

			// Creamos un nuevo CD
			Element nuevoCD = doc.createElement("CD");

			// Tomamos los nodos que vamos a usar
			Element titulo = doc.createElement("TITLE");
			Element artista = doc.createElement("ARTIST");
			Element pais = doc.createElement("COUNTRY");
			Element compañia = doc.createElement("COMPANY");
			Element precio = doc.createElement("PRICE");
			Element año = doc.createElement("YEAR");

			// Asignamos los nuevos datos a los nodos
			titulo.appendChild(doc.createTextNode("Naturally"));
			artista.appendChild(doc.createTextNode("Selena Gomez"));
			pais.appendChild(doc.createTextNode("EEUU"));
			compañia.appendChild(doc.createTextNode("Warner Music"));
			precio.appendChild(doc.createTextNode("15.99"));
			año.appendChild(doc.createTextNode("2010"));

			// Agregamos los nuevos nodos cargados al nuevo cd
			nuevoCD.appendChild(titulo);
			nuevoCD.appendChild(artista);
			nuevoCD.appendChild(pais);
			nuevoCD.appendChild(compañia);
			nuevoCD.appendChild(precio);
			nuevoCD.appendChild(año);

			// Añadimos el nuevo CD al nodo raíz
			doc.getDocumentElement().appendChild(nuevoCD);

			// Creo transformer para exportar el resultado
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);

			// Creamos el nuevo XML
			StreamResult result = new StreamResult(new File(nombreFichero));
			transformer.transform(source, result);

			// Confirmación
			System.out.println("Se ha actualizado el fichero XML.");

		} catch (ParserConfigurationException | SAXException | IOException | TransformerException e) {
			e.printStackTrace();
		}

	}

}
