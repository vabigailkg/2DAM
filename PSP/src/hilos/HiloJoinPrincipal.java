package hilos;

public class HiloJoinPrincipal extends Thread { // Thread siempre viene de extends

	private int n;

	// Constructor
	public HiloJoinPrincipal(String nom, int n) {
		super(nom); // siempre pasar nombre
		this.n = n;
	}

	/**
	 * Siempre debe haber run en hilos, es lo que ejecuta cada hilo
	 */
	public void run() {
		for (int i = 1; i < n; i++) {
			System.out.println(getName() + ":" + i);
			try {
				sleep(1000);
			} catch (InterruptedException ignore) {
				i = n;
				System.out.println("Deteniendo el proceso.");
			}
		}

		System.out.println("Fin bucle" + getName());
	}
}
