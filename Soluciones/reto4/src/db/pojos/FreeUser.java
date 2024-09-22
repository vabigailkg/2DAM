package db.pojos;

import java.util.Date;
import java.util.Objects;

public class FreeUser extends User {
	Date lastPlay = null;

	public Date getLastPlay() {
		return lastPlay;
	}

	public void setLastPlay(Date lastPlay) {
		this.lastPlay = lastPlay;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(lastPlay);
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
		FreeUser other = (FreeUser) obj;
		return Objects.equals(lastPlay, other.lastPlay);
	}

	@Override
	public String toString() {
		return "FreeUser [lastPlay=" + lastPlay + "]";
	}

}
