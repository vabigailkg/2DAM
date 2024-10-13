package ejercicio7_Hilos;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * El panel que aparece primero y establece la prioridad de cada caballo.
 */
public class Trampas extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	// Creamos el objeto para usar sus métodos
	private Ventana ventana;

	// Constructor del panel trampas
	public Trampas(Ventana ventana) {
		// Pasamos la referencia del objeto al constructor
		this.ventana = ventana;

		setBounds(new Rectangle(0, 0, 640, 480));
		setLayout(null);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener valores de los campos de texto
				int prioridad1 = Integer.parseInt(textField1.getText());
				int prioridad2 = Integer.parseInt(textField2.getText());
				int prioridad3 = Integer.parseInt(textField3.getText());
				int prioridad4 = Integer.parseInt(textField4.getText());

				// Cambia de panel
				ventana.mostrarPanel("panelProgreso");
			}
		});
		btnGuardar.setBounds(165, 226, 89, 23);
		add(btnGuardar);

		JLabel lblCaballo1 = new JLabel("Caballo 1");
		lblCaballo1.setBounds(53, 73, 71, 14);
		add(lblCaballo1);

		JLabel lblCaballo2 = new JLabel("Caballo 2");
		lblCaballo2.setBounds(53, 110, 71, 14);
		add(lblCaballo2);

		JLabel lblCaballo3 = new JLabel("Caballo 3");
		lblCaballo3.setBounds(53, 146, 71, 14);
		add(lblCaballo3);

		JLabel lblCaballo4 = new JLabel("Caballo 4");
		lblCaballo4.setBounds(53, 182, 71, 14);
		add(lblCaballo4);

		textField1 = new JTextField("6");
		textField1.setBounds(165, 70, 86, 20);
		add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField("6");
		textField2.setColumns(10);
		textField2.setBounds(165, 104, 86, 20);
		add(textField2);

		textField3 = new JTextField("6");
		textField3.setColumns(10);
		textField3.setBounds(165, 143, 86, 20);
		add(textField3);

		textField4 = new JTextField("6");
		textField4.setColumns(10);
		textField4.setBounds(165, 179, 86, 20);
		add(textField4);

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
	 * @return El panel Trampas con sus componentes añadidos
	 */
	public JPanel getJPanel(int x, int y, int width, int height, String name) {
		// Usamos this para coger este panel ya creado con todos sus elementos
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setName(name);

		return this;
	}

}
