
public class Section {
	private String sectionID;
	private String day;
	private String startTime;
	private String endTime;
	private String building;
	private String room;
	private String crn;
	private int credit;

	public String getSectionID() {
		return sectionID;
	}

	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Section(String sectionID, String day, String startTime,
			String endTime, String building, String room, String crn, int credit) {
		this.sectionID = sectionID;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.building = building;
		this.room = room;
		this.crn = crn;
		this.credit = credit;
	}

}
