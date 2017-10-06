package joinasmentorpojo;

public class MentorEducation {

	private int mentordeuid;
	private String collegename;
	private String qualification;
	private String stream;
	private String grade;
	private String fromdate;
	private String todate;
	private String description;
	private int mentorid;
	public MentorEducation(int mentordeuid, String collegename, String qualification, String stream, String grade,
			String fromdate, String todate, String description, int mentorid) {
		super();
		this.mentordeuid = mentordeuid;
		this.collegename = collegename;
		this.qualification = qualification;
		this.stream = stream;
		this.grade = grade;
		this.fromdate = fromdate;
		this.todate = todate;
		this.description = description;
		this.mentorid = mentorid;
	}
	
	
	
	
}
