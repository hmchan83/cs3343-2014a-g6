package Controller;

import ioMoudle.DebugMessager;

import java.util.ArrayList;

import store.Course;
import store.Section;

public class PriorityHandler {
	
	public PriorityHandler(){
		
	}
	
	public void listformat(ArrayList<Course> list){
		DebugMessager.debug("\tPriorityHandler Start setting priority");
		int maxSecNum=0;
		for(Course c : list){ // get the largest Section nums
			if(maxSecNum<c.SectionNum()){
				maxSecNum=c.SectionNum(); 
			}
		}
		DebugMessager.debug("Largest Section Num = "+maxSecNum);
		int places = (int) (Math.floor(Math.log10(maxSecNum))+1);
		DebugMessager.debug("Places need = "+places);
		for(int i=0;i<list.size();i++){ // init the Priority table
			Course c = list.get(i);
			int tempPriority=c.getPriority()*((int)Math.pow(10, places));
			DebugMessager.debug("PriorityHandler handling Course "+c.getCourseID());
			ArrayList<Section> seclist=c.getSec();
			for(int j=0;j<seclist.size();j++){
				Section s = seclist.get(j);
				DebugMessager.debug("\tPriorityHandler handling Section "+s.getSectionID());
				s.setPriority(tempPriority++);
				s.setCourseConflict(ConflictDetector.run(list, i,s));
				DebugMessager.debug("\tPriorityHandler Section "+s.getSectionID()+", priority = "+tempPriority);
			}
		}
		DebugMessager.debug("\tPriorityHandler End.");
	}

}
