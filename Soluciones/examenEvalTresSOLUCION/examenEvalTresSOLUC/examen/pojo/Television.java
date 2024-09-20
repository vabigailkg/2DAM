package examenEvalTresSOLUC.examen.pojo;

import java.io.Serializable;
import java.util.Objects;

public class Television extends Producto implements Serializable{

	private static final long serialVersionUID = -515036517425711016L;
	
	private boolean inteligente = false;

	public boolean isInteligente() {
		return inteligente;
	}

	public void setInteligente(boolean inteligente) {
		this.inteligente = inteligente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(inteligente);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Television other = (Television) obj;
		return inteligente == other.inteligente;
	}

	@Override
	public String toString() {
		return super.toString() + " [inteligente=" + inteligente + "]";
	}
}
