package modelo;

import java.util.Objects;

/**
 * Clase que representa un partido con atributos.
 */
public class Partido {

	// Atributos de Partido
	private String equipoLocal;
	private String equipoVisitante;
	private int golLocal;
	private int golVisitante;
	private String lugar;
	private String fecha;

	// Constructor
	public Partido(String equipoLocal, String equipoVisitante, int golLocal, int golVisitante, String lugar,
			String fecha) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.golLocal = golLocal;
		this.golVisitante = golVisitante;
		this.lugar = lugar;
		this.fecha = fecha;
	}

	public String getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(String equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public String getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(String equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public int getGolLocal() {
		return golLocal;
	}

	public void setGolLocal(int golLocal) {
		this.golLocal = golLocal;
	}

	public int getGolVisitante() {
		return golVisitante;
	}

	public void setGolVisitante(int golVisitante) {
		this.golVisitante = golVisitante;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(equipoLocal, equipoVisitante, fecha, golLocal, golVisitante, lugar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partido other = (Partido) obj;
		return Objects.equals(equipoLocal, other.equipoLocal) && Objects.equals(equipoVisitante, other.equipoVisitante)
				&& Objects.equals(fecha, other.fecha) && golLocal == other.golLocal
				&& golVisitante == other.golVisitante && Objects.equals(lugar, other.lugar);
	}

	@Override
	public String toString() {
		return "Partido [equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", golLocal=" + golLocal
				+ ", golVisitante=" + golVisitante + ", lugar=" + lugar + ", fecha=" + fecha + "]";
	}

}
