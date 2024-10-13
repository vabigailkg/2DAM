package ejercicio7_Hilos;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * El panel con las barras de progreso de la carrera.
 */
public class Carrera extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	// Creamos barras para mostrar el progreso
	JProgressBar progressBar1 = new JProgressBar();
	JProgressBar progressBar2 = new JProgressBar();
	JProgressBar progressBar3 = new JProgressBar();
	JProgressBar progressBar4 = new JProgressBar();

	// Creamos label para mostrar al ganador
	JLabel lblNombreGanador = new JLabel("");

	// Creamos el objeto para usar sus métodos
	private Ventana ventana;

	/**
	 * Create the panel.
	 */
	public Carrera(Ventana ventana) {
		// Pasamos la referencia del objeto al constructor
		this.ventana = ventana;

		setBounds(new Rectangle(0, 0, 640, 480));
		setLayout(null);

		// Progreso del caballo 1
		progressBar1.setForeground(Color.PINK);
		progressBar1.setBounds(146, 58, 388, 51);
		this.add(progressBar1); // Susituimos contentPane por this para agregar el componente al frame

		// Progreso del caballo 2
		progressBar2.setForeground(Color.GRAY);
		progressBar2.setBounds(146, 129, 388, 51);
		this.add(progressBar2);

		// Progreso del caballo 3
		progressBar3.setForeground(Color.MAGENTA);
		progressBar3.setBounds(146, 201, 388, 51);
		this.add(progressBar3);

		// Progreso del caballo 4
		progressBar4.setForeground(Color.GREEN);
		progressBar4.setBounds(146, 275, 388, 51);
		this.add(progressBar4);

		// Nombre del caballo ganador
		lblNombreGanador.setBounds(281, 33, 46, 14);
		this.add(lblNombreGanador);

		JLabel lblGanador = new JLabel("Ganador: ");
		lblGanador.setBounds(146, 33, 95, 14);
		this.add(lblGanador);

		JLabel lblCaballo1 = new JLabel("Caballo 1");
		lblCaballo1.setForeground(Color.PINK);
		lblCaballo1.setBounds(27, 74, 95, 14);
		this.add(lblCaballo1);

		JLabel lblCaballo2 = new JLabel("Caballo 2");
		lblCaballo2.setForeground(Color.GRAY);
		lblCaballo2.setBounds(27, 143, 95, 14);
		this.add(lblCaballo2);

		JLabel lblCaballo3 = new JLabel("Caballo 3");
		lblCaballo3.setForeground(Color.MAGENTA);
		lblCaballo3.setBounds(27, 215, 95, 14);
		this.add(lblCaballo3);

		JLabel lblCaballo4 = new JLabel("Caballo 4");
		lblCaballo4.setForeground(Color.GREEN);
		lblCaballo4.setBounds(27, 295, 95, 14);
		this.add(lblCaballo4);

		JButton btnComenzar = new JButton("Empieza la carrera");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Resetear las barras de progreso y el label de ganador
				progressBar1.setValue(0);
				progressBar2.setValue(0);
				progressBar3.setValue(0);
				progressBar4.setValue(0);
				lblNombreGanador.setText("");

				// Prioridad base
				int prioridad1 = 6;
				int prioridad2 = 6;
				int prioridad3 = 6;
				int prioridad4 = 6;
				
				// Creamos hilos (nombre, barra asignada, ganador)
				HiloCaballo hilo1 = new HiloCaballo("Caballo 1", progressBar1, lblNombreGanador);
				HiloCaballo hilo2 = new HiloCaballo("Caballo 2", progressBar2, lblNombreGanador);
				HiloCaballo hilo3 = new HiloCaballo("Caballo 3", progressBar3, lblNombreGanador);
				HiloCaballo hilo4 = new HiloCaballo("Caballo 4", progressBar4, lblNombreGanador);
				
				// Asignamos la prioridad de cada uno
				hilo1.setPriority(prioridad1);
				hilo2.setPriority(prioridad2);
				hilo3.setPriority(prioridad3);
				hilo4.setPriority(prioridad4);
				
				// Arrancamos hilos
				hilo1.start();
				hilo2.start();
				hilo3.start();
				hilo4.start();

				// Deshabilitar el botón después de iniciar la carrera para evitar reiniciar
				// hilos
				btnComenzar.setEnabled(false);
			}
		});
		btnComenzar.setBounds(222, 366, 154, 23);
		this.add(btnComenzar);

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
	 * @return El panel Carrera con sus componentes añadidos
	 */
	public JPanel getJPanel(int x, int y, int width, int height, String name) {
		// Usamos this para coger este panel ya creado con todos sus elementos
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setName(name);

		return this;
	}
}
