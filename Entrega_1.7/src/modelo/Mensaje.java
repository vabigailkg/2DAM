package modelo;

import java.util.Objects;

/**
 * Clase que representa un mensaje con atributos.
 */
public class Mensaje {

	// Atributos (campos) de un mensaje
	private String fecha;
	private String hora;
	private String para;
	private String de;
	private String asunto;
	private String contenido;

	public Mensaje(String fecha, String hora, String para, String de, String asunto, String contenido) {
		this.fecha = fecha;
		this.hora = hora;
		this.para = para;
		this.de = de;
		this.asunto = asunto;
		this.contenido = contenido;
	}

	// Getters y setters para los atributos
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getDe() {
		return de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asunto, contenido, de, fecha, hora, para);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mensaje other = (Mensaje) obj;
		return Objects.equals(asunto, other.asunto) && Objects.equals(contenido, other.contenido)
				&& Objects.equals(de, other.de) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && Objects.equals(para, other.para);
	}

	@Override
	public String toString() {
		return "Mensaje [fecha=" + fecha + ", hora=" + hora + ", para=" + para + ", de=" + de + ", asunto=" + asunto
				+ ", contenido=" + contenido + "]";
	}

}
