package Controller;

import java.util.ArrayList;

import store.*;
/**
 * Class to find out how many course will be conflict while setting this section
 * 
 * @author Marcus
 *
 */
public class ConflictDetector {
	
	public int run(ArrayList<Course> list,int coursepos, Section sec){
		int conflictNums=0;
		TimeTable tt = new TimeTable();
		tt.set(sec.getDay(), sec.getStartTime(), sec.getEndTime());
		for(int i = coursepos; i<list.size();i++){
			Course tCourse = list.get(i);
			for(int j=0; j<tCourse.getSec().size();j++){
				Section tSection = tCourse.getSec().get(i);
				if(tt.check(tSection.getDay(), tSection.getStartTime(), tSection.getEndTime())==false){
					conflictNums++;
					break; // to the next Course
				}
			}
			
		}		
		return conflictNums;
	}

}
