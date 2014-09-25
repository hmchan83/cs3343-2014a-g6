package Controller;

import ioMoudle.DebugMessager;

import java.util.ArrayList;

import store.Course;
import store.Section;
import store.StoredItem;
/**
 * Controller.MainController
 * The part that contain the main logic
 * @author Marcus
 *
 */

public class MainController {
	
	private OverlapDetector table = new OverlapDetector();
	private ArrayList<StoredItem> selected = new ArrayList<StoredItem>();
	
	public void run(ArrayList<Course> list){
		boolean flag=false;
		DebugMessager.debug("MainController Start");
		
		
		for(int i=0;i<list.size();i++){
			flag=false; // course is not added
			Course currCourse=list.get(i);
			DebugMessager.debug("Handling Course "+ i+" {"+currCourse.toString()+"}");
			for(int j=0;j<currCourse.getSec().size();j++){
				Section currSec = currCourse.getSec().get(j);
				DebugMessager.debug("Handling Section "+ i+" {"+currSec.toString()+"}");
				int conflictNums = ConflictDetector.run(list, i, currSec);
				DebugMessager.debug("conflictNums = "+conflictNums);
				if(conflictNums > list.size()/2){
					DebugMessager.debug("Course Dropped");
					continue; //bad option
				}
				if(selectCourse(currSec)==true){
					StoredItem tempVal = new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),currSec);//Simple value
					selected.add(tempVal);
					DebugMessager.debug("Select Course "+currCourse.getCourseID()+" "+currSec.getSectionID());
					flag=true; // course added
					break; // don't need to handle other section this time
				}
			}
			if(flag==true) continue; // skip to next course
		}
	}
	
	public boolean selectCourse(Section sec){		
		//TODO : add Conflict detector here
		return table.set(sec.getDay(),sec.getStartTime(),sec.getEndTime());
	}
	
	public ArrayList<StoredItem> result(){
		return this.selected;
	}
}
