package db.pojos;

import java.util.Objects;

public class FavouriteList {
	int idFavouriteList = 0;
	String title = null;
	int audioAmount = 0;

	public int getIdFavouriteList() {
		return idFavouriteList;
	}

	public void setIdFavouriteList(int idFavouriteList) {
		this.idFavouriteList = idFavouriteList;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAudioAmount() {
		return audioAmount;
	}

	public void setAudioAmount(int audioAmount) {
		this.audioAmount = audioAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(audioAmount, idFavouriteList, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FavouriteList other = (FavouriteList) obj;
		return audioAmount == other.audioAmount && idFavouriteList == other.idFavouriteList
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "FavouriteList [idFavouriteList=" + idFavouriteList + ", title=" + title + ", audioAmount=" + audioAmount
				+ "]";
	}

}
