package db.pojos;

import java.util.Date;
import java.util.Objects;

public class Album {

	int idAlbum = 0;
	int idGroup=0;
	String cdImage = null;
	String title = null;
	String description = null;
	Date publicationDate = null;
	String genre = null;
	int numReproduccion = 0;
	
	public int getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	public int getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}
	public String getCdImage() {
		return cdImage;
	}
	public void setCdImage(String cdImage) {
		this.cdImage = cdImage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getNumReproduccion() {
		return numReproduccion;
	}
	public void setNumReproduccion(int numRepodruccion) {
		this.numReproduccion = numRepodruccion;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cdImage, description, genre, idAlbum, idGroup, numReproduccion, publicationDate, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return Objects.equals(cdImage, other.cdImage) && Objects.equals(description, other.description)
				&& Objects.equals(genre, other.genre) && idAlbum == other.idAlbum && idGroup == other.idGroup
				&& numReproduccion == other.numReproduccion && Objects.equals(publicationDate, other.publicationDate)
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Album [idAlbum=" + idAlbum + ", idGroup=" + idGroup + ", cdImage=" + cdImage + ", title=" + title
				+ ", description=" + description + ", publicationDate=" + publicationDate + ", genre=" + genre
				+ ", numRepodruccion=" + numReproduccion + "]";
	}
	
	
}