package databaseConnections;

public class EmpAddress {
	private int addressId;
	private int aptNum;
	private String streetName;
	private String city;
	private String state;
	private int zipCode;
	private String country;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getAptNum() {
		return aptNum;
	}

	public void setAptNum(int aptNum) {
		this.aptNum = aptNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "EmpAddress [addressId=" + addressId + ", aptNum=" + aptNum + ", streetName=" + streetName + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + "]";
	}
	
}
