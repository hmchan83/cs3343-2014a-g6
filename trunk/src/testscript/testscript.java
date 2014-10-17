package testscript;



import ioModule.DebugMessager;

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
		

		assertEquals(result.get(0).toString(),"12345 : CS0001 - TEST1 (C01)");
		assertEquals(result.get(1).toString(),"12348 : CS0002 - TEST2 (C02)");

	}
	
	@Test
	public void testcaseB1() {
		DebugMessager.enable();
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
		courselist.add(currCourse);
		
		courseID = "CS0003";
		courseName = "TEST3";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C01","Mon","1100","1200","AC1","LT8","12348",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		System.out.println(courselist.size());
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		/*System.out.println(result.get(0).toString());
		System.out.println(result.get(1).toString());*/
		
		System.out.println(result.size());
		
		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02)");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01)");
		
	}
	
	@Test
	public void testcaseB2() {
		DebugMessager.enable();
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";
		Course currCourse;
		currCourse = new Course(courseID,courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1400","AC1","LT6","10001",3);
		currCourse.addSec(currSec);
	    currSec = new Section("C02","Mon","1100","1300","AC1","LT8","10002",3);
		currCourse.addSec(currSec);	
		currSec = new Section("C03","Wed","2000","2200","AC1","LT7","10003",3);
		currCourse.addSec(currSec);	
		currSec = new Section("C04","Mon","0900","1100","AC1","LT3","10004",3);
		currCourse.addSec(currSec);	
		currSec = new Section("C05","Fri","1500","1700","AC1","LT2","10005",3);
		currCourse.addSec(currSec);	
		courselist.add(currCourse);
		
	    courseID = "CS0002";
	    courseName = "TEST2";
	    currCourse = new Course(courseID,courseName);
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","20001",3);
	    currCourse.addSec(currSec);
	    currSec = new Section("C02","Mon","1200","1300","AC1","LT6","20002",3);
	    currCourse.addSec(currSec);	
	    currSec = new Section("C03","Tue","1200","1300","AC1","LT6","20003",3);
	    currCourse.addSec(currSec);	
	    currSec = new Section("C04","Wed","1200","1300","AC1","LT6","20004",3);
	    currCourse.addSec(currSec);	
	    currSec = new Section("C05","Thu","1200","1300","AC1","LT6","20005",3);
	    currCourse.addSec(currSec);	
	    courselist.add(currCourse);
		
		courseID = "CS0003";
		courseName = "TEST3";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("CA1","Fri","1200","1400","AC1","LT6","30001",3);
		currCourse.addSec(currSec);
		currSec = new Section("CA2","Mon","1100","1300","AC1","LT8","30002",3);
		currCourse.addSec(currSec);
		currSec = new Section("CA3","Wed","1800","2000","AC1","LT7","30003",3);
		currCourse.addSec(currSec);
		currSec = new Section("CA4","Mon","0900","1100","AC1","LT3","30004",3);
		currCourse.addSec(currSec);
		currSec = new Section("CA5","Fri","1500","1700","AC1","LT2","30005",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS0004";
		courseName = "TEST4";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C01","Tue","0900","1200","AC2","2250","40001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		System.out.println(courselist.size());
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		/*System.out.println(result.get(0).toString());
		System.out.println(result.get(1).toString());*/
		
		System.out.println(result.size());
		
		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02)");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01)");
		
	}
}




	


