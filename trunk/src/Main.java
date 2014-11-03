import ioModule.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import controller.MainController;
import store.Course;
import store.StoredItem;
/**
 * Main.java
 * @author Marcus
 *
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		final Boolean inputMethod = true; // true for simple input, false for XML
		DebugMessager.enable();//debug mode, may used to show debug message in runtime;
		//Course.resetCounter();
		IO io = new IO();
		DebugMessager.debug("IO start");
		
		ArrayList<Course> courselist;
		if(inputMethod == true)
			courselist = io.input();
		else
			courselist = io.inputXML(); //for testing just using simple input
	
		MainController MainController = new MainController();
		MainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		io.out("\nResult : \n");
		int totalpriority=0;
		if(result.isEmpty()==true){
			System.out.println("No such result.");
		}else{
			for(StoredItem item : result){
				io.out(item.toString());
				totalpriority+=item.getSec().getPriority();
			}
		}
		io.out("\nTotal Priority = "+totalpriority);			
	}
}
