package pojos;

import java.util.Date;
import java.util.Objects;

public abstract class User {
	String name = null;
	String firstSurname = null;
	String secondSurname = null;
	String idCard = null;
	Date birthday = null;
	String postalCode = null;
	String city = null;
	String province = null;
	String login = null;
	String password = null;
	Date lastAccess = null;
	boolean isBlocked = false;
	Date registerDate = null;
	boolean isAdmin = false;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(Date lastAccess) {
		this.lastAccess = lastAccess;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, city, firstSurname, idCard, isAdmin, isBlocked, lastAccess, login, name, password,
				postalCode, province, registerDate, secondSurname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(city, other.city)
				&& Objects.equals(firstSurname, other.firstSurname) && Objects.equals(idCard, other.idCard)
				&& isAdmin == other.isAdmin && isBlocked == other.isBlocked
				&& Objects.equals(lastAccess, other.lastAccess) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(postalCode, other.postalCode) && Objects.equals(province, other.province)
				&& Objects.equals(registerDate, other.registerDate)
				&& Objects.equals(secondSurname, other.secondSurname);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", firstSurname=" + firstSurname + ", secondSurname=" + secondSurname
				+ ", idCard=" + idCard + ", birthday=" + birthday + ", postalCode=" + postalCode + ", city=" + city
				+ ", province=" + province + ", login=" + login + ", password=" + password + ", lastAccess="
				+ lastAccess + ", isBlocked=" + isBlocked + ", registerDate=" + registerDate + ", isAdmin=" + isAdmin
				+ "]";
	}

}
