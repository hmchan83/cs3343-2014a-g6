package testscript;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.OverlapDetector;

public class OverlapDetectorTest {

	@Test
	public void testcase_single_course_set_no_overlap() {
		OverlapDetector tt = new OverlapDetector();
		boolean result = tt.set("Mon", "1100", "1200");
		assertEquals(result, true);
	}
	
	@Test
	public void testcase_check_no_overlap() {
		OverlapDetector tt = new OverlapDetector();
		tt.set("Mon", "1100", "1200");
		boolean result = tt.check("Mon", "1200", "1300");
		assertEquals(result, true);
	}
	
	@Test
	public void testcase_check_overlap() {
		
		OverlapDetector tt = new OverlapDetector();
		tt.set("Mon", "1100", "1200");
		boolean result = tt.check("Mon", "1100", "1300");
		assertEquals(result, false);
		
	}
	
	@Test
	public void testcase_set_overlap() {
		OverlapDetector tt = new OverlapDetector();
		tt.set("Mon", "1100", "1200");
		boolean result = tt.set("Mon", "1100", "1300");
		assertEquals(result, false);
	}
	
	@Test
	public void testcase_getTableContent(){
		OverlapDetector tt = new OverlapDetector();
		tt.set("Mon", "1100", "1200");
		tt.set("Mon", "1100", "1300");
		Boolean b[][] = tt.getTableContents();
		for(int i=0; i<7; i++){
			for(int j=0; j<24; j++){
				if(i == 0 && j == 11)
					assertEquals(b[i][j], true);
				else
					assertEquals(b[i][j], false);
			}
		}
	}
	
}
