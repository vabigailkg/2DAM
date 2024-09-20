package examenEvalTresSOLUC.examen.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Videoconsola extends Producto implements Serializable{

	private static final long serialVersionUID = 3369469224770574460L;

	private Date fechaEntrada = null;
	private boolean juegosDeRegalo = false;

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public boolean getJuegosDeRegalo() {
		return juegosDeRegalo;
	}

	public void setJuegosDeRegalo(boolean juegosDeRegalo) {
		this.juegosDeRegalo = juegosDeRegalo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fechaEntrada, juegosDeRegalo);
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
		Videoconsola other = (Videoconsola) obj;
		return Objects.equals(fechaEntrada, other.fechaEntrada) && juegosDeRegalo == other.juegosDeRegalo;
	}

	@Override
	public String toString() {
		return super.toString() + " [fechaEntrada=" + fechaEntrada + ", juegosDeRegalo=" + juegosDeRegalo + "]";
	}
}
