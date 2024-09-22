package utils.functionalities;

import java.util.Date;

public class Sesion {
	private static Sesion instance=null;
	//usuario
	private String login = null;
	private String password = null;
	private boolean isAdmin = false;
	private Date lastPlay = null;
	private String firstSurname = null;
	private String secondSurname = null;
	private String idCard = null;
	private Date birthday = null;
	private String address=null;
	private String postalCode = null;
	private String city = null;
	private String province = null;
	private Date lastAccess = null;
	boolean isBlocked = false;
	private String userType=null;
	private Date registerDate = null;
	
	private Long cardNumber = 0L;	//0L → L parse to long
	private String expirationDate = null;
	private int cvv = 0;
	
	//grupo
	private Integer numReproduccion = 0;
	//author
	private int idAuthor = 0;
	private String imagen = null;
	private String name = null;
	private String description = null;
	private Date creationDate = null;
	//album
	private  int idAlbum = 0;
	private int idGroup=0;
	private String cdImage = null;
	private String title = null;
	private Date publicationDate = null;
	private String genre = null;
	//serie
	private int idSeries = 0;
	private String topic = null;
	private Date startDate = null;
	private Date endDate = null;
	//song
	private int idContent = 0;
	private int playAmount = 0;
	private String duration = null;
	private Sesion() {

	}

	public static Sesion getInstance() {
	if (null == instance) {
	instance = new Sesion();
	}
	return instance;
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Date getLastPlay() {
		return lastPlay;
	}

	public void setLastPlay(Date lastPlay) {
		this.lastPlay = lastPlay;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
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

	public Integer getNumReproduccion() {
		return numReproduccion;
	}

	public void setNumReproduccion(Integer numReproduccion) {
		this.numReproduccion = numReproduccion;
	}

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

	public int getIdSeries() {
		return idSeries;
	}

	public void setIdSeries(int idSeries) {
		this.idSeries = idSeries;
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

	public int getIdContent() {
		return idContent;
	}

	public void setIdContent(int idContent) {
		this.idContent = idContent;
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

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public static void setInstance(Sesion instance) {
		Sesion.instance = instance;
	}

	
}
