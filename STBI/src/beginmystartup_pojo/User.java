package beginmystartup_pojo;

public class User {
	
	private String userid;
	private String firstname;
	private String lastname;
	private String dob;
	private String mobilenumber;
	private String emaiid;
	private String password;
	private String adharcardno;
	private String temporaryaddress;
	private String permanentaddress;
	private String city;
	private String pincode;
	private String regiverfication;
	private String uuidnumber;
	private String emailtodate;
	private String emaistatus;
	
	
	public User(String userid, String emaiid, String password) {
		super();
		this.userid = userid;
		this.emaiid = emaiid;
		this.password = password;
	}
	
	
	public User(String userid, String firstname, String lastname, String dob, String mobilenumber, String emaiid,
			String password, String adharcardno, String temporaryaddress, String permanentaddress, String city,
			String pincode, String regiverfication, String uuidnumber, String emailtodate, String emaistatus) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.mobilenumber = mobilenumber;
		this.emaiid = emaiid;
		this.password = password;
		this.adharcardno = adharcardno;
		this.temporaryaddress = temporaryaddress;
		this.permanentaddress = permanentaddress;
		this.city = city;
		this.pincode = pincode;
		this.regiverfication = regiverfication;
		this.uuidnumber = uuidnumber;
		this.emailtodate = emailtodate;
		this.emaistatus = emaistatus;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
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
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getEmaiid() {
		return emaiid;
	}
	public void setEmaiid(String emaiid) {
		this.emaiid = emaiid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdharcardno() {
		return adharcardno;
	}
	public void setAdharcardno(String adharcardno) {
		this.adharcardno = adharcardno;
	}
	public String getTemporaryaddress() {
		return temporaryaddress;
	}
	public void setTemporaryaddress(String temporaryaddress) {
		this.temporaryaddress = temporaryaddress;
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
	public String getRegiverfication() {
		return regiverfication;
	}
	public void setRegiverfication(String regiverfication) {
		this.regiverfication = regiverfication;
	}
	public String getUuidnumber() {
		return uuidnumber;
	}
	public void setUuidnumber(String uuidnumber) {
		this.uuidnumber = uuidnumber;
	}
	public String getEmailtodate() {
		return emailtodate;
	}
	public void setEmailtodate(String emailtodate) {
		this.emailtodate = emailtodate;
	}
	public String getEmaistatus() {
		return emaistatus;
	}
	public void setEmaistatus(String emaistatus) {
		this.emaistatus = emaistatus;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", dob=" + dob
				+ ", mobilenumber=" + mobilenumber + ", emaiid=" + emaiid + ", password=" + password + ", adharcardno="
				+ adharcardno + ", temporaryaddress=" + temporaryaddress + ", permanentaddress=" + permanentaddress
				+ ", city=" + city + ", pincode=" + pincode + ", regiverfication=" + regiverfication + ", uuidnumber="
				+ uuidnumber + ", emailtodate=" + emailtodate + ", emaistatus=" + emaistatus + "]";
	}
	
	
	

}
