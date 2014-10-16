package testscript;



import java.util.ArrayList;


import junit.framework.TestCase;

import org.junit.Test;

import controller.ListHandler;
import controller.MainController;
import store.Course;
import store.Section;
import store.StoredItem;

public class testscript extends TestCase {

	@Test
	public void testcaseA1()  {
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";
		Course currCourse;
		currCourse = new Course(courseID,courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12345",3);
		currCourse.addSec(currSec);
	    currSec = new Section("C02","Mon","1100","1200","AC1","LT8","12346",3);
		currCourse.addSec(currSec);	
		courselist.add(currCourse);
		
	    courseID = "CS0002";
	    courseName = "TEST2";
	    currCourse = new Course(courseID,courseName);
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT5","12347",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		
		MainController MainController = new MainController();
		MainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		
		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02)");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01)");
		}
	

	@Test
	public void testcaseA2() {
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";
		Course currCourse;
		currCourse = new Course(courseID,courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12345",3);
		currCourse.addSec(currSec);
	    currSec = new Section("C02","Mon","1100","1200","AC1","LT7","12346",3);
		currCourse.addSec(currSec);	
		courselist.add(currCourse);
		
	    courseID = "CS0002";
	    courseName = "TEST2";
	    currCourse = new Course(courseID,courseName);
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT5","12347",3);
		currCourse.addSec(currSec);
		currSec = new Section("C02","Mon","1100","1200","AC1","LT8","12348",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		
		MainController MainController = new MainController();
		MainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		
		assertEquals(result.get(0).toString(),"12345 : CS0001 - TEST1 (C01)");//problem come here!
		assertEquals(result.get(1).toString(),"12348 : CS0002 - TEST2 (C02)");
		//
	}
}
	


