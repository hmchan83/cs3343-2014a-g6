package testscript;

import static org.junit.Assert.*;

import ioModule.IO;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.Test;

import store.Course;

import controller.ConflictDetector;

public class ConflictDetectorTest {
	
	/**
	 * @author Ken
	 *
	 */
	@Test
	public void testConflict() {
		IO IO = new IO();
		ArrayList<Course> courses;
		try {
			courses = IO.inputXML("xml/testcaseA1.xml");
			int result = ConflictDetector.run(courses, 0, courses.get(0).getSec().get(0));
			assertEquals(result,1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* By design, for the purpose of checking course list sequently, 
	 * the conflict detector will only check the conflict num of sections after the course this section in.
	 * we use this test case in which the course and section are same as testCase in testConflict() function
	*/
	@Test
	public void testConflictListingNature() {
		IO IO = new IO();
		ArrayList<Course> courses;
		try {
			courses = IO.inputXML("xml/testcaseA1.xml");
			int result = ConflictDetector.run(courses, 1, courses.get(1).getSec().get(0));
			assertEquals(result,0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
