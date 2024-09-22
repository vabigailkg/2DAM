package cuentasBancarias.modelo.pojos;

import java.io.Serializable;

public class CuentaAhorro extends CuentaBancaria implements Serializable {

	private static final long serialVersionUID = 2678513266191544930L;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CuentaAhorro [toString()=" + super.toString() + "]";
	}

}
