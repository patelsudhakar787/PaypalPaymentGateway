package beginmystartup_pojo;

public class PersonalDetails {


	private String emailid;
	private String mobilenumber;
	private String address;
	public PersonalDetails(String emailid, String mobilenumber, String address) {
		super();
		this.emailid = emailid;
		this.mobilenumber = mobilenumber;
		this.address = address;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "PersionalDetails [emailid=" + emailid + ", mobilenumber=" + mobilenumber + ", address=" + address + "]";
	}
	
	
	
	
}
