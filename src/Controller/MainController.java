package controller;

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
	static String title = "MainController : ";
	static Boolean SimpleHandler;
	private OverlapDetector table = new OverlapDetector();
	private ArrayList<StoredItem> selected = new ArrayList<StoredItem>();
	
	public void run(ArrayList<Course> list){
		DebugMessager.debug(title+"MainController Start");
		
		if(SimpleHandler == true){ // No priority problem
			DebugMessager.debug(title+"Using SimpleHandler");
			SimpleHandler SimpleHandler = new SimpleHandler();
			selected = SimpleHandler.run(list);
		}else{
			DebugMessager.debug(title+"Using ComplexHandler");
			//ComplexHandler ComplexHandler=new ComplexHandler();
			//ComplexHandler.run(list);
			//SimpleHandler SimpleHandler = new SimpleHandler();
			//selected = SimpleHandler.run(list);
		}
	}
	
	public boolean selectCourse(Section sec){		
		//TODO : add Conflict detector here
		return table.set(sec.getDay(),sec.getStartTime(),sec.getEndTime());
	}
	
	public ArrayList<StoredItem> result(){
		return this.selected;
	}

	public static Boolean getSimpleHandler() {
		return SimpleHandler;
	}

	public static void setSimpleHandler(Boolean simpleHandler) {
		SimpleHandler = simpleHandler;
	}
}
