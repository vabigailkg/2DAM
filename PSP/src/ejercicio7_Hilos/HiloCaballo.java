package ejercicio7_Hilos;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class HiloCaballo extends Thread {

	private volatile boolean ejecutarHilos = true; // Estado del proceso con hilos
	private JProgressBar barraDeProgreso;
	private JLabel ganador;
	private static boolean hayGanador = false; // Variable compartida entre hilos para verificar si alguien ganó

	// Constructor
	public HiloCaballo(String caballo, JProgressBar barraDeProgreso, JLabel ganador) {
		super(caballo);
		this.barraDeProgreso = barraDeProgreso;
		this.ganador = ganador;
	}

	// Lo que hace cada hilo
	public void run() {
		while (ejecutarHilos && !hayGanador) {
			// Genera un número aleatorio entre 1 y 10
			int numeroAleatorio = (int) (Math.random() * 10) + 1;

			// Actualiza el progreso de la barra
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					int progresoTotal = barraDeProgreso.getValue() + numeroAleatorio;
					if (progresoTotal >= 100) {
						progresoTotal = 100; // El valor máximo es 100
						hayGanador = true; // Marca la carrera como finalizada
						ganador.setText(getName()); // Establece el nombre del ganador
						System.out.println(getName() + " ha ganado.");
					}
					barraDeProgreso.setValue(progresoTotal); // Actualiza el valor de la barra
				}
			});

			// Espera de 1 segundo entre cálculos
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				ejecutarHilos = false;
				System.out.println(getName() + " detenido.");
			}
		}
	}

	// Método para finalizar el proceso
	public void finalizar() {
		ejecutarHilos = false;
	}
}
