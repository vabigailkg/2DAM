package ejercicios;

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

/**
 * A. Realiza un programa en DOM que muestre el contenido del fichero XML ya
 * creado de la siguiente manera:
 * 
 * CD: 1
 * 
 * Título:
 * 
 * Artista:
 * 
 * País:
 * 
 * Sello:
 * 
 * Precio:
 * 
 * Año:
 */
public class EjerA_LeerXML {

	public static void main(String[] args) {
		// Declaramos el fichero
		String nombreFichero = "C:\\Users\\vanes\\git\\2DAM\\Entrega_1_9\\src\\ejercicios\\cd_catalog.xml";

		try {
			// Instanciamos el fichero y los objetos para usar el xml
			File fichero = new File(nombreFichero);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// Parseamos el documento xml
			Document doc;
			doc = dBuilder.parse(fichero);
			doc.getDocumentElement().normalize();

			// Obtenemos el elemento que se repite para sacar nº veces
			NodeList nList = doc.getElementsByTagName("CD"); // List porque tiene hijos

			// Iteramos según las veces que se repita ese elemento
			for (int temp = 0; temp < nList.getLength(); temp++) {
				// Saca un nodo de la lista de nodos CD en la posición temp
				Node nNode = nList.item(temp);

				// Verifica si el nodo es un elemento XML
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					// Convierte el nodo en element para sacar su contenido
					Element cd = (Element) nNode;

					// Obtenemos los nodos que usaremos por su nametag
					NodeList nListCD = cd.getElementsByTagName("\nCD");
					Node nTitulo = cd.getElementsByTagName("TITLE").item(0);
					Node nArtista = cd.getElementsByTagName("ARTIST").item(0);
					Node nPais = cd.getElementsByTagName("COUNTRY").item(0);
					Node nCompañia = cd.getElementsByTagName("COMPANY").item(0);
					Node nPrecio = cd.getElementsByTagName("PRICE").item(0);
					Node nAño = cd.getElementsByTagName("YEAR").item(0);

					// Sacamos el contenido de los elementos en un String (texto)
					String contenidoTitulo = (nTitulo.getTextContent());
					String contenidoArtista = (nArtista.getTextContent());
					String contenidoPais = (nPais.getTextContent());
					String contenidoCompañia = (nCompañia.getTextContent());
					String contenidoPrecio = (nPrecio.getTextContent());
					String contenidoAño = (nAño.getTextContent());

					// Creamos el formato
					System.out.println("\n---------");
					System.out.print("CD: " + (temp + 1)); // mostrar el nº de CD
					System.out.print("\n   Título: " + contenidoTitulo);
					System.out.print("\n   Artista: " + contenidoArtista);
					System.out.print("\n   País: " + contenidoPais);
					System.out.print("\n   Compañía: " + contenidoCompañia);
					System.out.print("\n   Precio: " + contenidoPrecio);
					System.out.print("\n   Año: " + contenidoAño);

				}
			}

		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

}
