package beginmystartup_pojo;

public class BasicDetails {
	
	private String firstname;
	private String middlename;
	private String lastname;
	private String dob;
	private String gender;
	private String contact;
	private String emailid;
	private String adharuino;
	private String temperaryaddress;
	private String permanentaddress;
	private String city;
	private String pincode;
	public BasicDetails(String firstname, String middlename, String lastname, String dob, String gender, String contact,
			String emailid, String adharuino, String temperaryaddress, String permanentaddress, String city,
			String pincode) {
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.contact = contact;
		this.emailid = emailid;
		this.adharuino = adharuino;
		this.temperaryaddress = temperaryaddress;
		this.permanentaddress = permanentaddress;
		this.city = city;
		this.pincode = pincode;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getMiddlename() {
		return middlename;
	}
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getAdharuino() {
		return adharuino;
	}
	public void setAdharuino(String adharuino) {
		this.adharuino = adharuino;
	}
	public String getTemperaryaddress() {
		return temperaryaddress;
	}
	public void setTemperaryaddress(String temperaryaddress) {
		this.temperaryaddress = temperaryaddress;
	}
	public String getPermanentaddress() {
		return permanentaddress;
	}
	public void setPermanentaddress(String permanentaddress) {
		this.permanentaddress = permanentaddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Override
	public String toString() {
		return "BasicDetails [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname
				+ ", dob=" + dob + ", gender=" + gender + ", contact=" + contact + ", emailid=" + emailid
				+ ", adharuino=" + adharuino + ", temperaryaddress=" + temperaryaddress + ", permanentaddress="
				+ permanentaddress + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	

}
