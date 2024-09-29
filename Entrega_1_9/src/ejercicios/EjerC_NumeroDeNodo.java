package ejercicios;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * C. Añadir, en cada elemento del documento XML, el número de CD que le
 * corresponde a cada uno.
 * 
 */
public class EjerC_NumeroDeNodo {

	public static void main(String[] args) {
		// Declaramos el fichero
		String nombreFichero = "C:\\Users\\vanes\\git\\2DAM\\Entrega_1_9\\src\\ejercicios\\cd_catalog.xml";

		try {
			// Instanciamos el fichero y los objetos para usar el xml
			File fichero = new File(nombreFichero);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

			// Parseamos el documento xml
			Document doc = dBuilder.parse(fichero);
			doc.getDocumentElement().normalize();

			// Obtenemos el elemento que se repite para sacar nº veces
			NodeList nList = doc.getElementsByTagName("CD"); // List porque tiene hijos

			// Iteramos las veces que se repita cd
			for (int temp = 0; temp < nList.getLength(); temp++) {
				// Saca un nodo de la lista CD en la posición temp
				Node padre = nList.item(temp);

				// Verifica si el nodo es un elemento XML
				if (padre.getNodeType() == Node.ELEMENT_NODE) {
					// Convierte el nodo en element para sacar su contenido
					Element elementoPadre = (Element) padre;

					//--------Repetimos para los hijos
					
					// Obtenemos los elementos hijos de CD en lista e iteramos
					NodeList hijosCD = elementoPadre.getChildNodes();
					for (int i = 0; i < hijosCD.getLength(); i++) {
						Node hijo = hijosCD.item(i); // Saca un nodo de la lista

						// Verifica si el nodo hijo es un elemento
						if (hijo.getNodeType() == Node.ELEMENT_NODE) {
							Element elementoHijo = (Element) hijo;

							// Añadimos el número de CD a cada elemento
							elementoHijo.setAttribute("cd", String.valueOf(temp + 1));
							elementoPadre.setAttribute("cd", String.valueOf(temp + 1));
						}
					}

					// Creo transformer para exportar el resultado
					TransformerFactory transformerFactory = TransformerFactory.newInstance();
					Transformer transformer;
					transformer = transformerFactory.newTransformer();
					DOMSource source = new DOMSource(doc);

					// Creamos el nuevo XML
					StreamResult result = new StreamResult(new File(nombreFichero));
					transformer.transform(source, result);

				}
			}
			// Confirmación
			System.out.println("Se ha añadido el número de CD a cada elemento.");
		} catch (ParserConfigurationException | SAXException | IOException |

				TransformerException e) {
			e.printStackTrace();
		}
	}

}
