package store;

public class Section {
	private String sectionID;
	private String day;
	private String startTime;
	private String endTime;
	private String building;
	private String room;
	private String crn;
	private int credit;
	private int priority;
	private int courseConflict;
	

	public Section(String sectionID, String day, String startTime,
			String endTime, String building, String room,String cRN, int credit) {
		this.setSectionID(sectionID);
		this.setDay(day);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
		this.setBuilding(building);
		this.setRoom(room);
		this.setCRN(cRN);
		this.setCredit(credit);
	}
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getCRN() {
		return crn;
	}
	public void setCRN(String cRN) {
		crn = cRN;
	}
	@Override
	public String toString(){
		return crn+","+sectionID+","+day+","+startTime+","+endTime+","+priority+","+courseConflict;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getCourseConflict() {
		return courseConflict;
	}
	public void setCourseConflict(int courseConflict) {
		this.courseConflict = courseConflict;
	}
	public Boolean isLab(){
		if(this.sectionID.charAt(0)=='T' || this.sectionID.charAt(0)=='L') return true;
		return false;
	}
}
