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
		//DebugMessager.disable();
		Course currCourse;
		Section currSection;
		StoredList stList,newList;
		StoredItem tempVal;
		Boolean labSelected = false, lecSelected = false;
		// Step 1. For Course 0, find the section with the minimum conflict number and put it in to result list
		currCourse = list.get(0);
		if(currCourse.HasLab() == true){
			labSelected = false;
			lecSelected = false;
		}
		DebugMessager.debug(title+"Handling Course "+ 0+" {"+currCourse.toString()+"}");
		DebugMessager.debug(title+"The min Conflict of this course = "+currCourse.getMinConflict());
		DebugMessager.debug(title+"Sessions with min Conflict = "+currCourse.getSecNumMinConflict());
		DebugMessager.debug(title+"Start putting Sessions with min Conflict in to StoredList");	
		for(Section sec : currCourse.getSec()){
			table.reset();
			DebugMessager.debug(title+"Handling Section {"+sec.toString()+"}");
//			if(sec.getCourseConflict() == currCourse.getMinConflict()){
				DebugMessager.debug(title+"Section "+sec.getSectionID()+" is the less conflict session.");
				table.set(sec.getDay(), sec.getStartTime(), sec.getEndTime());
				tempVal = new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),sec);//Simple value
				stList = new StoredList();
				stList.addCredits(sec.getCredit());
				stList.add(tempVal);
				stList.setTable(table.getTable());
				tempList.add(stList);
				DebugMessager.debug(title+"Section "+sec.getSectionID()+" added to stored list");
				DebugMessager.debug(title+"StoredList = "+tempList.toString());
	//		}else{
		//		DebugMessager.debug(title+"Section "+sec.getSectionID()+" is not the less conflict session.");
			//}
		}
		
		DebugMessager.debug(title+"tempList = "+tempList.toString());
		//Step 2. For each list in tempList, select another course & section		
		DebugMessager.debug(title+"Step 2 Start.");
		int listpos=0;
		int maxCourseNums=0;
		while(true){
			try{				
				stList = tempList.get(listpos);
				DebugMessager.debug(title+"listpos = "+listpos+", stList = "+stList.toString());
				DebugMessager.debug(title+"stList.getTable = "+stList.printTable());
			}catch(IndexOutOfBoundsException e){
				break; //end of list
			}

			//for(int i=stList.getHandledCourse()+1;i<list.size();i++){
				int i=stList.getHandledCourse()+1;
				if(i>=list.size()) break; // end of course
				currCourse = list.get(i);
				DebugMessager.debug(title+"Handling Course "+i+"{"+currCourse.toString()+"}");
				for(int j=0;j<currCourse.getSec().size();j++){
					currSection = currCourse.getSec().get(j);
					DebugMessager.debug(title+"Handling Section "+i+"{"+currSection.toString()+"}");
					if(currSection.getCourseConflict() == currCourse.getMinConflict()){
						newList = copyList(stList);
						table.setTable(copyTable(stList.getTable()));
						if(selectCourse(currSection)==true){
							DebugMessager.debug(title+"Select Section "+i+"{"+currSection.toString()+"}");
							tempVal = new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),currSection);//Simple value
							newList.add(tempVal);
							newList.addCredits(currSection.getCredit());
							newList.setTable(copyTable(table.getTable()));
							if(newList.getItemNums()>maxCourseNums)maxCourseNums=newList.getItemNums();
						}
						newList.setHandledCourse(i);
						DebugMessager.debug(title+"newList = "+newList.toString());
						DebugMessager.debug(title+"newList.getTable = "+newList.printTable());
						tempList.add(newList);
					}
				}
			//}
			DebugMessager.debug(title+"listpos++ \n\n");
			listpos++;
			DebugMessager.debug(title+"tempList = "+tempList.toString()+"\n\n");
		}
		
		
		
		//Step 3. Find the Highest priority list
		DebugMessager.debug(title+"Step 3 Start. maxCourseNums = "+maxCourseNums);		
		int maxPriority = 0;
		StoredList result = new StoredList();
		for(int k=tempList.size()-1;k>=0;k--){	
			stList = tempList.get(k);
			if(stList.getItemNums()-2==maxCourseNums)break;
			int tempPriority = stList.getPriorityNums();
			DebugMessager.debug(title+"tempList["+k+"] = "+stList.toString() +", Priority = "+tempPriority);			
			DebugMessager.debug(title+"maxPriority = "+maxPriority+", result = "+result.toString());	
			if(tempPriority>maxPriority){				
				maxPriority = tempPriority;
				result = stList;
				DebugMessager.debug(title+"Larger Found, New.maxPriority = "+maxPriority+", New.result = "+result.toString());
			}
		}
		//DebugMessager.enable();
		DebugMessager.debug(title+"result = "+result);
		if(result.getTotalCredits()<MainController.getReqiureNums()){
			result = new StoredList(); // No result fix the conditions.
		}
		return result.getItems();
	}
	public boolean selectCourse(Section sec){		
		return table.set(sec.getDay(),sec.getStartTime(),sec.getEndTime());
	}
	
	@SuppressWarnings("unchecked")
	public StoredList copyList(StoredList listA){
		StoredList listB = new StoredList();
		listB.setTable(copyTable(listA.getTable()));
		Object clone = listA.getItems().clone();
		listB.setItems((ArrayList<StoredItem>) clone);
		listB.setTotalCredits(listA.getTotalCredits());
		return listB;
	}
	public Boolean[][] copyTable(Boolean[][] table){
		Boolean[][] newTable = new Boolean[7][24];
		for(int i =0;i<7;i++){
			for(int j=0;j<24;j++){
				if(table[i][j]==true) newTable[i][j]=true;
				else newTable[i][j]=false;
			}
		}
		return newTable;
	}
	public String printTable(){
		String str = "";
		for(int i=0;i<7;i++){
			if(i>0)str+=",";
			str += "\n\t\t\tday="+(i)+" : {";
			for(int j=0;j<24;j++){
				if(j>0)str+=",";
				str +=table.getTable()[i][j];
			}
			str += "}";
		}
		return str;
	}
}
