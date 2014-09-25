import ioMoudle.*;

import java.util.ArrayList;

import Controller.MainController;
import Controller.ListHandler;
import store.Course;
import store.StoredItem;
/**
 * Main.java
 * @author Marcus
 *
 */
public class Main {
	public static void main(String[] args) {
		//DebugMessager.enable();//debug mode, may used to show debug message in runtime;
		int courseNums;
		IO io = new IO();
		DebugMessager.debug("IO start");
		ArrayList<Course> courselist = io.input(); //for testing just using simple input
		courseNums = courselist.size();
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		io.out("\nYour Input : \n");
		io.out(courselist);
		DebugMessager.debug("courseNums = "+courseNums);
		
		
		
		MainController MainController = new MainController();
		MainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		io.out("\nResult : \n");
		int totalpriority=0;
		for(StoredItem item : result){
			io.out(item.toString());
			totalpriority+=item.getSec().getPriority();
		}
		io.out("\nTotal Priority = "+totalpriority);
			
	}
}
