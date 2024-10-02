package hilos;

public class HiloJoinSecundario {

	public static void main(String[] args) {
		HiloJoinPrincipal h1 = new HiloJoinPrincipal("Hilo1", 5);
		HiloJoinPrincipal h2 = new HiloJoinPrincipal("Hilo2", 5); // el numero son los milisegundos que tarda en responder
		HiloJoinPrincipal h3 = new HiloJoinPrincipal("Hilo3", 5);
		
		// comienzan los tres hilos
		h1.start();
		h2.start();
		h2.setPriority(Thread.MAX_PRIORITY); // le damos prioridad max al hilo 2 porque es el que más tarda
		h3.start();
		try {
			// el proceso espera 8 segundos
			Thread.sleep(8000);

			// tras los 8 seg, mata el segundo proceso
			h2.interrupt();

			// ponemos joins para que no saque el mensaje del catch hasta que terminen todos los hilos
			h1.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
		}
		System.out.println("FINAL DE PROGRAMA");
	}

}
