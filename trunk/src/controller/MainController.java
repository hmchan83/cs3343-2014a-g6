package controller;

import ioModule.DebugMessager;

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
	private OverlapDetector table = new OverlapDetector();
	private ArrayList<StoredItem> selected = new ArrayList<StoredItem>();
	private static int reqiureNums = 0;
	private static ArrayList<StoredItem> baseResult= new ArrayList<StoredItem>();
	
	
	public void run(ArrayList<Course> list){
		DebugMessager.debug(title+"MainController Start");
		DebugMessager.debug(title+"Using ComplexHandler");
		ComplexHandler ComplexHandler=new ComplexHandler();
		selected = ComplexHandler.run(list);
		if(baseResult.isEmpty()==false){
			DebugMessager.debug(title+"BaseResult contains something, BaseResult = "+baseResult.toString());
			baseResult.addAll(selected);
			selected=baseResult;
			DebugMessager.debug(title+"Merge selected & BaseResult, result = "+selected.toString());
		}
		DebugMessager.debug(title+"selected = "+selected.toString());
		DebugMessager.debug(title+"MainController End");
	}
	
	public boolean selectCourse(Section sec){		
		//TODO : add Conflict detector here
		return table.set(sec.getDay(),sec.getStartTime(),sec.getEndTime());
	}
	
	public ArrayList<StoredItem> result(){
		return this.selected;
	}
	public static int getReqiureNums() {
		return reqiureNums;
	}

	public static void setReqiureNums(int areqiureNums) {
		reqiureNums = areqiureNums;
	}

	public static ArrayList<StoredItem> getBaseResult() {
		return baseResult;
	}

	public static void setBaseResult(ArrayList<StoredItem> baseResult) {
		MainController.baseResult = baseResult;
	}
	public static void addBaseResult(StoredItem item) {
		MainController.baseResult.add(item);
	}
}
