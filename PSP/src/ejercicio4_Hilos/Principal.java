package ejercicio4_Hilos;

/**
 * Clase que contiene el main, que instanciará cuatro hilos de tipo
 * DetonadorConRetardo y los ejecutará. Cada hilo hará lo siguiente:
 * 
 * Se le inicializa con un nombre y un valor numérico (contador).
 * 
 * Cuando el hilo se ejecute, escribe su nombre y el contador. A continuación,
 * reduce el valor del contador en 1. Repite estas acciones hasta que el valor
 * de contador sea 0
 * 
 * Al completar su tarea, informa de que ha finalizado.
 * 
 * El hilo principal del programa (main) NO debe de finalizar antes que los
 * demás hilos.
 */
public class Principal {

	public static void main(String[] args) {
		// Creamos los hilos de tipo DetonadorConRetardo con nombre y contador
		DetonadorConRetardo hilo1 = new DetonadorConRetardo("Hilo1", 4);
		DetonadorConRetardo hilo2 = new DetonadorConRetardo("Hilo2", 4);
		DetonadorConRetardo hilo3 = new DetonadorConRetardo("Hilo3", 4);
		DetonadorConRetardo hilo4 = new DetonadorConRetardo("Hilo4", 4);

		// Arrancamos hilos
		hilo1.start();
		hilo2.start();
		hilo3.start();
		hilo4.start();

		try {
			// Juntos para que sólo muestre el mensaje cuando acaben
			hilo1.join();
			hilo2.join();
			hilo3.join();
			hilo4.join();
		} catch (InterruptedException e) {
		}

		// Informamos de que ha finalizado la tarea
		System.out.println("Tarea completada.");
	}

}
