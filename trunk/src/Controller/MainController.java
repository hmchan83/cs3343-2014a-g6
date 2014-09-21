package Controller;

import java.util.ArrayList;

import store.Course;
import store.Section;
import store.StoredItem;
import store.TimeTable;
/**
 * Controller.MainController
 * The part that contain the main logic
 * @author Marcus
 *
 */

public class MainController {
	
	private TimeTable table = new TimeTable();
	private ArrayList<StoredItem> selected = new ArrayList<StoredItem>();
	
	public void run(ArrayList<Course> list, boolean debug){
		boolean flag=false;
		for(int i=0;i<list.size();i++){
			flag=false; // course is not added
			Course currCourse=list.get(i);
			for(int j=0;j<currCourse.getSec().size();j++){
				Section currSec = currCourse.getSec().get(j);
				if(selectCourse(currSec)==true){
					StoredItem tempVal = new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),currSec);//Simple value
					selected.add(tempVal);
					flag=true; // course added
					continue; // don't need to handle other section this time
				}
			}
			if(flag==true) continue; // skip to next course
		}
	}
	
	public void run(ArrayList<Course> list){
		this.run(list, false);//default the debug mode is not enable
	}
	
	public boolean selectCourse(Section sec){		
		//TODO : add Conflict detector here
		return table.set(sec.getDay(),sec.getStartTime(),sec.getEndTime());
	}
}
