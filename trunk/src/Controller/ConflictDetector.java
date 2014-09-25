package Controller;

import java.util.ArrayList;

import store.*;
/**
 * Class to find out how many course will be conflict while setting this section
 * @author Marcus
 *
 */
public class ConflictDetector {
	/**
	 * find the number of course that a section conflict with
	 * @param list the course list
	 * @param coursepos the position from the ArrayList of the course contain this section
	 * @param sec the Section object that want to find the number of conflict
	 * @return number of conflict
	 */
	public static int run(ArrayList<Course> list,int coursepos, Section sec){
		int conflictNums=0;
		OverlapDetector tt = new OverlapDetector();
		tt.set(sec.getDay(), sec.getStartTime(), sec.getEndTime());
		for(int i = coursepos+1; i<list.size();i++){
			Course tCourse = list.get(i);
			for(int j=0; j<tCourse.getSec().size();j++){
				Section tSection = tCourse.getSec().get(j);
				if(tt.check(tSection.getDay(), tSection.getStartTime(), tSection.getEndTime())==false){
					conflictNums++;
					break; // to the next Course
				}
			}
			
		}		
		return conflictNums;
	}

}
