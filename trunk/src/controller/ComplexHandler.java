package controller;

import ioModule.DebugMessager;

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
	
	public ArrayList<StoredItem> run(ArrayList<Course> list){
		Course currCourse;
		Section currSection;
		StoredList stList,newList;
		StoredItem tempVal;
		// Step 1. For Course 0, find the section with the minimum conflict number and put it in to result list
		currCourse = list.get(0);
		DebugMessager.debug(title+"Handling Course "+ 0+" {"+currCourse.toString()+"}");
		DebugMessager.debug(title+"The min Conflict of this course = "+currCourse.getMinConflict());
		DebugMessager.debug(title+"Sessions with min Conflict = "+currCourse.getSecNumMinConflict());
		DebugMessager.debug(title+"Start putting Sessions with min Conflict in to StoredList");	
		for(Section sec : currCourse.getSec()){
			table.reset();
			DebugMessager.debug(title+"Handling Section {"+sec.toString()+"}");
			if(sec.getCourseConflict() == currCourse.getMinConflict()){
				DebugMessager.debug(title+"Section "+sec.getSectionID()+" is the less conflict session.");
				table.set(sec.getDay(), sec.getStartTime(), sec.getEndTime());
				tempVal = new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),sec);//Simple value
				stList = new StoredList();
				stList.add(tempVal);
				stList.setTable(table.getTable());
				tempList.add(stList);
				DebugMessager.debug(title+"Section "+sec.getSectionID()+" added to stored list");
				DebugMessager.debug(title+"StoredList = "+tempList.toString());
			}else{
				DebugMessager.debug(title+"Section "+sec.getSectionID()+" is not the less conflict session.");
			}
		}
		
		DebugMessager.debug(title+"tempList = "+tempList.toString());
		//Step 2. For each list in tempList, select another course & section
		DebugMessager.debug(title+"Step 2 Start.");
		for(int i=1;i<list.size();i++){
			currCourse = list.get(i);
			//int minConflictSec = currCourse.getSecNumMinConflict();
			for(int k=0;k<tempList.size();k++){
				stList = tempList.get(k);
				table.setTable(stList.getTable());
				for(int j=0;j<currCourse.getSec().size();j++){
					currSection = currCourse.getSec().get(j);
					if(currSection.getCourseConflict() == currCourse.getMinConflict()){//Select session with less conflict
						if(selectCourse(currSection)==true){
							newList = copyList(stList);
							tempVal = new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),currSection);//Simple value
							newList.add(tempVal);
							tempList.add(newList);
						}
					}
				}
				//tempList.remove(k); //may lowdown performance?
			}
		}
		DebugMessager.debug(title+"tempList = "+tempList.toString());
		
		//Step 3. Find the Highest priority list
		DebugMessager.debug(title+"Step 3 Start.");		
		int maxPriority = 0;
		StoredList result = new StoredList();
		for(int k=0;k<tempList.size();k++){			
			stList = tempList.get(k);
			int tempPriority = stList.getPriorityNums();
			DebugMessager.debug(title+"tempList["+k+"] = "+stList.toString() +", Priority = "+tempPriority);			
			DebugMessager.debug(title+"maxPriority = "+maxPriority+", result = "+result.toString());	
			if(tempPriority>maxPriority){				
				maxPriority = tempPriority;
				result = stList;
				DebugMessager.debug(title+"Larger Found, New.maxPriority = "+maxPriority+", New.result = "+result.toString());
			}
		}
		DebugMessager.debug(title+"result = "+result);
		return result.getItems();
	}
	public boolean selectCourse(Section sec){		
		return table.set(sec.getDay(),sec.getStartTime(),sec.getEndTime());
	}
	public StoredList copyList(StoredList listA){
		StoredList listB = new StoredList();
		listB.setTable(listA.getTable().clone());
		listB.setItems((ArrayList<StoredItem>) listA.getItems().clone());
		return listB;
	}
}
