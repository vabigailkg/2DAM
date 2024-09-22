package pojos;

import java.util.Objects;

public class PremiumUser extends User {
	int cardNumber = 0;
	String expirationDate = null;
	int cvv = 0;

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cardNumber, cvv, expirationDate);
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
		PremiumUser other = (PremiumUser) obj;
		return cardNumber == other.cardNumber && cvv == other.cvv
				&& Objects.equals(expirationDate, other.expirationDate);
	}

	@Override
	public String toString() {
		return "PremiumUser [cardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", cvv=" + cvv + "]";
	}

}
