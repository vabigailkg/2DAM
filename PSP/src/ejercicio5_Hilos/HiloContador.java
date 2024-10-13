package ejercicio5_Hilos;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class HiloContador extends Thread {
	
	private volatile boolean ejecutar = true; // Flag para detener o ejecutar el hilo
	private int contador;
	private JLabel label;

	// Constructor
	public HiloContador(String nombre, int contador, JLabel label) {
		super(nombre);
		this.contador = contador;
		this.label = label;
	}

	// Proceso que hace cada hilo
	public void run() {
		// El hilo va incrementando el contador cada segundo
		while (ejecutar) {
			contador++;
			System.out.println(getName() + ": " + contador);

			// Actualiza el JLabel con el contador, asegurando que se hace en el hilo de
			// eventos de Swing
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					label.setText(String.valueOf(contador));
				}
			});

			try {
				sleep(1000); // Espera de 1 segundo entre incrementos
			} catch (InterruptedException e) {
				ejecutar = false;
				System.out.println(getName() + " detenido.");
			}
		}

		System.out.println("Fin" + getName());
	}

	// Método para detener el hilo
	public void detener() {
		// Cambia la flag y para el hilo
		ejecutar = false;
	}

}
