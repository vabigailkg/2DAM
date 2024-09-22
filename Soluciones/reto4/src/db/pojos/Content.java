package db.pojos;

import java.util.Objects;

public abstract class Content {

	int idContent = 0;
	String title = null;
	int playAmount = 0;
	String duration = null;

	public int getIdContent() {
		return idContent;
	}

	public void setIdContent(int idContent) {
		this.idContent = idContent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPlayAmount() {
		return playAmount;
	}

	public void setPlayAmount(int playAmount) {
		this.playAmount = playAmount;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String durationString) {
		this.duration = durationString;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duration, idContent, playAmount, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Content other = (Content) obj;
		return duration == other.duration && idContent == other.idContent && playAmount == other.playAmount
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Content [idContent=" + idContent + ", title=" + title + ", playAmount=" + playAmount + ", duration="
				+ duration + "]";
	}

}
