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
//TODO : change all Boolean[][] to TimeTable, I will do it.
public class ComplexHandler {
	int maxPriority = 0;
	StoredList result = new StoredList();
	static String title = "ComplexHandler : ";
	private OverlapDetector table;
	private ArrayList<StoredList> possibleResult = new ArrayList<StoredList>();
	
	public ArrayList<StoredItem> run(ArrayList<Course> list){
		//DebugMessager.disable();
		Course currCourse;
		Section currSection;
		StoredList stList,newList;
		StoredItem tempVal;
		Boolean labSelected = false, lecSelected = false;		
		// Step 1. For Course 0, find the section with the minimum conflict number and put it in to result list
		int count = 0;
		do{
			currCourse = list.get(count);
			count++;
		}while(currCourse.IsCore()==true);
		//if(currCourse.HasLab() == true){
			labSelected = false;
			lecSelected = false;
		//}
		DebugMessager.debug(title+"Handling Course "+ 0+" {"+currCourse.toString()+"}");
		DebugMessager.debug(title+"The min Conflict of this course = "+currCourse.getMinConflict());
		DebugMessager.debug(title+"Sessions with min Conflict = "+currCourse.getSecNumMinConflict());
		DebugMessager.debug(title+"Start putting Sessions with min Conflict in to StoredList");
		Section LecSection,LabSection;
		int  LecStepper=0;
		do{
			table=new OverlapDetector();
			stList = new StoredList();
			int LabStepper=0;
			LecSection = this.findlecture(currCourse, LecStepper++, table.getTable());
			if(LecSection==null)break;
			if(table.set(LecSection.getDay(), LecSection.getStartTime(), LecSection.getEndTime())){
				lecSelected=true;
				/* TODO: put the following code into a new method : createNewPossibleResult(Course c, Section s, table)*/
					tempVal = new StoredItem(currCourse,LecSection);//Simple value
					stList = new StoredList();
					stList.addCredits(LecSection.getCredit());
					stList.add(tempVal);
					stList.setTable(table.getTable());
				/* End */
				if(currCourse.HasLab()){
					do{
						OverlapDetector table2 = new OverlapDetector(stList.getTable());
						LabSection = this.findLab(currCourse, LabStepper++, table2.getTable());
						if(LabSection==null)break;
						if(table2.set(LabSection.getDay(), LabSection.getStartTime(), LabSection.getEndTime())){
							labSelected=true;
							tempVal = new StoredItem(currCourse,LabSection);//Simple value
							stList.addCredits(LabSection.getCredit());
							stList.add(tempVal);
							stList.setTable(table2.getTable());
						}
						if((currCourse.HasLab() && lecSelected==true && labSelected==true)){
							DebugMessager.debug(title+"Add to tempList");
							possibleResult.add(stList);
							if(stList.getPriorityNums()>maxPriority){
								maxPriority=stList.getPriorityNums();
								result=copyList(stList);
							}
						}
					}while(LabSection!=null);// find until there are no lab
				}else{
					DebugMessager.debug(title+"Add to tempList");
					/* TODO: put the following code into a new method : addPossibleResult(StoredList stList)*/
					possibleResult.add(stList);
					if(stList.getPriorityNums()>maxPriority){
						maxPriority=stList.getPriorityNums();
						result=copyList(stList);
					}
					/* End */
				}
			}
			//LecStepper++;
		}while(LecSection!=null);//find until there are no lecture
		/*
		for(Section sec : currCourse.getSec()){
			table.reset();
			DebugMessager.debug(title+"Handling Section {"+sec.toString()+"}");
			//if(sec.getCourseConflict() == currCourse.getMinConflict()){
				DebugMessager.debug(title+"Section "+sec.getSectionID()+" is the less conflict session.");
				table.set(sec.getDay(), sec.getStartTime(), sec.getEndTime());
				tempVal = new StoredItem(currCourse,sec);//Simple value
				stList = new StoredList();
				stList.addCredits(sec.getCredit());
				stList.add(tempVal);
				stList.setTable(table.getTable());
				tempList.add(stList);
				DebugMessager.debug(title+"Section "+sec.getSectionID()+" added to stored list");
				DebugMessager.debug(title+"StoredList = "+tempList.toString());
			//}else{
			//	DebugMessager.debug(title+"Section "+sec.getSectionID()+" is not the less conflict session.");
			//}
		}*/
		
		DebugMessager.debug(title+"tempList = "+possibleResult.toString());
		//Step 2. For each list in tempList, select another course & section		
		DebugMessager.debug(title+"Step 2 Start.");
		int listpos=0;
		int maxCourseNums=0;
		while(true){
			try{				
				stList = possibleResult.get(listpos);
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
						possibleResult.add(newList);
						if(newList.getPriorityNums()>maxPriority){
							maxPriority=newList.getPriorityNums();
							result=copyList(newList);
						}
					}
				}
			//}
			DebugMessager.debug(title+"listpos++ \n\n");
			listpos++;
			DebugMessager.debug(title+"tempList = "+possibleResult.toString()+"\n\n");
		}

		DebugMessager.debug(title+"result = "+result);
		if(result.getTotalCredits()<MainController.getReqiureNums()){
			result = new StoredList(); // No result fix the conditions.
		}
		return result.getItems();
	}
	
	public Section findlecture(Course c, int i,Boolean[][] table){
		DebugMessager.debug(title+"findlecture, i = "+i);
		return find(c,i,table,false);
	}
	public Section findLab(Course c,int i,Boolean[][] table){
		DebugMessager.debug(title+"findlab, i = "+i);
		return find(c,i,table,true);
	}
	
	public Section find(Course c,int i,Boolean[][] table,Boolean isLab){
		OverlapDetector Old = new OverlapDetector(table.clone());
		int n=0;
		if(i>c.getSec().size()) return null;
		for(int k=0;k<c.getSec().size();k++){
			Section currSection = c.getSec().get(k); 
			if( currSection.isLab().equals(isLab)){
				if(Old.check(currSection.getDay(), currSection.getStartTime(), currSection.getEndTime())){
					if(n==i) return c.getSec().get(k);
					else n++;
				}
			}
		}
		return null;
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
	public StoredList createPossibleResult(Course c, Section s){
		StoredItem tempVal = new StoredItem(c,s);//Simple value
		StoredList stList = new StoredList();
		stList.addCredits(s.getCredit());
		stList.add(tempVal);
		stList.setTable(table.getTable());
		return stList;
	}
	public void addPossibleResult(StoredList stList){
		possibleResult.add(stList);
		if(stList.getPriorityNums()>maxPriority){
			maxPriority=stList.getPriorityNums();
			result=copyList(stList);
		}
	}
}
