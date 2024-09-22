package ejercicio2;

import java.io.Serializable;
import java.util.Objects;

public class Videojuego implements Serializable {

	private static final long serialVersionUID = -3737517611012398533L;

	private String titulo = null;
	private String empresa = null;
	private String fecha = null;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empresa, fecha, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(empresa, other.empresa) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "titulo=" + titulo + ", empresa=" + empresa + ", fecha=" + fecha;
	}

}
