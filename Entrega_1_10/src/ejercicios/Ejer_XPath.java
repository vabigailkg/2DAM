package ejercicios;

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

/**
 * Utilizando el xml ventas.xml realiza las siguientes consultas Xpath
 * 
 * 1-.Cantidad de ventas de la carnicería.
 * 
 * 2-. Precio de productos de carnicería.
 * 
 * 3-. Nombre del producto del que se han vendido 3 unidades.
 * 
 * 4-. Responsable del producto con nombre de Naranjas. 5-. Responsable de la
 * venta realizada el 10/03/2013.
 * 
 */
public class Ejer_XPath {

	public static void main(String[] args) {
		// Preparamos los builders para tratar el fichero
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;

		try {
			db = dbf.newDocumentBuilder();

			// Preparar fichero XML
			Document xpathDoc;
			xpathDoc = db.parse("C:\\Users\\vanes\\git\\2DAM\\Entrega_1_10\\src\\ventas.xml");
			XPath xpath = XPathFactory.newInstance().newXPath();
			xpath.toString().toLowerCase();

			// Sentencias
			// Usar translate en el atributo id para que no importen las mayúsculas. Para el
			// segundo atributo lo aplicamos en la ruta entera:
			// "/tienda/ventas/venta[TRANSLATE(@id,'ABC','abc')=TRANSLATE(//dpto[nombre='Carnicería']/@id,
			// 'ABC', 'abc')]/cantidad/text()";
			String ventasCarniceria = "/tienda/ventas/venta[translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = translate(//dpto[nombre='Carnicería']/@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')]/cantidad/text()";
			String precioCarniceria = "/tienda/productos/producto[@venta=//dpto[nombre='Carnicería']/@id]/precio/text()";
			String productoVendido = "/tienda/productos/producto[@id=//venta[cantidad=3]/producto]/nombre/text()";
			String responsableNaranjas = "/tienda/dptos/dpto[@id=//producto[nombre='Naranjas']/@venta]/responsable/text()";
			String responsableVentaFecha = "/tienda/dptos/dpto[translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = translate(//venta[data='2013/3/10']/@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz')]/responsable/text()";

			// Mete el resultado de cada sentencia en una lista de nodos
			NodeList ventas = (NodeList) xpath.evaluate(ventasCarniceria, xpathDoc, XPathConstants.NODESET);
			NodeList precios = (NodeList) xpath.evaluate(precioCarniceria, xpathDoc, XPathConstants.NODESET);
			NodeList productos = (NodeList) xpath.evaluate(productoVendido, xpathDoc, XPathConstants.NODESET);
			NodeList naranjas = (NodeList) xpath.evaluate(responsableNaranjas, xpathDoc, XPathConstants.NODESET);
			NodeList fechas = (NodeList) xpath.evaluate(responsableVentaFecha, xpathDoc, XPathConstants.NODESET);

			// Recorre las listas de nodos y muestra el resultado de cada sentencia
			for (int i = 0; i < ventas.getLength(); i++) {
				System.out.println("Cantidad de ventas de la carnicería: " + ventas.item(i).getNodeValue());
			}
			for (int i = 0; i < precios.getLength(); i++) {
				System.out.println("Precio de productos de carnicería: " + precios.item(i).getNodeValue());
			}
			for (int i = 0; i < productos.getLength(); i++) {
				System.out.println(
						"Nombre del producto del que se han vendido 3 unidades: " + productos.item(i).getNodeValue());
			}
			for (int i = 0; i < naranjas.getLength(); i++) {
				System.out
						.println("Responsable del producto con nombre de Naranjas: " + naranjas.item(i).getNodeValue());
			}
			for (int i = 0; i < fechas.getLength(); i++) {
				System.out.println("Responsable de la venta realizada el 10/03/2013: " + fechas.item(i).getNodeValue());
			}

		} catch (SAXException | IOException | XPathExpressionException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

}
