package testscript;


import java.io.FileNotFoundException;
import java.util.ArrayList;

import ioModule.IO;
import junit.framework.TestCase;

import org.junit.Test;

import controller.ListHandler;
import controller.MainController;
import store.Course;
import store.Section;
import store.StoredItem;

public class testscript extends TestCase {

	@Test
	public void testcaseA1() throws FileNotFoundException {
		IO io = new IO();
		ArrayList<Course> list = new ArrayList<>();
		System.out.println("enter the number of course");
		int courseNum = 2;
		for(int i=0; i < courseNum;i++){
			System.out.println("enter the id, name, no. of section of course "+(i+1));
			if(i == 0)
			{
			String courseID = "CS0001";
			String courseName = "TEST1";
			Course currCourse = new Course(courseID,courseName);
			int sectionNum = 2;
			for(int j=0; j < sectionNum;j++){
				System.out.println("enter the section (ID,day,start,end,location,CRN,credit) of course");
				//Section(String sectionID, String day, String startTime,String endTime, String location, int cRN, int credit
				if(j == 0)
				{
				Section currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12345",3);
				currCourse.addSec(currSec);
				}
				else
				{
					Section currSec = new Section("C02","Mon","1100","1200","AC1","LT8","12346",3);
					currCourse.addSec(currSec);
				}
			}
			list.add(currCourse);
			}
			
			else
			{
		    String courseID = "CS0002";
			String courseName = "TEST2";
			Course currCourse = new Course(courseID,courseName);
			int sectionNum = 1;
			for(int j=0; j < sectionNum;j++){
				System.out.println("enter the section (ID,day,start,end,location,CRN,credit) of course");
				//Section(String sectionID, String day, String startTime,String endTime, String location, int cRN, int credit
				Section currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12347",3);
				currCourse.addSec(currSec);
				
			}
			list.add(currCourse);
			}
		}
		
		System.out.println("Enter the min. credits that you need to take ");
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(list);
		
		io.out("\nYour Input : \n");
		io.out(list);
		
		MainController MainController = new MainController();
		MainController.run(list); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		io.out("\nResult : \n");
		int totalpriority=0;
		if(result.isEmpty()==true){
			System.out.println("No such result.");
		}else{
			for(StoredItem item : result){
				//io.out(item.toString());
				totalpriority+=item.getSec().getPriority();
			}
		}
		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02)");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01)");
		assertEquals(totalpriority,32);
		}
	

	@Test
	public void testcaseA2() throws FileNotFoundException {
		IO io = new IO();
		ArrayList<Course> list = new ArrayList<>();
		System.out.println("enter the number of course");
		int courseNum = 2;
		for(int i=0; i < courseNum;i++){
			System.out.println("enter the id, name, no. of section of course "+(i+1));
			if(i == 0)
			{
			String courseID = "CS0001";
			String courseName = "TEST1";
			Course currCourse = new Course(courseID,courseName);
			int sectionNum = 2;
			for(int j=0; j < sectionNum;j++){
				System.out.println("enter the section (ID,day,start,end,location,CRN,credit) of course");
				//Section(String sectionID, String day, String startTime,String endTime, String location, int cRN, int credit
				if(j == 0)
				{
				Section currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12345",3);
				currCourse.addSec(currSec);
				}
				else
				{
					Section currSec = new Section("C02","Mon","1100","1200","AC1","LT8","12346",3);
					currCourse.addSec(currSec);
				}
			}
			list.add(currCourse);
			}
			
			else
			{
		    String courseID = "CS0002";
			String courseName = "TEST2";
			Course currCourse = new Course(courseID,courseName);
			int sectionNum = 1;
			for(int j=0; j < sectionNum;j++){
				System.out.println("enter the section (ID,day,start,end,location,CRN,credit) of course");
				//Section(String sectionID, String day, String startTime,String endTime, String location, int cRN, int credit
				Section currSec = new Section("C01","Fri","1200","1300","AC1","LT6","12347",3);
				currCourse.addSec(currSec);
				
			}
			list.add(currCourse);
			}
		}
		
		System.out.println("Enter the min. credits that you need to take ");
		int requireNums = 6;
		MainController.setReqiureNums(requireNums);
		
		ListHandler PriorityHandler=new ListHandler();		
		PriorityHandler.listformat(list);
		
		io.out("\nYour Input : \n");
		io.out(list);
		
		MainController MainController = new MainController();
		MainController.run(list); // calling controller
		ArrayList<StoredItem> result = MainController.result();
		io.out("\nResult : \n");
		int totalpriority=0;
		if(result.isEmpty()==true){
			System.out.println("No such result.");
		}else{
			for(StoredItem item : result){
				//io.out(item.toString());
				totalpriority+=item.getSec().getPriority();
			}
		}
		assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02)");
		assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01)");
		assertEquals(totalpriority,32);
		}
	}
	


