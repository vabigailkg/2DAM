package pojos;

import java.util.Date;
import java.util.Objects;

public class Series {
	int idSeries = 0;
	String title = null;
	String description = null;
	String topic = null;
	Date startDate = null;
	Date endDate = null;

	public int getIdSeries() {
		return idSeries;
	}

	public void setIdSeries(int idSeries) {
		this.idSeries = idSeries;
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

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, endDate, idSeries, startDate, title, topic);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Series other = (Series) obj;
		return Objects.equals(description, other.description) && Objects.equals(endDate, other.endDate)
				&& idSeries == other.idSeries && Objects.equals(startDate, other.startDate)
				&& Objects.equals(title, other.title) && Objects.equals(topic, other.topic);
	}

	@Override
	public String toString() {
		return "Series [idSeries=" + idSeries + ", title=" + title + ", description=" + description + ", topic=" + topic
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
