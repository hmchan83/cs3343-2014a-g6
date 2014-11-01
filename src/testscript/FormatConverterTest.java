package testscript;


import junit.framework.TestCase;

import org.junit.Test;


import controller.FormatConverter;
public class FormatConverterTest  extends TestCase {
	

	@Test
	public void testDayMonA() {
		assertEquals(FormatConverter.DayStr2Int("Mon"),0);
	}
	@Test
	public void testDayMonB() {
		assertEquals(FormatConverter.DayStr2Int("M"),0);
	}
	@Test
	public void testDayTueA() {
		assertEquals(FormatConverter.DayStr2Int("Tue"),1);
	}
	@Test
	public void testDayTueB() {
		assertEquals(FormatConverter.DayStr2Int("T"),1);
	}
	@Test
	public void testDayWedA() {
		assertEquals(FormatConverter.DayStr2Int("Wed"),2);
	}
	@Test
	public void testDayWedB() {
		assertEquals(FormatConverter.DayStr2Int("W"),2);
	}
	@Test
	public void testDayThuA() {
		assertEquals(FormatConverter.DayStr2Int("Thu"),3);
	}
	@Test
	public void testDayThuB() {
		assertEquals(FormatConverter.DayStr2Int("R"),3);
	}
	@Test
	public void testDayFriA() {
		assertEquals(FormatConverter.DayStr2Int("Fri"),4);
	}
	@Test
	public void testDayFriB() {
		assertEquals(FormatConverter.DayStr2Int("F"),4);
	}
	@Test
	public void testDaySatA() {
		assertEquals(FormatConverter.DayStr2Int("Sat"),5);
	}
	@Test
	public void testDaySatB() {
		assertEquals(FormatConverter.DayStr2Int("S"),5);
	}
	@Test
	public void testDaySunA() {
		assertEquals(FormatConverter.DayStr2Int("Sun"),6);
	}
	@Test
	public void testDayStr() {
		Boolean testBool = false;
		try{
			FormatConverter.DayStr2Int("October");
		}catch(IllegalArgumentException iaex){
			testBool = true;
		}
		assertEquals(testBool,Boolean.TRUE);
	}
	@Test
	public void test0000() {
		assertEquals(FormatConverter.TimeStr2Int("00:00"),0);
	}
	@Test
	public void test0000A() {
		assertEquals(FormatConverter.TimeStr2Int("0000"),0);
	}
	@Test
	public void test0030() {
		assertEquals(FormatConverter.TimeStr2Int("0030"),0);
	}
	@Test
	public void test1300() {
		assertEquals(FormatConverter.TimeStr2Int("1300"),13);
	}
	@Test
	public void test13000() {
		assertEquals(FormatConverter.TimeStr2Int("13000"),13);
	}
	@Test
	public void test13_00() {
		assertEquals(FormatConverter.TimeStr2Int("13-00"),13);
	}

	@Test
	public void test2500(){
		Boolean testBool = false;
		try{
			FormatConverter.TimeStr2Int("25:00");
		}catch(IllegalArgumentException iaex){
			testBool = true;
		}
		assertEquals(testBool,Boolean.TRUE);
	}
	@Test
	public void testStr(){
		Boolean testBool = false;
		try{
			FormatConverter.TimeStr2Int("I am a String");
		}catch(IllegalArgumentException iaex){
			testBool = true;
		}
		assertEquals(testBool,Boolean.TRUE);
	}
	@Test
	public void testStr2(){
		Boolean testBool = false;
		try{
			FormatConverter.TimeStr2Int("-120");
		}catch(IllegalArgumentException iaex){
			testBool = true;
		}
		assertEquals(testBool,Boolean.TRUE);
	}
	@Test
	public void testStr3(){
		Boolean testBool = false;
		try{
			FormatConverter.TimeStr2Int("-2400");
		}catch(IllegalArgumentException iaex){
			testBool = true;
		}
		assertEquals(testBool,Boolean.TRUE);
	}
}

