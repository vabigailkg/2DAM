package vista;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Mensaje;

import javax.swing.JScrollPane;

/**
 * El panel donde se muestran los mensajes.
 */
public class PanelImprimirMensaje extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTable tablaMensajes;
	private DefaultTableModel modelo;

	public PanelImprimirMensaje() {
		setBounds(new Rectangle(0, 0, 640, 480));
		setLayout(null);

		// Crear el modelo de la tabla con los encabezados y asignarlo a la variable de
		// instancia
		modelo = new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "De", "Para", "Fecha", "Hora", "Asunto", "Contenido" });

		// Inicializar la tabla con el modelo para que se vean los datos
		tablaMensajes = new JTable(modelo);
		tablaMensajes.setFillsViewportHeight(true); // Para que ocupe todo el área del JScrollPane

		// Agregar la tabla a un JScrollPane
		JScrollPane scrollPane = new JScrollPane(tablaMensajes);
		scrollPane.setBounds(47, 55, 539, 296); // Ajustar el tamaño del JScrollPane
		add(scrollPane);
	}

	/**
	 * Resetea y actualiza la tabla con los mensajes del fichero.
	 *
	 * @param mensajes Lista de mensajes a mostrar.
	 */
	public void actualizarTabla(ArrayList<Mensaje> mensajes) {
		// Para ver por consola cuántos mensajes se intentan mostrar en la tabla
		System.out.println("Número de mensajes a mostrar: " + mensajes.size());
		// Limpiar la tabla
		modelo.setRowCount(0);
		// Agregar cada mensaje al modelo de la tabla
		for (Mensaje mensaje : mensajes) {
			modelo.addRow(new Object[] { mensaje.getDe(), mensaje.getPara(), mensaje.getFecha(), mensaje.getHora(),
					mensaje.getAsunto(), mensaje.getContenido() });
		}
	}

	/**
	 * Devuelve el JPanel transformándolo con los parámetros y coordenadas que le
	 * pasamos
	 * 
	 * @param x      Nueva coordenada x
	 * @param y      Nueva coordenada y
	 * @param width  Nueva anchura
	 * @param height Nueva altura
	 * @param name   Nombre del panel
	 * @return El PanelImprimirMensaje con sus componentes añadidos
	 */
	public JPanel getJPanel(int x, int y, int width, int height, String name) {
		// Usamos this para coger este panel ya creado con todos sus elementos
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(Color.green);
		this.setName(name);

		return this;
	}
}
