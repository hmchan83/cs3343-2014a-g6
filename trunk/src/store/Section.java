package store;

public class Section {
	private String sectionID;
	private String day;
	private String startTime;
	private String endTime;
	private String location;
	private int CRN;
	private int credit;
	

	
	public Section(String sectionID, String day, String startTime,
			String endTime, String location, int cRN, int credit) {
		this.sectionID = sectionID;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		CRN = cRN;
		this.credit = credit;
	}
	public Section(String sectionID, String day, String startTime,
			String endTime, String location) {
		this.sectionID = sectionID;
		this.day = day;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCRN() {
		return CRN;
	}
	public void setCRN(int cRN) {
		CRN = cRN;
	}
	@Override
	public String toString(){
		return CRN+","+sectionID+","+day+","+startTime+","+endTime;
	}
	
	

}
