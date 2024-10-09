package ejercicio5_Hilos;

public class HiloContador extends Thread {
	
	// Flag para detener el hilo
	private volatile boolean ejecutar = true;
	private int contador;
	
	// Constructor
	public HiloContador(String nombre, int contador) {
		super(nombre);
		this.contador = contador;
	}
	
	// Proceso que hace cada hilo
		public void run() {
			// El hilo va restando 1 al contador mientras sea > 0
			for (int i = 1; i < contador; i++) {
				// Muestra el nombre y el numero del contador
				System.out.println(getName() + ":" + i);
				try {
					sleep(1000);
				} catch (InterruptedException ignore) {
					i = contador;
					System.out.println("Deteniendo el proceso.");
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
