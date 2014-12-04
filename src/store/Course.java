package store;

import java.util.ArrayList;

/**
 * used to store the course info with a ArrayList of Section
 * @author Marcus
 *
 */

public class Course {
	
	/**
	 * count the course number, use to set the priority
	 */
	private static int counter=1;

	/**
	 * Course ID, e.g CS3343
	 */
	private String courseID;
	/**
	 * Course Name
	 */
	private String courseName;
	/**
	 * Priority, use to determine the best result
	 */
	private int priority;
	/**
	 * the section of this course
	 */
	private ArrayList<Section> sec = new ArrayList<>();
	/**
	 * the conflict number, details please view the disn document
	 */
	private int minConflict=-1;
	/**
	 * boolean to specify does this course contain Lab/Tutorial Section
	 */
	private Boolean hasLab=false;
	/**
	 * boolean to specify that is this the Core
	 */
	private Boolean isCore=false;
	
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
