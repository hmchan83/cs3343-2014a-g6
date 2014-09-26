import java.util.ArrayList;


public class Course {
	private String courseID;
	private String courseName;
	private String priority;
	private ArrayList<Section> sec = new ArrayList<>();


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

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}


	public void setCourseIDandCourseName(String id, String name) {
		this.courseID = id;
		this.courseName = name;
	}

	public void addSection(Section s) {
		sec.add(s);
	}

	public ArrayList getSec() {
		return sec;
	}
}
