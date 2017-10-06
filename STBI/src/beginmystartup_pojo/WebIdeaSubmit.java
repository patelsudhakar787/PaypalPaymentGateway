package beginmystartup_pojo;

public class WebIdeaSubmit {
	
	private long ideaid;
	private long userid;
	private String titlename;
	private String ideadate;
	private String status;
	public WebIdeaSubmit(long ideaid, long userid, String titlename, String ideadate, String status) {
		super();
		this.ideaid = ideaid;
		this.userid = userid;
		this.titlename = titlename;
		this.ideadate = ideadate;
		this.status = status;
	}
	public long getIdeaid() {
		return ideaid;
	}
	public void setIdeaid(long ideaid) {
		this.ideaid = ideaid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getTitlename() {
		return titlename;
	}
	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}
	public String getIdeadate() {
		return ideadate;
	}
	public void setIdeadate(String ideadate) {
		this.ideadate = ideadate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "WebIdeaSubmit [ideaid=" + ideaid + ", userid=" + userid + ", titlename=" + titlename + ", ideadate="
				+ ideadate + ", status=" + status + "]";
	}
	

}
