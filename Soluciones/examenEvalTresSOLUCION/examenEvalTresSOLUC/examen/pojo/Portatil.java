package examenEvalTresSOLUC.examen.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Portatil extends Producto implements Serializable{

	private static final long serialVersionUID = -8875090068089271448L;

	private Date fechaEntrada = null;
	private String tipo = null;

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fechaEntrada, tipo);
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
		Portatil other = (Portatil) obj;
		return Objects.equals(fechaEntrada, other.fechaEntrada) && Objects.equals(tipo, other.tipo);
	}

	@Override
	public String toString() {
		return super.toString() + " [fechaEntrada=" + fechaEntrada + ", tipo=" + tipo + "]";
	}
}
