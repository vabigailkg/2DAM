package cuentasBancarias.modelo.pojos;

import java.io.Serializable;
import java.util.Objects;

public class CuentaEmpresa extends CuentaBancaria implements Serializable {

	private static final long serialVersionUID = -1331522799249332759L;

	private String iban = null;

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(iban);
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
		CuentaEmpresa other = (CuentaEmpresa) obj;
		return Objects.equals(iban, other.iban);
	}

	@Override
	public String toString() {
		return "CuentaEmpresa [iban=" + iban + ", toString()=" + super.toString() + "]";
	}

}
