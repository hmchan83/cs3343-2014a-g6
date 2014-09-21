package store;

import java.util.ArrayList;

/**
 * store.Course
 * used to store the course info with a ArrayList of Section
 * @author Marcus
 *
 */

public class Course {
	
	private String courseID;
	private String courseName;
	private int priority;
	private ArrayList<Section> sec;
	public ArrayList<Section> getSec() {
		return sec;
	}

	public void setSec(ArrayList<Section> sec) {
		this.sec = sec;
	}

	static int c=1;
	
	public Course(String courseID, String courseName){
		this.courseID=courseID;
		this.courseName=courseName;
		this.priority=c++;
		this.sec = new ArrayList<>();
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

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public void addSec(Section sec){
		this.sec.add(sec);
	}

}
