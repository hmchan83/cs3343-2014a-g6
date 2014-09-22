import ioMoudle.*;

import java.util.ArrayList;

import Controller.MainController;
import store.Course;
import store.StoredItem;
/**
 * Main.java
 * @author Marcus
 *
 */
public class Main {
	public static void main(String[] args) {
		DebugMessager.enable();//debug mode, may used to show debug message in runtime;
		int courseNums;
		IO io = new IO();
		DebugMessager.debug("IO start");
		ArrayList<Course> courselist = io.input(); //for testing just using simple input
		courseNums = courselist.size();
		io.out("\nYour Input : \n");
		io.out(courselist);
		DebugMessager.debug("courseNums = "+courseNums);
		MainController MainController = new MainController();
		MainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		io.out("\nResult : \n");
		for(StoredItem item : result){
			io.out(item.toString());
		}
			
	}
}
