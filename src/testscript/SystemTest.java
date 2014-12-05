//Edit by Sam Cheuk, 26/10/2014
package testscript;

import ioModule.DebugMessager;

import java.util.ArrayList;







import junit.framework.TestCase;

import org.junit.Test;

import controller.MainController;
import exceptionPackage.CoreNotAddedExc;
import store.Course;
import store.Section;
import store.StoredItem;

public class SystemTest extends TestCase {

	 public SystemTest(){
		DebugMessager.disable();
	}
	@Test
	public void testcaseA1() throws CoreNotAddedExc  {
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12345",3);
		currCourse.addSec(currSec);
	    currSec = new Section("C02","Mon","1100","1200","AC1","LT8","12346",3);
		currCourse.addSec(currSec);	
		courselist.add(currCourse);
		
	    courseID = "CS0002";
	    courseName = "TEST2";
	    currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT5","12347",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController MainController = new MainController();
		MainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		
		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02) , location = AC1 LT8");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01) , location = AC1 LT5");
		}
	

	@Test
	public void testcaseA2() throws CoreNotAddedExc {
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12345",3);
		currCourse.addSec(currSec);
	    currSec = new Section("C02","Mon","1100","1200","AC1","LT7","12346",3);
		currCourse.addSec(currSec);	
		courselist.add(currCourse);
		
	    courseID = "CS0002";
	    courseName = "TEST2";
	    currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT5","12347",3);
		currCourse.addSec(currSec);
		currSec = new Section("C02","Mon","1100","1200","AC1","LT8","12348",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		
		MainController MainController = new MainController();
		MainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		

		assertEquals(result.get(0).toString(),"12345 : CS0001 - TEST1 (C01) , location = AC1 LT6");
		assertEquals(result.get(1).toString(),"12348 : CS0002 - TEST2 (C02) , location = AC1 LT8");

	}
	
	@Test
	public void testcaseB1() throws CoreNotAddedExc {
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12345",3);
		currCourse.addSec(currSec);
	    currSec = new Section("C02","Mon","1100","1200","AC1","LT7","12346",3);
		currCourse.addSec(currSec);	
		courselist.add(currCourse);
		
	    courseID = "CS0002";
	    courseName = "TEST2";
	    currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT5","12347",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS0003";
		courseName = "TEST3";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Mon","1100","1200","AC1","LT8","12348",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
				
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02) , location = AC1 LT7");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01) , location = AC1 LT5");
		
	}
	
	@Test
	public void testcaseB2() throws CoreNotAddedExc { 
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
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
	    currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
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
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
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
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Tue","0900","1200","AC2","2550","40001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS0005";
		courseName = "TEST5";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Wed","0900","1300","AC2","2550","50001",3);
		currCourse.addSec(currSec);
		currSec = new Section("C02","Mon","1700","1900","AC2","2550","50002",3);
		currCourse.addSec(currSec);
		currSec = new Section("C03","Mon","1500","1700","AC2","2550","50003",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS0006";
		courseName = "TEST6";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Fri","1200","1400","AC2","2550","60001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		
		
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		/*IO io = new IO();
		io.out("\nYour Input : \n");
		io.out(courselist);*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(),"10002 : CS0001 - TEST1 (C02) , location = AC1 LT8");
		assertEquals(result.get(1).toString(),"20003 : CS0002 - TEST2 (C03) , location = AC1 LT6");
		assertEquals(result.get(2).toString(),"30003 : CS0003 - TEST3 (CA3) , location = AC1 LT7");
		assertEquals(result.get(3).toString(),"40001 : CS0004 - TEST4 (C01) , location = AC2 2550");
		assertEquals(result.get(4).toString(),"50001 : CS0005 - TEST5 (C01) , location = AC2 2550");
		assertEquals(result.get(5).toString(),"60001 : CS0006 - TEST6 (C01) , location = AC2 2550");
		
		
	}
	
	public void testcaseR1() throws CoreNotAddedExc{
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS3343";
		String courseName;
		courseName = "Software-Engineering-Practice";
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("CB1","Fri","1400","1500","AC1","LT7","45542",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS4480";
		courseName = "Data-Intensive-Computing";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C61","Wed","1900","2100","MMW","2450","46406",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3483";
		courseName = "Multimodal-Interface-Design";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Fri","1500","1700","AC1","LT8","31330",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3283";
		courseName = "Distributed-Systems";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C61","Wed","1900","2100","AC2","1301","35361",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3346";
		courseName = "Software-Testing-and-Maintenance";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C61","Tue","1900","2100","AC2","1301","18748",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 15;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();

		assertEquals(result.isEmpty(),true);
	}
	
	public void testcaseR2() throws CoreNotAddedExc{// The last Course do not handled.
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS3343";
		String courseName;
		courseName = "Software-Engineering-Practice";
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("CB1","Fri","1400","1500","AC1","LT7","45542",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS4480";
		courseName = "Data-Intensive-Computing";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C61","Wed","1900","2100","MMW","2450","46406",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3483";
		courseName = "Multimodal-Interface-Design";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Fri","1500","1700","AC1","LT8","31330",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3283";
		courseName = "Distributed-Systems";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C61","Wed","1900","2100","AC2","1301","35361",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "CS3346";
		courseName = "Software-Testing-and-Maintenance";
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C61","Tue","1900","2100","AC2","1301","18748",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 12;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "45542 : CS3343 - Software-Engineering-Practice (CB1) , location = AC1 LT7");
		assertEquals(result.get(1).toString(), "46406 : CS4480 - Data-Intensive-Computing (C61) , location = MMW 2450");
		assertEquals(result.get(2).toString(), "31330 : CS3483 - Multimodal-Interface-Design (C01) , location = AC1 LT8");
		assertEquals(result.get(3).toString(), "18748 : CS3346 - Software-Testing-and-Maintenance (C61) , location = AC2 1301");
	}
	
	public void testcaseR3() throws CoreNotAddedExc{// Taking From major BIE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "MBE3101";
		String courseName;
		courseName = "Micro and Nanotechnology for Bioengineering";//core
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Tue","1000","1200","AC1","Y5206","46127",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "AP3130";
		courseName = "Biomaterials";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Thu","0900","1100","AC1","LT7","45764",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "EE3919";
		courseName = "Medical Imaging and Signal Processing";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Thu","1700","1900","AC1","P4703","46245",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "AP2102";
		courseName = "Introduction to Materials Engineering";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("CB1","Tue","1300","1500","AC1","LT11","29795",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "EE2104";
		courseName = "Introduction to Electromagnetics";//elective
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Wed","1200","1400","AC1","LT9","34193",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "BCH3856";
		courseName = "Cell Transport and Signalling";//elective
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Thu","1500","1700","AC1","B5310","45521",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "SEEM3062";
		courseName = "Quality Engineering I";//elective
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Fri","1400","1700","AC1","B5210","40435",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 15;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "46127 : MBE3101 - Micro and Nanotechnology for Bioengineering (C01) , location = AC1 Y5206");
		assertEquals(result.get(1).toString(), "45764 : AP3130 - Biomaterials (C01) , location = AC1 LT7");
		assertEquals(result.get(2).toString(), "46245 : EE3919 - Medical Imaging and Signal Processing (C01) , location = AC1 P4703");
		assertEquals(result.get(3).toString(), "29795 : AP2102 - Introduction to Materials Engineering (CB1) , location = AC1 LT11");
		assertEquals(result.get(4).toString(), "34193 : EE2104 - Introduction to Electromagnetics (C01) , location = AC1 LT9");
	}
	
	public void testcaseR4() throws CoreNotAddedExc{// Taking From major MFSE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "MBE3007";
		String courseName;
		courseName = "CAD/CAM";//core
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1700","1900","AC1","P4701","40181",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "MBE3006";
		courseName = "Plastics Engineering";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Mon","1900","2100","AC1","LT11","40172",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "SEEM3032";
		courseName = "Production and Operations Planning";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Fri","1200","1400","AC3","6213","42005",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "MBE2036";
		courseName = "Engineering Computing";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Wed","1700","1900","AC1","LT8","41984",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "SEEM3020";
		courseName = "Engineering Economic Analysis";//elective
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Mon","1700","1900","AC1","LT14","40395",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "SEEM3027";
		courseName = "Logistics and Materials Management";//elective
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Thu","1700","1900","AC1","LT9","40403",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "SEEM3053";
		courseName = "Quality Improvement Methodologies";//elective
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Wed","1200","1400","AC1","B5210","43194",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
	
		int requireNums = 15;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "40181 : MBE3007 - CAD/CAM (C01) , location = AC1 P4701");
		assertEquals(result.get(1).toString(), "40172 : MBE3006 - Plastics Engineering (C01) , location = AC1 LT11");
		assertEquals(result.get(2).toString(), "42005 : SEEM3032 - Production and Operations Planning (C01) , location = AC3 6213");
		assertEquals(result.get(3).toString(), "41984 : MBE2036 - Engineering Computing (C01) , location = AC1 LT8");
		assertEquals(result.get(4).toString(), "40395 : SEEM3020 - Engineering Economic Analysis (C01) , location = AC1 LT14");
	}
	
	public void testcaseR5() throws CoreNotAddedExc{// Taking From major MTE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "MBE4010";
		String courseName;
		courseName = "Dynamics and Modelling";//core
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Tue","1700","1900","AC1","B5211","43933",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "MBE4110";
		courseName = "Sensors";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Fri","1000","1200","AC1","P4302","46142",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "MBE3058";
		courseName = "Embedded Control Systems";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Thu","1500","1700","AC1","G5314","40210",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "MBE3115";
		courseName = "Microelectromechanical Systems";//core
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Thu","1700","1900","AC1","P4701","41996",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "MBE2036";
		courseName = "Engineering Computing";//elective,14
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Wed","1700","1900","AC1","LT8","41984",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "MBE3006";
		courseName = "Plastics Engineering";//elective,1
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Mon","1900","2100","AC1","LT11","40172",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "MBE3007";
		courseName = "CAD/CAM";//elective,12
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Fri","1700","1900","AC1","P4701","40181",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "SEEM3040";
		courseName = "Engineering Database and Systems";//elective,2
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("C01","Fri","1700","1900","AC2","1110","40422",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
	
		int requireNums = 15;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "43933 : MBE4010 - Dynamics and Modelling (C01) , location = AC1 B5211");
		assertEquals(result.get(1).toString(), "46142 : MBE4110 - Sensors (C01) , location = AC1 P4302");
		assertEquals(result.get(2).toString(), "40210 : MBE3058 - Embedded Control Systems (C01) , location = AC1 G5314");
		assertEquals(result.get(3).toString(), "41996 : MBE3115 - Microelectromechanical Systems (C01) , location = AC1 P4701");
		assertEquals(result.get(4).toString(), "41984 : MBE2036 - Engineering Computing (C01) , location = AC1 LT8");
	}

	public void testcaseR6() throws CoreNotAddedExc{// Taking From major MAE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "AP3190";
		String courseName;
		courseName = "Thermodynamics of Materials";//core
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("CA1","Wed","1300","1500","AC2","3610","17780",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "AP3113";
		courseName = "Polymer Engineering";//elective,19
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		currSec = new Section("CA1","Fri","0900","1100","AC2","2200","12059",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "AP3130";
		courseName = "Biomaterials";//elective,15
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Thu","0900","1100","AC1","LT7","45764",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		courseID = "AP4170";
		courseName = "Environmental Degradation";//elective,15
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
	    currSec = new Section("C01","Thu","1200","1500","AC1","P4701","44358",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 9;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "17780 : AP3190 - Thermodynamics of Materials (CA1) , location = AC2 3610");
		assertEquals(result.get(1).toString(), "12059 : AP3113 - Polymer Engineering (CA1) , location = AC2 2200");
		assertEquals(result.get(2).toString(), "45764 : AP3130 - Biomaterials (C01) , location = AC1 LT7");
	}
	

	
	public void testcaseL1() throws CoreNotAddedExc{// Taking From major BIE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";//core
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","10001",3);
		currCourse.addSec(currSec);
		currSec = new Section("T01","Fri","1500","1600","AC2","1234","10002",0);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 3;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "10001 : CS0001 - TEST1 (C01) , location = AC1 LT6");
		assertEquals(result.get(1).toString(), "10002 : CS0001 - TEST1 (T01) , location = AC2 1234");

	}
	public void testcaseL2() throws CoreNotAddedExc{// Taking From major BIE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";//core
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("S01","Fri","1200","1300","AC1","LT6","10001",3);
		currCourse.addSec(currSec);
		currSec = new Section("L01","Fri","1500","1600","AC2","1234","10002",0);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 3;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "10001 : CS0001 - TEST1 (S01) , location = AC1 LT6");
		assertEquals(result.get(1).toString(), "10002 : CS0001 - TEST1 (L01) , location = AC2 1234");

	}
	public void testcaseC1() throws CoreNotAddedExc{// Taking From major BIE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";//core
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","10001",3);
		currCourse.addSec(currSec);
		currCourse.setIsCore(true);
		courselist.add(currCourse);
		
		currCourse = new Course();
		currCourse.setCourseID("CS0002");
		currCourse.setCourseName("TEST2");
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT7","20001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		currCourse = new Course();
		currCourse.setCourseID("CS0003");
		currCourse.setCourseName("TEST3");
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT8","30001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 3;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "10001 : CS0001 - TEST1 (C01) , location = AC1 LT6");

	}

	public void testcaseC2() throws CoreNotAddedExc{// Taking From major BIE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";//core
		Course currCourse;
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","10001",3);
		currCourse.addSec(currSec);
		currCourse.setIsCore(true);
		courselist.add(currCourse);
		
		currCourse = new Course();
		currCourse.setCourseID("CS0002");
		currCourse.setCourseName("TEST2");
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT7","20001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		currCourse = new Course();
		currCourse.setCourseID("CS0003");
		currCourse.setCourseName("TEST3");
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT8","30001",3);
		currCourse.addSec(currSec);
		currCourse.setIsCore(true);
		courselist.add(currCourse);
		
		int requireNums = 3;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.isEmpty(),true);
	
	}
	
	public void testcaseL3() throws CoreNotAddedExc{// Taking From major BIE Year 3 Sem A Course
		ArrayList<Course> courselist = new ArrayList<>();
		String courseID;
		courseID = "CS0001";
		String courseName;
		courseName = "TEST1";//core
		Course currCourse;
		
		currCourse = new Course();
		currCourse.setCourseID(courseID);
		currCourse.setCourseName(courseName);
		Section currSec;
	    currSec = new Section("C01","Sat","1200","1300","AC1","LT6","10001",3);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		currCourse = new Course();
		currCourse.setCourseID("CS0002");
		currCourse.setCourseName("TEST2");
	    currSec = new Section("C01","Fri","1200","1300","AC1","LT6","20001",3);
		currCourse.addSec(currSec);
		currSec = new Section("T01","Fri","1500","1600","AC2","1234","20002",0);
		currCourse.addSec(currSec);
		courselist.add(currCourse);
		
		int requireNums = 3;
		MainController.setReqiureNums(requireNums);
		
		/*
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(courselist);
		*/
		
		MainController mainController = new MainController();
		mainController.run(courselist); // calling controller
		ArrayList<StoredItem> result = mainController.result();
		
		assertEquals(result.get(0).toString(), "10001 : CS0001 - TEST1 (C01) , location = AC1 LT6");
		assertEquals(result.get(1).toString(), "20001 : CS0002 - TEST2 (C01) , location = AC1 LT6");
		assertEquals(result.get(2).toString(), "20002 : CS0002 - TEST2 (T01) , location = AC2 1234");

	}
}





	


