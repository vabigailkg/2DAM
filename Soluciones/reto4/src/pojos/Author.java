package pojos;

import java.util.Date;
import java.util.Objects;

public abstract class Author {
	int idAuthor = 0;
	String imagen = null;
	String name = null;
	String description = null;
	Date creationDate = null;
	public int getIdAuthor() {
		return idAuthor;
	}
	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(creationDate, description, idAuthor, imagen, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(creationDate, other.creationDate) && Objects.equals(description, other.description)
				&& idAuthor == other.idAuthor && Objects.equals(imagen, other.imagen)
				&& Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Author [idAuthor=" + idAuthor + ", imagen=" + imagen + ", name=" + name + ", description=" + description
				+ ", creationDate=" + creationDate + "]";
	}

}