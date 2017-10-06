package beginmystartup_pojo;

public class Skills {

	private String skillid;
	private String skillname;
	private String userid;
	public Skills(String skillid, String skillname, String userid) {
		super();
		this.skillid = skillid;
		this.skillname = skillname;
		this.userid = userid;
	}
	public String getSkillid() {
		return skillid;
	}
	public void setSkillid(String skillid) {
		this.skillid = skillid;
	}
	public String getSkillname() {
		return skillname;
	}
	public void setSkillname(String skillname) {
		this.skillname = skillname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Skills [skillid=" + skillid + ", skillname=" + skillname + ", userid=" + userid + "]";
	}
	
	
	
}
