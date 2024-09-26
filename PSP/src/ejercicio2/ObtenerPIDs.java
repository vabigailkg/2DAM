package ejercicio2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;

/**
 * El programa consistirá en tres botones que iniciarán diferentes procesos:
 * 
 * 1.Ejecutará un programa del sistema.
 * 
 * 2. Ejecutará un comando sobre la consola de Windows (cmd).
 * 
 * 3. Llamará 5 veces al programa ya implementado el cual pide un dato y lo
 * imprime por pantalla.
 * 
 * Además de ejecutar los diferentes procesos, deberemos obtener el PID de cada
 * proceso (en el caso del tercer proceso serán 5 PID diferentes).
 * 
 * También obtendremos el PID del proceso padre y el resultado de la ejecución
 * del segundo y el tercer proceso.
 * 
 */
public class ObtenerPIDs extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextArea textResult1;
	private JTextArea textResult2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ObtenerPIDs frame = new ObtenerPIDs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ObtenerPIDs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 234, 244));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPID1 = new JLabel("");
		lblPID1.setBounds(146, 159, 46, 14);
		contentPane.add(lblPID1);

		JLabel lblPID2 = new JLabel("");
		lblPID2.setBounds(275, 159, 46, 14);
		contentPane.add(lblPID2);

		JLabel lblPID3 = new JLabel("");
		lblPID3.setBounds(466, 159, 46, 14);
		contentPane.add(lblPID3);

		JLabel lblPadre1 = new JLabel("");
		lblPadre1.setBounds(146, 203, 46, 14);
		contentPane.add(lblPadre1);

		JLabel lblPadre2 = new JLabel("");
		lblPadre2.setBounds(275, 203, 46, 14);
		contentPane.add(lblPadre2);

		JLabel lblPadre3 = new JLabel("");
		lblPadre3.setBounds(466, 203, 46, 14);
		contentPane.add(lblPadre3);

		text1 = new JTextField();
		text1.setBounds(76, 46, 86, 20);
		contentPane.add(text1);
		text1.setColumns(10);

		text2 = new JTextField();
		text2.setBounds(264, 46, 86, 20);
		contentPane.add(text2);
		text2.setColumns(10);

		text3 = new JTextField();
		text3.setBounds(445, 46, 86, 20);
		contentPane.add(text3);
		text3.setColumns(10);

		JButton btn1 = new JButton("Start");
		btn1.setBounds(76, 77, 89, 23);
		contentPane.add(btn1);
		// Evento que ejecuta el proceso que introduce el usuario
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String programa = text1.getText(); // Obtiene el programa del text1
				if (!programa.isEmpty()) { // Verifica que no esté vacío
					try {
						ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
						Process proceso = processBuilder.start();

						// Muestra el PID del proceso
						lblPID1.setText(String.valueOf(proceso.pid()));
						lblPadre1.setText(String.valueOf(ProcessHandle.current().pid()));

						InputStream entrada = proceso.getInputStream();
						StringBuilder resultado = new StringBuilder();

						textResult1.setText(resultado.toString()); // Mostrar resultado en textResult1

						entrada.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else {
					System.out.println("Por favor, introduce un comando válido.");
				}
			}
		});

		JButton btn2 = new JButton("Start");
		btn2.setBounds(261, 77, 89, 23);
		contentPane.add(btn2);
		// Evento que ejecuta un comando (ipconfig) en cmd
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String comando = text2.getText(); // Obtiene el comando del text2
				if (!comando.isEmpty()) { // Verifica que no esté vacío
					try {
						ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", comando);
						Process proceso = processBuilder.start();

						// Mostrar el PID del proceso en lblPID2
						lblPID2.setText(String.valueOf(proceso.pid()));
						lblPadre2.setText(String.valueOf(ProcessHandle.current().pid()));

						// Obtiene la señal de entrada del proceso (como el teclado) y la muestra
						InputStream entrada = proceso.getInputStream();

						// Lee la entrada en ASCII, la convierte en char para que sea legible, la
						// imprime 1 a 1
						StringBuilder resultado = new StringBuilder();
						int caracter;
						while ((caracter = entrada.read()) != -1) {
							resultado.append((char) caracter);
						}

						// Mostramos el resultado en el textResult1
						textResult1.setText(resultado.toString());

						entrada.close();
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				} else {
					System.out.println("Por favor, introduce un comando válido.");
				}
			}
		});

		JButton btn3 = new JButton("Start");
		btn3.setBounds(445, 77, 89, 23);
		contentPane.add(btn3);
		// Evento que llama 5 veces a EjemploLectura y pide por teclado
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Iteramos 5 veces
				for (int i = 0; i < 5; i++) {
					try {
						// Le decimos que queremos ejecutar 'Ejer7' (comando, ruta)
						ProcessBuilder processBuilder = new ProcessBuilder("java", "ejercicio1.Ejer7");
						processBuilder.directory(new File("bin")); // Carpeta con el .class de EjemploLectura
						Process proceso = processBuilder.start();// Iniciamos en var proceso

						// Mostrar el PID del proceso en lblPID3
						lblPID3.setText(String.valueOf(proceso.pid()));
						lblPadre3.setText(String.valueOf(ProcessHandle.current().pid()));

						// Capturamos la salida del proceso (que incluye la salida de EjemploLectura)
						InputStream entradaProceso = proceso.getInputStream();
						BufferedReader reader = new BufferedReader(new InputStreamReader(entradaProceso));

						// Lee la entrada en ASCII, la convierte en char para que sea legible, la
						// imprime 1 a 1
						StringBuilder resultados = new StringBuilder();
						int caracter;
						while ((caracter = entradaProceso.read()) != -1) {
							resultados.append((char) caracter);
						}

						// Esperamos a que el proceso termine
						int valorRetorno = proceso.waitFor();
						if (valorRetorno == 0) {
							System.out.println("'Ejer7' finalizado con éxito " + (i + 1));
						} else {
							System.out.println("'Ejer7' falló ");
						}

						// Mostrar todos los resultados en textResult2 al final
						textResult2.setText(resultados.toString());

						// Cerramos el lector
						reader.close();
					} catch (IOException | InterruptedException ex) {
						ex.printStackTrace();
					}

				}

			}

		});

		JLabel lblPID = new JLabel("PID");
		lblPID.setBounds(44, 159, 46, 14);
		contentPane.add(lblPID);

		JLabel lblPadre = new JLabel("PID Padre");
		lblPadre.setBounds(44, 203, 68, 14);
		contentPane.add(lblPadre);

		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(44, 249, 54, 14);
		contentPane.add(lblResultado);

		textResult1 = new JTextArea(); // Lo convertimos a JTextArea para ajustar el formato al campo
		textResult1.setBounds(146, 246, 231, 184);
		textResult1.setLineWrap(true); // Habilitar el ajuste de línea
		contentPane.add(textResult1);
		textResult1.setColumns(10);

		textResult2 = new JTextArea(); // Lo convertimos a JTextArea para ajustar el formato al campo
		textResult2.setBounds(387, 246, 227, 184);
		textResult1.setLineWrap(true); // Habilitar el ajuste de línea
		contentPane.add(textResult2);
		textResult2.setColumns(10);

	}
}
