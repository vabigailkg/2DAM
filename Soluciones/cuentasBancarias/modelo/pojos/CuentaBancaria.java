package cuentasBancarias.modelo.pojos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public abstract class CuentaBancaria implements Serializable {

	private static final long serialVersionUID = 7525188486929660007L;

	private int id = 0;
	private String numeroCuenta = null;
	private String titular = null;
	private long importe = 0;
	private Date fechaApertura = null;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public long getImporte() {
		return importe;
	}

	public void setImporte(long importe) {
		this.importe = importe;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fechaApertura, id, importe, numeroCuenta, titular);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		return Objects.equals(fechaApertura, other.fechaApertura) && id == other.id && importe == other.importe
				&& Objects.equals(numeroCuenta, other.numeroCuenta) && Objects.equals(titular, other.titular);
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", numeroCuenta=" + numeroCuenta + ", titular=" + titular + ", importe="
				+ importe + ", fechaApertura=" + fechaApertura + ", toString()=" + super.toString() + "]";
	}

}
