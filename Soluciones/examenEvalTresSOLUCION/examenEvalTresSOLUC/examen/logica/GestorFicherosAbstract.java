package examenEvalTresSOLUC.examen.logica;

import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public abstract class GestorFicherosAbstract {

	protected String path = "c://Trastero//";
	
	protected String filenameVideo = path + "videoconsola.dat";
	protected String filenameTele = path + "television.dat";
	protected String filenamePorta = path + "portatil.dat";

	protected class MyObjectOutputStream extends ObjectOutputStream {

		public MyObjectOutputStream() throws IOException {
			super();
		}

		public MyObjectOutputStream(OutputStream o) throws IOException {
			super(o);
		}

		public void writeStreamHeader() throws IOException {
			return;
		}
	}
	
	protected boolean fileIsEmpty(String file) {
		return (new File(file)).length() == 0? true : false;
	}
}
