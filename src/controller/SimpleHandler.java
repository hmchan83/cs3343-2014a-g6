package controller;

import java.util.ArrayList;

import ioModule.DebugMessager;
import store.Course;
import store.Section;
import store.StoredItem;

public class SimpleHandler {
	static String title = "SimpleHandler : ";
	private OverlapDetector table = new OverlapDetector();
	private ArrayList<StoredItem> selected = new ArrayList<StoredItem>();
	
	public ArrayList<StoredItem> run(ArrayList<Course> list){
		boolean flag=false;	
		for(int i=0;i<list.size();i++){
			flag=false; // course is not added
			Course currCourse=list.get(i);
			int minConflict = currCourse.getMinConflict();
			int SecMinConflictNum = currCourse.getSecNumMinConflict();
			DebugMessager.debug(title+"Handling Course "+ i+" {"+currCourse.toString()+"}");
			DebugMessager.debug(title+"The min Conflict of this course = "+minConflict);
			DebugMessager.debug(title+"Sessions with min Conflict = "+SecMinConflictNum);		

			for(int j=0;j<currCourse.getSec().size();j++){
				Section currSec = currCourse.getSec().get(j);
				DebugMessager.debug(title+"Handling Section "+ i+" {"+currSec.toString()+"}");
				int conflictNums = ConflictDetector.run(list, i, currSec);
				DebugMessager.debug(title+"conflictNums = "+conflictNums);
				if(conflictNums > list.size()/2 || (minConflict==0 && conflictNums!=minConflict)){
					DebugMessager.debug(title+"Course Dropped");
					continue; //bad option
				}
				if(selectCourse(currSec)==true){
					StoredItem tempVal = new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),currSec);//Simple value
					selected.add(tempVal);
					DebugMessager.debug(title+"Select Course "+currCourse.getCourseID()+" "+currSec.getSectionID());
					flag=true; // course added
					break; // don't need to handle other section this time
				}
			}
			if(flag==true) continue; // skip to next course
		}
		return selected;
	}
	
	public boolean selectCourse(Section sec){		
		//TODO : add Conflict detector here
		return table.set(sec.getDay(),sec.getStartTime(),sec.getEndTime());
	}

}
