//Edit by Sam Cheuk, 26/10/2014
package testscript;

import java.util.ArrayList;





import junit.framework.TestCase;

import org.junit.Test;

import controller.ListHandler;
import controller.MainController;
import exceptionPackage.CoreNotAddedExc;
import store.Course;
import store.Section;
import store.StoredItem;

public class Testscript extends TestCase {

	 public Testscript(){
		//DebugMessager.enable();
	}
	@Test
	public void testcaseA1() throws CoreNotAddedExc  {
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
	public void testcaseA2() throws CoreNotAddedExc {
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
		

		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02)");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01)");

	}
	
	@Test
	public void testcaseB1() throws CoreNotAddedExc {
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
				
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02)");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01)");
		
	}
	
	@Test
	public void testcaseB2() throws CoreNotAddedExc { 
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
		currSec = new Section("C01","Tue","0900","1200","AC2","2550","40001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS0005";
		courseName = "TEST5";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C01","Wed","0900","1300","AC2","2550","50001",3);
		currCourse.addSec(currSec);
		currSec = new Section("C02","Mon","1700","1900","AC2","2550","50002",3);
		currCourse.addSec(currSec);
		currSec = new Section("C03","Mon","1500","1700","AC2","2550","50003",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS0006";
		courseName = "TEST6";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C01","Fri","1200","1400","AC2","2550","60001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		/*IO io = new IO();
		io.out("\nYour Input : \n");
		io.out(courselist);*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(),"10003 : CS0001 - TEST1 (C03)");
		assertEquals(result.get(1).toString(),"20003 : CS0002 - TEST2 (C03)");
		assertEquals(result.get(2).toString(),"30002 : CS0003 - TEST3 (CA2)");
		assertEquals(result.get(3).toString(),"40001 : CS0004 - TEST4 (C01)");
		assertEquals(result.get(4).toString(),"50001 : CS0005 - TEST5 (C01)");
		assertEquals(result.get(5).toString(),"60001 : CS0006 - TEST6 (C01)");
		
		
	}
	
	public void testcaseR1() throws CoreNotAddedExc{
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS3343";
		String courseName;
		courseName = "Software-Engineering-Practice";
		Course currCourse;
		currCourse = new Course(courseID,courseName);
		Section currSec;
	    currSec = new Section("CB1","Fri","1400","1500","AC1","LT7","45542",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS4480";
		courseName = "Data-Intensive-Computing";
		currCourse = new Course(courseID,courseName);
	    currSec = new Section("C61","Wed","1900","2100","MMW","2450","46406",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3483";
		courseName = "Multimodal-Interface-Design";
		currCourse = new Course(courseID,courseName);
	    currSec = new Section("C01","Fri","1500","1700","AC1","LT8","31330",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3283";
		courseName = "Distributed-Systems";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C61","Wed","1900","2100","AC2","1301","35361",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3346";
		courseName = "Software-Testing-and-Maintenance";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C61","Tue","1900","2100","AC2","1301","18748",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 15;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();

		assertEquals(result.isEmpty(),true);
	}
	
	public void testcaseR2() throws CoreNotAddedExc{
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS3343";
		String courseName;
		courseName = "Software-Engineering-Practice";
		Course currCourse;
		currCourse = new Course(courseID,courseName);
		Section currSec;
	    currSec = new Section("CB1","Fri","1400","1500","AC1","LT7","45542",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS4480";
		courseName = "Data-Intensive-Computing";
		currCourse = new Course(courseID,courseName);
	    currSec = new Section("C61","Wed","1900","2100","MMW","2450","46406",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3483";
		courseName = "Multimodal-Interface-Design";
		currCourse = new Course(courseID,courseName);
	    currSec = new Section("C01","Fri","1500","1700","AC1","LT8","31330",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3283";
		courseName = "Distributed-Systems";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C61","Wed","1900","2100","AC2","1301","35361",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3346";
		courseName = "Software-Testing-and-Maintenance";
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C61","Tue","1900","2100","AC2","1301","18748",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 12;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "45542 : CS3343 - Software-Engineering-Practice (CB1)");
		assertEquals(result.get(1).toString(), "46406 : CS4480 - Data-Intensive-Computing (C61)");
		assertEquals(result.get(2).toString(), "31330 : CS3483 - Multimodal-Interface-Design (C01)");
		assertEquals(result.get(3).toString(), "18748 : CS3346 - Software-Testing-and-Maintenance (C61)");
	}
	
	public void testcaseR3() throws CoreNotAddedExc{// Taking From major BIE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "MBE3101";
		String courseName;
		courseName = "Micro and Nanotechnology for Bioengineering";//core
		Course currCourse;
		currCourse = new Course(courseID,courseName);
		Section currSec;
	    currSec = new Section("C01","Tue","1000","1200","AC1","Y5206","46127",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "AP3130";
		courseName = "Biomaterials";//core
		currCourse = new Course(courseID,courseName);
	    currSec = new Section("C01","Thu","0900","1100","AC1","LT7","45764",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "EE3919";
		courseName = "Medical Imaging and Signal Processing";//core
		currCourse = new Course(courseID,courseName);
	    currSec = new Section("C01","Thu","1700","1900","AC1","P4703","46245",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "AP2102";
		courseName = "Introduction to Materials Engineering";//core
		currCourse = new Course(courseID,courseName);
		currSec = new Section("CB1","Tue","1300","1500","AC1","LT11","29795",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "EE2104";
		courseName = "Introduction to Electromagnetics";//elective
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C01","Wed","1200","1400","AC1","LT9","34193",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "BCH3856";
		courseName = "Cell Transport and Signalling";//elective
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C01","Thu","1500","1700","AC1","B5310","45521",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "SEEM3062";
		courseName = "Quality Engineering I";//elective
		currCourse = new Course(courseID,courseName);
		currSec = new Section("C01","Fri","1400","1700","AC1","B5210","40435",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 15;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "46127 : MBE3101 - Micro and Nanotechnology for Bioengineering (C01)");
		assertEquals(result.get(1).toString(), "45764 : AP3130 - Biomaterials (C01)");
		assertEquals(result.get(2).toString(), "46245 : EE3919 - Medical Imaging and Signal Processing (C01)");
		assertEquals(result.get(3).toString(), "29795 : AP2102 - Introduction to Materials Engineering (CB1)");
		assertEquals(result.get(4).toString(), "34193 : EE2104 - Introduction to Electromagnetics (C01)");
	}
}





	


