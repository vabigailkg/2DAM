package ejercicio4_Hilos;

public class DetonadorConRetardo extends Thread {

	private int numero;

	// Constructor
	public DetonadorConRetardo(String nombre, int numero) {
		super(nombre);
		this.numero = numero;
	}

	// Proceso que hace cada hilo
	public void run() {
		// El hilo va restando 1 al contador mientras sea > 0
		for (int i = numero; i > 0; i--) {
			// Muestra el nombre y el numero del contador
			System.out.println(getName() + ":" + i);
			try {
				sleep(1000);
			} catch (InterruptedException ignore) {
				i = numero;
				System.out.println("Deteniendo el proceso.");
			}
		}

		System.out.println("Fin" + getName());
	}
}
