package beginmystartup_pojo;

public class EducationDetails {

	private String eduid;
	private String collegename;
	private String qualifivcation;
	private String stream;
	private String grade;
	private String fromday;
	private String today;
	private String description;
	private String userid;
	public EducationDetails(String eduid, String collegename, String qualifivcation, String stream, String grade,
			String fromday, String today, String description, String userid) {
		super();
		this.eduid = eduid;
		this.collegename = collegename;
		this.qualifivcation = qualifivcation;
		this.stream = stream;
		this.grade = grade;
		this.fromday = fromday;
		this.today = today;
		this.description = description;
		this.userid = userid;
	}
	public String getEduid() {
		return eduid;
	}
	public void setEduid(String eduid) {
		this.eduid = eduid;
	}
	public String getCollegename() {
		return collegename;
	}
	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}
	public String getQualifivcation() {
		return qualifivcation;
	}
	public void setQualifivcation(String qualifivcation) {
		this.qualifivcation = qualifivcation;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getFromday() {
		return fromday;
	}
	public void setFromday(String fromday) {
		this.fromday = fromday;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "Education [eduid=" + eduid + ", collegename=" + collegename + ", qualifivcation=" + qualifivcation
				+ ", stream=" + stream + ", grade=" + grade + ", fromday=" + fromday + ", today=" + today
				+ ", description=" + description + ", userid=" + userid + "]";
	}
	
	
	
}
