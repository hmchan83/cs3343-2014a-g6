package store;

/**
 * simplified data format of courses used in storing the course and section selected
 * @author Marcus
 *
 */

public class StoredItem {
	
	private String courseID;
	private String courseName;
	private Section sec;
	
	public StoredItem(Course c, Section s){
		this.courseID=c.getCourseID();
		this.courseName=c.getCourseName();
		this.sec=s;
	}
	public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Section getSec() {
		return sec;
	}
	public void setSec(Section sec) {
		this.sec = sec;
	}
	public StoredItem(String courseID, String courseName, Section sec) {
		super();
		this.courseID = courseID;
		this.courseName = courseName;
		this.sec = sec;
	}
	@Override
	public String toString(){		
		return sec.getCRN()+" : "+courseID + " - "+courseName+" ("+sec.getSectionID()+")";		
	}
	
}
