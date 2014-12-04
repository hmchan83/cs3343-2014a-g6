package testscript;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import ioModule.IO;
import junit.framework.TestCase;

import org.junit.Test;

import controller.MainController;
import store.Course;
import store.StoredItem;


public class SystemTestByXML extends TestCase{
	
	@Test
	public void testXML_A1() {
		IO IO = new IO();
		try {
			MainController MainController = new MainController();
			ArrayList<Course>courseList = IO.inputXML("xml/testcaseA1.xml");
			MainController.run(courseList); 
			ArrayList<StoredItem> result = MainController.result();
			assertEquals(result.get(0).toString(),"12346 : CS0001 - TEST1 (C02) , location = AC1 LT8");
			assertEquals(result.get(1).toString(),"12347 : CS0002 - TEST2 (C01) , location = AC1 LT5");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testXML_A2() {
		IO IO = new IO();
		try {
			MainController MainController = new MainController();
			ArrayList<Course>courseList = IO.inputXML("xml/testcaseA2.xml");
			MainController.run(courseList); 
			ArrayList<StoredItem> result = MainController.result();
			assertEquals(result.get(0).toString(),"12345 : CS0001 - TEST1 (C01) , location = AC1 LT6");
			assertEquals(result.get(1).toString(),"12348 : CS0002 - TEST2 (C02) , location = AC1 LT8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
