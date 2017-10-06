package joinasmentorpojo;

public class LoginAsMentor {
	
	private String emailid;
	private String password;
	private String registrationstatus;
	private String mentorid;
	private String areaofsupport;
	public LoginAsMentor(String emailid, String password, String registrationstatus, String mentorid,
			String areaofsupport) {
		super();
		this.emailid = emailid;
		this.password = password;
		this.registrationstatus = registrationstatus;
		this.mentorid = mentorid;
		this.areaofsupport = areaofsupport;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRegistrationstatus() {
		return registrationstatus;
	}
	public void setRegistrationstatus(String registrationstatus) {
		this.registrationstatus = registrationstatus;
	}
	public String getMentorid() {
		return mentorid;
	}
	public void setMentorid(String mentorid) {
		this.mentorid = mentorid;
	}
	public String getAreaofsupport() {
		return areaofsupport;
	}
	public void setAreaofsupport(String areaofsupport) {
		this.areaofsupport = areaofsupport;
	}
	@Override
	public String toString() {
		return "LoginAsMentor [emailid=" + emailid + ", password=" + password + ", registrationstatus="
				+ registrationstatus + ", mentorid=" + mentorid + ", areaofsupport=" + areaofsupport + "]";
	}
	
	
	

}
