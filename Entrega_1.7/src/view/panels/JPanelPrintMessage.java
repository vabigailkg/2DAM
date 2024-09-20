package view.panels;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPanelPrintMessage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table_Tabla;

	/**
	 * Crea el panel para imprimir mensajes.
	 */
	public JPanelPrintMessage() {
		setLayout(null);
		
		table_Tabla = new JTable();
		table_Tabla.setBounds(29, 185, 760, 92);
		table_Tabla.setModel(new DefaultTableModel(
			new Object[][] {
				{"De", "Para", "Fecha", "Hora", "Asunto", "Contenido"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"De", "Para", "Fecha", "Hora", "Asunto", "Contenido"
			}
		));
		add(table_Tabla);

	}

}
