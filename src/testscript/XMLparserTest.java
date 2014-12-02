package testscript;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import store.Course;
import junit.framework.TestCase;
import ioModule.DebugMessager;
import ioModule.IO;

public class XMLparserTest extends TestCase {
	
	public XMLparserTest(){
		DebugMessager.disable();
	}

	@Test
	public void testcaseA1(){
		
		IO IO = new IO();
		try {
			ArrayList<Course> result = IO.inputXML("xml/testcaseA1.xml");
			
			assertEquals(result.get(0).getCourseID(), "CS0001");
			assertEquals(result.get(0).getCourseName(), "TEST1");
			assertEquals(Boolean.valueOf(result.get(0).IsCore()), Boolean.valueOf(false));
			
			assertEquals(result.get(0).getSec().get(0).getBuilding(), "AC1");
			assertEquals(result.get(0).getSec().get(0).getCredit(), 3);
			assertEquals(result.get(0).getSec().get(0).getCRN(), "12345");
			assertEquals(result.get(0).getSec().get(0).getStartTime(), "1200");
			assertEquals(result.get(0).getSec().get(0).getEndTime(),"1300");
			assertEquals(result.get(0).getSec().get(0).getDay(), "Fri");
			assertEquals(result.get(0).getSec().get(0).getSectionID(), "C01");
			assertEquals(result.get(0).getSec().get(0).getRoom(), "LT6");
			
			assertEquals(result.get(0).getSec().get(1).getBuilding(), "AC1");
			assertEquals(result.get(0).getSec().get(1).getCredit(), 3);
			assertEquals(result.get(0).getSec().get(1).getCRN(), "12346");
			assertEquals(result.get(0).getSec().get(1).getStartTime(), "1100");
			assertEquals(result.get(0).getSec().get(1).getEndTime(),"1200");
			assertEquals(result.get(0).getSec().get(1).getDay(), "Mon");
			assertEquals(result.get(0).getSec().get(1).getSectionID(), "C02");
			assertEquals(result.get(0).getSec().get(1).getRoom(), "LT8");
			
			assertEquals(result.get(1).getCourseID(), "CS0002");
			assertEquals(result.get(1).getCourseName(), "TEST2");
			assertEquals(Boolean.valueOf(result.get(0).IsCore()), Boolean.valueOf(false));
			
			assertEquals(result.get(1).getSec().get(0).getBuilding(), "AC1");
			assertEquals(result.get(1).getSec().get(0).getCredit(), 3);
			assertEquals(result.get(1).getSec().get(0).getCRN(), "12347");
			assertEquals(result.get(1).getSec().get(0).getStartTime(), "1200");
			assertEquals(result.get(1).getSec().get(0).getEndTime(),"1300");
			assertEquals(result.get(1).getSec().get(0).getDay(), "Fri");
			assertEquals(result.get(1).getSec().get(0).getSectionID(), "C01");
			assertEquals(result.get(1).getSec().get(0).getRoom(), "LT5");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
