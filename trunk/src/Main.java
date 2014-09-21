import ioMoudle.*;

import java.util.ArrayList;

import Controller.MainController;
import store.Course;
/**
 * Main.java
 * @author Marcus
 *
 */
public class Main {
	public static void main(String[] args) {
		Boolean debug = true; //debug mode, may used to show debug message in runtime;
		int courseNums;
		IO io = new IO();
		ArrayList<Course> courselist = io.input(); //for testing just using simple input
		courseNums = courselist.size();
		io.out(courselist);
		io.out("courseNums = "+courseNums);
		MainController MainController = new MainController();
		MainController.run(courselist,debug); // calling controller
	}
}
