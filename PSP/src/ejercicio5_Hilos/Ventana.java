package ejercicio5_Hilos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Creamos etiquetas para mostrar el contador
    JLabel lbl0Hil_1 = new JLabel("0");
    JLabel lbl0Hil_2 = new JLabel("0");
    JLabel lbl0Hil_3 = new JLabel("0");

	// Creamos hilos
	HiloContador hilo1 = new HiloContador("Hilo1", 0, lbl0Hil_1);
	HiloContador hilo2 = new HiloContador("Hilo2", 0, lbl0Hil_2);
	HiloContador hilo3 = new HiloContador("Hilo3", 0, lbl0Hil_3);
	
	// Prioridad de cada hilo
	int prioridad1 = 0;
	int prioridad2 = 0;
	int prioridad3 = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// Crea la ventana
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.pink);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// Colocar los labels del contador
        lbl0Hil_1.setBounds(157, 231, 46, 14);  // Posición para el contador del hilo 1
        contentPane.add(lbl0Hil_1);

        lbl0Hil_2.setBounds(157, 273, 46, 14);  // Posición para el contador del hilo 2
        contentPane.add(lbl0Hil_2);

        lbl0Hil_3.setBounds(157, 317, 46, 14);  // Posición para el contador del hilo 3
        contentPane.add(lbl0Hil_3);
        
		// Arrancamos hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
        
		JLabel lbl0Pri_1 = new JLabel("0");
		lbl0Pri_1.setBounds(434, 231, 46, 14);
		contentPane.add(lbl0Pri_1);

		JLabel lbl0Pri_2 = new JLabel("0");
		lbl0Pri_2.setBounds(434, 273, 46, 14);
		contentPane.add(lbl0Pri_2);

		JLabel lbl0Pri_3 = new JLabel("0");
		lbl0Pri_3.setBounds(434, 317, 46, 14);
		contentPane.add(lbl0Pri_3);
		
		JButton btnGuion1 = new JButton("--");
		btnGuion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.setPriority(Thread.MIN_PRIORITY);
				System.out.println("El hilo 1 tiene ahora prioridad mínima.");
				
				// Actualizar el JLabel con la nueva prioridad
		        lbl0Pri_1.setText(String.valueOf(hilo1.getPriority()));
			}
		});
		btnGuion1.setBounds(90, 41, 89, 23);
		contentPane.add(btnGuion1);

		JButton btnGuion2 = new JButton("--");
		btnGuion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.setPriority(Thread.MIN_PRIORITY);
				System.out.println("El hilo 2 tiene ahora prioridad mínima.");
				
				// Actualizar el JLabel con la nueva prioridad
				lbl0Pri_2.setText(String.valueOf(hilo2.getPriority()));
			}
		});
		btnGuion2.setBounds(90, 75, 89, 23);
		contentPane.add(btnGuion2);

		JButton btnGuion3 = new JButton("--");
		btnGuion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.setPriority(Thread.MIN_PRIORITY);
				System.out.println("El hilo 3 tiene ahora prioridad mínima.");
				
				// Actualizar el JLabel con la nueva prioridad
		        lbl0Pri_3.setText(String.valueOf(hilo3.getPriority()));
			}
		});
		btnGuion3.setBounds(90, 109, 89, 23);
		contentPane.add(btnGuion3);

		JButton btnFin1 = new JButton("Fin hilo 1");
		btnFin1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.interrupt();
				
				System.out.println("El hilo 1 se ha detenido.");
			}
		});
		btnFin1.setBounds(234, 41, 89, 23);
		contentPane.add(btnFin1);

		JButton btnFin2 = new JButton("Fin hilo 2");
		btnFin2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.interrupt();
				
				System.out.println("El hilo 2 se ha detenido.");
			}
		});
		btnFin2.setBounds(234, 75, 89, 23);
		contentPane.add(btnFin2);

		JButton btnFin3 = new JButton("Fin hilo 3");
		btnFin3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.interrupt();
				
				System.out.println("El hilo 3 se ha detenido.");
			}
		});
		btnFin3.setBounds(234, 109, 89, 23);
		contentPane.add(btnFin3);

		JButton btnSuma1 = new JButton("++");
		btnSuma1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.setPriority(Thread.MAX_PRIORITY);
				System.out.println("El hilo 1 tiene ahora prioridad máxima.");
				
				// Actualizar el JLabel con la nueva prioridad
		        lbl0Pri_1.setText(String.valueOf(hilo1.getPriority()));
			}
		});
		btnSuma1.setBounds(371, 41, 89, 23);
		contentPane.add(btnSuma1);

		JButton btnSuma2 = new JButton("++");
		btnSuma2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.setPriority(Thread.MAX_PRIORITY);
				System.out.println("El hilo 2 tiene ahora prioridad máxima.");
				
				// Actualizar el JLabel con la nueva prioridad
		        lbl0Pri_2.setText(String.valueOf(hilo2.getPriority()));
			}
		});
		btnSuma2.setBounds(371, 75, 89, 23);
		contentPane.add(btnSuma2);

		JButton btnSuma3 = new JButton("++");
		btnSuma3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.setPriority(Thread.MAX_PRIORITY);
				System.out.println("El hilo 3 tiene ahora prioridad máxima.");
				
				// Actualizar el JLabel con la nueva prioridad
		        lbl0Pri_3.setText(String.valueOf(hilo3.getPriority()));
			}
		});
		btnSuma3.setBounds(371, 109, 89, 23);
		contentPane.add(btnSuma3);

		JButton btnFinalizar = new JButton("Finalizar todos");
		btnFinalizar.setBounds(222, 169, 110, 23);
		contentPane.add(btnFinalizar);
		// Evento que mata todos los hilos
		btnFinalizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hilo1.detener();
				hilo2.detener();
				hilo3.detener();

				System.out.println("Todos los hilos se han detenido.");
			}
		});

		JLabel lblContador1 = new JLabel("Hilo 1: ");
		lblContador1.setBounds(111, 231, 46, 14);
		contentPane.add(lblContador1);

		JLabel lblContador2 = new JLabel("Hilo 2: ");
		lblContador2.setBounds(111, 273, 46, 14);
		contentPane.add(lblContador2);

		JLabel lblContador3 = new JLabel("Hilo 3: ");
		lblContador3.setBounds(111, 317, 46, 14);
		contentPane.add(lblContador3);

		JLabel lblPrioridad1 = new JLabel("Pri: ");
		lblPrioridad1.setBounds(397, 231, 46, 14);
		contentPane.add(lblPrioridad1);

		JLabel lblPrioridad2 = new JLabel("Pri: ");
		lblPrioridad2.setBounds(397, 273, 46, 14);
		contentPane.add(lblPrioridad2);

		JLabel lblPrioridad3 = new JLabel("Pri: ");
		lblPrioridad3.setBounds(397, 317, 46, 14);
		contentPane.add(lblPrioridad3);
	}

}
