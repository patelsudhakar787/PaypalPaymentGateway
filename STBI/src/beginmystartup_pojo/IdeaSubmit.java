package beginmystartup_pojo;

public class IdeaSubmit {

	private String ideaid;
	private String titlename;
	private String enterkeywords;
	private String keyusers;
	private String maxuser;
	private String targetmarket;
	private String ideadiscription;
	
	private String idaeregidate;
	private String statusofidea;
	private String userid;
	private String deleteideadescription;
	public IdeaSubmit(String ideaid, String titlename, String enterkeywords, String keyusers, String maxuser,
			String targetmarket, String ideadiscription, String idaeregidate, String statusofidea, String userid,
			String deleteideadescription) {
		super();
		this.ideaid = ideaid;
		this.titlename = titlename;
		this.enterkeywords = enterkeywords;
		this.keyusers = keyusers;
		this.maxuser = maxuser;
		this.targetmarket = targetmarket;
		this.ideadiscription = ideadiscription;
		this.idaeregidate = idaeregidate;
		this.statusofidea = statusofidea;
		this.userid = userid;
		this.deleteideadescription = deleteideadescription;
	}
	
	
	
	
	




	@Override
	public String toString() {
		return "IdeaSubmit [ideaid=" + ideaid + ", titlename=" + titlename + ", enterkeywords=" + enterkeywords
				+ ", keyusers=" + keyusers + ", maxuser=" + maxuser + ", targetmarket=" + targetmarket
				+ ", ideadiscription=" + ideadiscription + ", idaeregidate=" + idaeregidate + ", statusofidea="
				+ statusofidea + ", userid=" + userid + ", deleteideadescription=" + deleteideadescription + "]";
	}

	
	
}
