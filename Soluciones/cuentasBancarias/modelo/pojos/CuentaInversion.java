package cuentasBancarias.modelo.pojos;

import java.io.Serializable;
import java.util.Objects;

public class CuentaInversion extends CuentaBancaria implements Serializable {

	private static final long serialVersionUID = -5544675063972795935L;

	private int interes = 0;

	public int getInteres() {
		return interes;
	}

	public void setInteres(int interes) {
		this.interes = interes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(interes);
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
		CuentaInversion other = (CuentaInversion) obj;
		return interes == other.interes;
	}

	@Override
	public String toString() {
		return "CuentaInversion [interes=" + interes + ", toString()=" + super.toString() + "]";
	}

}
