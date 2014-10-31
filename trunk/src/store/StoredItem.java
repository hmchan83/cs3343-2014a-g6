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
	/**
	 * to generate a simple object for output
	 * @param c Course
	 * @param s Section
	 */
	public StoredItem(Course c, Section s){
		this.setCourseID(c.getCourseID());
		this.setCourseName(c.getCourseName());
		this.setSec(s);
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
		this.setCourseID(courseID);
		this.setCourseName(courseName);
		this.setSec(sec);
	}
	@Override
	public String toString(){		
		return sec.getCRN()+" : "+this.getCourseID() + " - "+this.getCourseName()+" ("+this.getSec().getSectionID()+")";		
	}
	
}
