package controller;

import ioMoudle.DebugMessager;

import java.util.ArrayList;

import store.Course;
import store.StoredList;
import store.StoredItem;
import store.Section;
/**
 * Handler for course list that require priority handling
 * @author Marcus
 *
 */
public class ComplexHandler {
	static String title = "ComplexHandler : ";
	private OverlapDetector table = new OverlapDetector();
	private ArrayList<StoredList> tempList = new ArrayList<StoredList>();
	
	public void run(ArrayList<Course> list){
		// Step 1
		Course currCourse = list.get(0);
		DebugMessager.debug(title+"Handling Course "+ 0+" {"+currCourse.toString()+"}");
		DebugMessager.debug(title+"The min Conflict of this course = "+currCourse.getMinConflict());
		DebugMessager.debug(title+"Sessions with min Conflict = "+currCourse.getSecNumMinConflict());	
		if(currCourse.getSecNumMinConflict()>1){//require priority
			DebugMessager.debug(title+"Sessions with min Conflict > 1, require priority");
			
		}else{
			DebugMessager.debug(title+"Sessions with min Conflict = 1, pick the lowest conflict session");
			for(Section sec : currCourse.getSec()){
				DebugMessager.debug(title+"Handling Section {"+sec.toString()+"}");
				if(sec.getCourseConflict() == currCourse.getMinConflict()){
					DebugMessager.debug(title+"Section "+sec.getSectionID()+" is the less conflict session.");
					StoredItem tempVal = new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),sec);//Simple value
					StoredList storeList = new StoredList();
					storeList.add(tempVal);
					tempList.add(storeList);
					DebugMessager.debug(title+"Section "+sec.getSectionID()+" added to stored list");
					DebugMessager.debug(title+"StoredList = "+tempList.toString());
				}else{
					DebugMessager.debug(title+"Section "+sec.getSectionID()+" is not the less conflict session.");
				}
			}
		}
		
	}
	public boolean selectCourse(Section sec){		
		//TODO : add Conflict detector here
		return table.set(sec.getDay(),sec.getStartTime(),sec.getEndTime());
	}
}
