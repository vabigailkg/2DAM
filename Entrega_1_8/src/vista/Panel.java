package vista;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import modelo.GestorPartidos;
import modelo.Partido;

/**
 * Panel con elementos.
 */
public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Ventana ventana;
	private GestorPartidos gestorPartidos;
	private JTextField textFieldEquipoLocal;
	private JTextField textFieldEquipoVisitante;
	private JTextField textFieldGolesLocal;
	private JTextField textFieldGolesVisitante;
	private JTextField textFieldLugar;
	private JTextField textFieldFecha;
	private JTable tabla;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private ArrayList<Partido> partidos = new ArrayList<>();

	// Constructor con acceso a los métodos de ventana
	public Panel(Ventana ventana) {
		this.ventana = ventana;
		this.gestorPartidos = new GestorPartidos();

		setBounds(new Rectangle(0, 0, 640, 480));
		setLayout(null);

		// Etiquetas y campos de texto
		JLabel labelEquipoLocal = new JLabel("Equipo local");
		labelEquipoLocal.setBounds(38, 50, 89, 14);
		add(labelEquipoLocal);

		JLabel labelEquipoVisitante = new JLabel("Equipo visitante");
		labelEquipoVisitante.setBounds(38, 78, 89, 14);
		add(labelEquipoVisitante);

		JLabel labelGolesLocal = new JLabel("Goles local");
		labelGolesLocal.setBounds(38, 106, 89, 14);
		add(labelGolesLocal);

		JLabel labelGolesVisitante = new JLabel("Goles visitante");
		labelGolesVisitante.setBounds(38, 134, 89, 14);
		add(labelGolesVisitante);

		JLabel labelLugar = new JLabel("Lugar");
		labelLugar.setBounds(38, 162, 89, 14);
		add(labelLugar);

		JLabel labelFecha = new JLabel("Fecha");
		labelFecha.setBounds(38, 190, 89, 14);
		add(labelFecha);

		textFieldEquipoLocal = new JTextField();
		textFieldEquipoLocal.setBounds(149, 47, 86, 20);
		add(textFieldEquipoLocal);
		textFieldEquipoLocal.setColumns(10);

		textFieldEquipoVisitante = new JTextField();
		textFieldEquipoVisitante.setBounds(149, 75, 86, 20);
		add(textFieldEquipoVisitante);
		textFieldEquipoVisitante.setColumns(10);

		textFieldGolesLocal = new JTextField();
		textFieldGolesLocal.setBounds(149, 103, 86, 20);
		add(textFieldGolesLocal);
		textFieldGolesLocal.setColumns(10);

		textFieldGolesVisitante = new JTextField();
		textFieldGolesVisitante.setBounds(149, 131, 86, 20);
		add(textFieldGolesVisitante);
		textFieldGolesVisitante.setColumns(10);

		textFieldLugar = new JTextField();
		textFieldLugar.setBounds(149, 159, 86, 20);
		add(textFieldLugar);
		textFieldLugar.setColumns(10);

		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(149, 187, 86, 20);
		add(textFieldFecha);
		textFieldFecha.setColumns(10);

		// Botones
		JButton botonAñadir = new JButton("Añadir");
		botonAñadir.setBounds(38, 215, 89, 23);
		add(botonAñadir);

		JButton botonCargar = new JButton("Cargar");
		botonCargar.setBounds(137, 215, 89, 23);
		add(botonCargar);

		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setBounds(236, 215, 89, 23);
		add(botonGuardar);

		// Inicializar el modelo de la tabla
		modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Equipo local", "Equipo visitante",
				"Goles local", "Goles visitantes", "Lugar", "Fecha" });

		// Tabla
		tabla = new JTable(modelo);
		tabla.setFillsViewportHeight(true);
		tabla.getColumnModel().getColumn(1).setPreferredWidth(99);
		tabla.getColumnModel().getColumn(3).setPreferredWidth(99);
		tabla.setBounds(55, 291, 1, 1);
		add(tabla);

		scrollPane = new JScrollPane(tabla);
		scrollPane.setBounds(47, 261, 539, 154);
		add(scrollPane);

		// La tabla está oculta por defecto
		scrollPane.setVisible(false);

		// Muestra la tabla cuando se pulsa "Añadir"
		botonAñadir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Validación de datos
				if (validarDatos()) {
					// Si los datos son válidos, agrega el partido
					Partido partido = new Partido(textFieldEquipoLocal.getText(), textFieldEquipoVisitante.getText(),
							Integer.parseInt(textFieldGolesLocal.getText()),
							Integer.parseInt(textFieldGolesVisitante.getText()), textFieldLugar.getText(),
							textFieldFecha.getText());

					partidos.add(partido);
					modelo.addRow(new Object[] { partido.getEquipoLocal(), partido.getEquipoVisitante(),
							partido.getGolLocal(), partido.getGolVisitante(), partido.getLugar(), partido.getFecha() });

					// Resetear los campos
					resetearCampos();
					scrollPane.setVisible(true); // Se asegura de que la tabla sea visible
				}
			}
		});

		// Cargar partidos desde el archivo al pulsar el botón "Cargar"
		botonCargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Partido> partidosCargados = gestorPartidos.cargarPartidos();
				for (Partido partido : partidosCargados) {
					modelo.addRow(new Object[] { partido.getEquipoLocal(), partido.getEquipoVisitante(),
							partido.getGolLocal(), partido.getGolVisitante(), partido.getLugar(), partido.getFecha() });
				}
				scrollPane.setVisible(true); // Asegúrate de que la tabla sea visible
				// Mostrar el popup de confirmación
				JOptionPane.showOptionDialog(null, "Los partidos han sido cargados correctamente", "Carga completada",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "OK" }, "OK");
			}
		});

		// Guardar partidos en el archivo al pulsar el botón "Guardar"
		botonGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gestorPartidos.guardarPartidos(partidos);
				// Mostrar el popup de confirmación
				JOptionPane.showOptionDialog(null, "Los partidos se han guardado correctamente", "Guardado completado",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "OK" }, "OK");
			}
		});
	}

	private boolean validarDatos() {
		// Validar equipo local
		if (textFieldEquipoLocal.getText().length() < 1 || textFieldEquipoLocal.getText().length() > 20) {
			System.out.println("El equipo local debe tener entre 1 y 20 caracteres.");
			return false;
		}

		// Validar equipo visitante
		if (textFieldEquipoVisitante.getText().length() < 1 || textFieldEquipoVisitante.getText().length() > 20) {
			System.out.println("El equipo visitante debe tener entre 1 y 20 caracteres.");
			return false;
		}

		// Validar goles local
		if (!textFieldGolesLocal.getText().matches("\\d{1,2}")) {
			System.out.println("Goles local debe ser un número de 1 o 2 dígitos.");
			return false;
		}

		// Validar goles visitante
		if (!textFieldGolesVisitante.getText().matches("\\d{1,2}")) {
			System.out.println("Goles visitante debe ser un número de 1 o 2 dígitos.");
			return false;
		}

		// Validar fecha
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
		formatoFecha.setLenient(false);
		try {
			Date fecha = formatoFecha.parse(textFieldFecha.getText());
		} catch (ParseException e) {
			System.out.println("La fecha debe tener el formato dd/MM/yy.");
			return false;
		}

		return true; // Todos los datos son válidos
	}

	// Limpia los campos tras la validación y el guardado
	private void resetearCampos() {
		textFieldEquipoLocal.setText("");
		textFieldEquipoVisitante.setText("");
		textFieldGolesLocal.setText("");
		textFieldGolesVisitante.setText("");
		textFieldLugar.setText("");
		textFieldFecha.setText("");
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
	 * @return El panel con sus componentes añadidos
	 */
	public JPanel getJPanel(int x, int y, int width, int height, String name) {
		// Usamos this para coger el de esta clase
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(Color.pink);
		this.setName(name);

		return this;
	}
}
