package beginmystartup_pojo;

public class NewUserRequestSupport {

	private String requestsupportid;
	private String supporttype;
	private String desciption;
	private String ideaid;
	public NewUserRequestSupport(String requestsupportid, String supporttype, String desciption, String ideaid) {
		super();
		this.requestsupportid = requestsupportid;
		this.supporttype = supporttype;
		this.desciption = desciption;
		this.ideaid = ideaid;
	}
	public String getRequestsupportid() {
		return requestsupportid;
	}
	public void setRequestsupportid(String requestsupportid) {
		this.requestsupportid = requestsupportid;
	}
	public String getSupporttype() {
		return supporttype;
	}
	public void setSupporttype(String supporttype) {
		this.supporttype = supporttype;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public String getIdeaid() {
		return ideaid;
	}
	public void setIdeaid(String ideaid) {
		this.ideaid = ideaid;
	}
	@Override
	public String toString() {
		return "NewUserRequestSupport [requestsupportid=" + requestsupportid + ", supporttype=" + supporttype
				+ ", desciption=" + desciption + ", ideaid=" + ideaid + "]";
	}
	
	
}
