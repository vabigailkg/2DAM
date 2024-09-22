package db.pojos;

import java.util.Objects;

public class Group extends Author{
	
	Integer IdGroup = 0;
	Integer numReproduccion = 0;
	
	public Integer getIdGroup() {
		return IdGroup;
	}

	public void setIdGroup(Integer idGroup) {
		IdGroup = idGroup;
	}

	public Integer getNumReproduccion() {
		return numReproduccion;
	}

	public void setNumReproduccion(Integer numReproduccion) {
		this.numReproduccion = numReproduccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(IdGroup, numReproduccion);
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
		Group other = (Group) obj;
		return Objects.equals(IdGroup, other.IdGroup) && Objects.equals(numReproduccion, other.numReproduccion);
	}

	@Override
	public String toString() {
		return "Group [IdGroup=" + IdGroup + ", numReproduccion=" + numReproduccion + "]";
	}


}
