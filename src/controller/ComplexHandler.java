package controller;

import ioModule.DebugMessager;

import java.util.ArrayList;

import store.Course;
import store.StoredList;
import store.StoredItem;
import store.Section;
import store.TimeTable;
/**
 * Handler for course list that require priority handling
 * @author Marcus
 *
 */
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
		// Step 1. For Course 0, find the section with the minimum conflict number and put it in to result list
		int count = 0;
		do{
			currCourse = list.get(count);
			count++;
		}while(currCourse.IsCore()==true);

		DebugMessager.debug(title+"Handling Course "+ 0+" {"+currCourse.toString()+"}");
		DebugMessager.debug(title+"The min Conflict of this course = "+currCourse.getMinConflict());
		DebugMessager.debug(title+"Sessions with min Conflict = "+currCourse.getSecNumMinConflict());
		DebugMessager.debug(title+"Start putting Sessions with min Conflict in to StoredList");
		HandleCourse(currCourse,new StoredList());
		
		DebugMessager.debug(title+"tempList = "+possibleResult.toString());
		//Step 2. For each list in tempList, select another course & section		
		DebugMessager.debug(title+"Step 2 Start.");
		int listpos=0;
		int maxCourseNums=0;
		Boolean lecSelected = false;
		StoredList newList2 = null;
		while(true){
			int LecStepper = 0;
			try{				
				stList = possibleResult.get(listpos);
				DebugMessager.debug(title+"listpos = "+listpos+", stList = "+stList.toString());
				DebugMessager.debug(title+"stList.getTable = "+stList.printTable());
				DebugMessager.debug(title+"stList.HandledCourse = "+stList.getHandledCourse());
			}catch(IndexOutOfBoundsException e){
				break; //end of list
			}

            int i=stList.getHandledCourse()+1;
            if(i>=list.size()){
            	DebugMessager.debug(title+"END OF COURSE");
            	break; // end of course
            }
            currCourse = list.get(i);
            DebugMessager.debug(title+"Handling Course "+i+"{"+currCourse.toString()+"}");
            
            while(findLecture(currCourse,LecStepper,stList.getTable().clone())!=null){
            	currSection = findLecture(currCourse,LecStepper++,stList.getTable().clone());
            	DebugMessager.debug(title+"Handling Lec Section "+i+"{"+currSection.toString()+"}");
                if(currSection.getCourseConflict() == currCourse.getMinConflict()){
                        newList = copyList(stList);
                        table.setTable(stList.getTable().clone());
                        if(selectCourse(currSection)==true){
                        		lecSelected = true;
                        		Boolean labSelected = false;
                        		int LabStepper=0;
                                DebugMessager.debug(title+"Select Section "+i+"{"+currSection.toString()+"}");
                                newList.add(new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),currSection),table.getTable().clone());
                                if(newList.getItemNums()>maxCourseNums)maxCourseNums=newList.getItemNums();
                                if(currCourse.HasLab()){
                                	while(findLab(currCourse,LabStepper,newList.getTable().clone())!=null){
                                		Section currSection2 = findLab(currCourse,LabStepper++,newList.getTable().clone());
                                		DebugMessager.debug(title+"Handling Lab Section "+i+"{"+currSection2.toString()+"}");
                                		newList2 = copyList(newList);
                                        table.setTable(newList.getTable().clone());
                                        if(selectCourse(currSection2)==true){
                                        	newList2.add(new StoredItem(currCourse.getCourseID(),currCourse.getCourseName(),currSection2),table.getTable().clone());
                                        	labSelected=true;
                                        }
                                        if(labSelected==true && lecSelected == true){
                                            addPossibleResult(newList2,i);
                                    	}
                                	}                                	
                                }else{
                                    addPossibleResult(newList,i);
                                }
                        }else{
	                        addPossibleResult(newList,i);
                        }
                }
            }
			
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
	/**
	 * 
	 * @param c Course
	 * @param i Stepper
	 * @param table TimeTable
	 * @return a add-able lecture
	 */
	public Section findLecture(Course c, int i,TimeTable table){
		DebugMessager.debug(title+"findlecture, i = "+i);
		return find(c,i,table,false);
	}
	/**
	 * 
	 * @param c Course
	 * @param i Stepper
	 * @param table TimeTable
	 * @return a add-able lab
	 */
	public Section findLab(Course c,int i,TimeTable table){
		DebugMessager.debug(title+"findlab, i = "+i);
		return find(c,i,table,true);
	}
	
	public Section find(Course c,int i,TimeTable table,Boolean isLab){
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
		listB.setTable(listA.getTable().clone());
		Object clone = listA.getItems().clone();
		listB.setItems((ArrayList<StoredItem>) clone);
		listB.setTotalCredits(listA.getTotalCredits());
		return listB;
	}
	public StoredList createPossibleResult(Course c, Section s,TimeTable table){
		StoredList stList = new StoredList();
		stList.add(new StoredItem(c,s),table);
		return stList;
	}
	public void addPossibleResult(StoredList stList){
		DebugMessager.debug(title+"newList = "+stList.toString());
        DebugMessager.debug(title+"newList.getTable = "+stList.printTable());
		possibleResult.add(stList);
		if(stList.getPriorityNums()>maxPriority){
			maxPriority=stList.getPriorityNums();
			result=copyList(stList);
		}
	}
	public void addPossibleResult(StoredList stList, int i){
		stList.setHandledCourse(i);
		addPossibleResult(stList);
	}
	public void HandleCourse(Course c,StoredList st){
		Section LecSection,LabSection;
		int  LecStepper=0;
		StoredList stList;
		Boolean lecSelected=false;
		Boolean labSelected=false;
		while(true){
			table=new OverlapDetector();
			stList = new StoredList();
			int LabStepper=0;
			LecSection = this.findLecture(c, LecStepper++, table.getTable());
			if(LecSection==null)break;// find until there are no lec
			if(table.set(LecSection.getDay(), LecSection.getStartTime(), LecSection.getEndTime())){
				lecSelected=true;
					stList = createPossibleResult(c,LecSection,table.getTable());
				if(c.HasLab()){
					while(true){
						StoredList newList = copyList(stList);
						OverlapDetector table2 = new OverlapDetector(newList.getTable());
						LabSection = this.findLab(c, LabStepper++, table2.getTable());
						if(LabSection==null)break;// find until there are no lab
						if(table2.set(LabSection.getDay(), LabSection.getStartTime(), LabSection.getEndTime())){
							labSelected=true;
							newList.add(new StoredItem(c,LabSection),table2.getTable());
						}
						if((c.HasLab() && lecSelected==true && labSelected==true)){
							DebugMessager.debug(title+"Add to tempList");
							possibleResult.add(newList);
							if(newList.getPriorityNums()>maxPriority){
								maxPriority=newList.getPriorityNums();
								result=copyList(newList);
							}
						}
					}
				}else{
					DebugMessager.debug(title+"Add to tempList");
					addPossibleResult(stList);
				}
			}
		}
	}
}
