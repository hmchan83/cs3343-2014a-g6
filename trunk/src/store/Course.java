package store;

import java.util.ArrayList;

/**
 * used to store the course info with a ArrayList of Section
 * @author Marcus
 *
 */

public class Course {
	
	private static int counter=1;

	private String courseID;
	private String courseName;
	private int priority;
	private ArrayList<Section> sec;
	private int minConflict=-1;
	private Boolean hasLab=false;
	private Boolean isCore=false;
	
	public Course(String courseID, String courseName){
		this.courseID=courseID;
		this.courseName=courseName;
		this.priority=counter++;
		this.sec = new ArrayList<>();
		
	}
	
	public Course() {}

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
	@Override
	public String toString(){
		return courseID+","+courseName+","+priority+","+minConflict;
	}
	public int SectionNum(){
		return sec.size();
	}
	public ArrayList<Section> getSec() {
		return sec;
	}
	public void setSec(ArrayList<Section> sec) {
		this.sec = sec;
	}
	/**
	 * find the smaller conflict number for all section in this course
	 * @return the smaller conflict number
	 */
	public int getMinConflict(){
		if(minConflict==-1){
			int min=-1;
			for(Section s : sec){
				if(min==-1) min = s.getCourseConflict();
				else
					if(s.getCourseConflict()<min)min=s.getCourseConflict();
			}
			minConflict = min;
			return min;
		}else{
			return minConflict;
		}
	}
	/**
	 * find the number of section that conflict number equals to the MIN. number of the course
	 * @return The number of section that conflict number equals to the MIN. number of the course
 	 */
	public int getSecNumMinConflict(){
		if(minConflict==-1){
			minConflict=getMinConflict();
		}
		int c=0;
		for(Section s : sec){
			if(s.getCourseConflict()==minConflict)c++;
		}
		return c;
	}

	public Boolean HasLab() {
		return hasLab;
	}

	public void setHasLab(Boolean hasLab) {
		this.hasLab = hasLab;
	}

	public Boolean IsCore() {
		return isCore;
	}

	public void setIsCore(Boolean isCore) {
		this.isCore = isCore;
	}
	
	public static int getCounter() {
		return counter;
	}

	public static void resetCounter() {
		Course.counter = 1;
	}
}
