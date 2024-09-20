package processBuilder;

import java.io.IOException;
import java.io.OutputStream;

public class Ej_ProcessEscribir {

	public static void main(String[] args) {
		ProcessBuilder processBuilder = new ProcessBuilder("CMD");
		try {
			OutputStream os = p.getOutputStream();
			String dato = "DatoParaElPrograma\\n";
			os.write(dato.getBytes());
			os.flush();
			er.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
