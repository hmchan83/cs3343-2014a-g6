package testscript;


import junit.framework.TestCase;

import org.junit.Test;

import controller.FormatConverter;
public class FormatConverterTest  extends TestCase {
	

	@Test
	public void testDay_Mon_Simple() {
		assertEquals(FormatConverter.DayStr2Int("Mon"),0);
	}
	@Test
	public void testDay_Mon_Letter() {
		assertEquals(FormatConverter.DayStr2Int("M"),0);
	}
	@Test
	public void testDay_Mon_Full() {
		assertEquals(FormatConverter.DayStr2Int("Monday"),0);
	}
	@Test
	public void testDay_Tue_Simple() {
		assertEquals(FormatConverter.DayStr2Int("Tue"),1);
	}
	@Test
	public void testDay_Tue_Letter() {
		assertEquals(FormatConverter.DayStr2Int("T"),1);
	}
	public void testDay_Tue_Full() {
		assertEquals(FormatConverter.DayStr2Int("Tuesday"),1);
	}
	@Test
	public void testDay_Wed_Simple() {
		assertEquals(FormatConverter.DayStr2Int("Wed"),2);
	}
	@Test
	public void testDay_Wed_Letter() {
		assertEquals(FormatConverter.DayStr2Int("W"),2);
	}
	@Test
	public void testDay_Wed_Full() {
		assertEquals(FormatConverter.DayStr2Int("Wednesday"),2);
	}
	@Test
	public void testDay_Thu_Simple() {
		assertEquals(FormatConverter.DayStr2Int("Thu"),3);
	}
	@Test
	public void testDay_Thu_Letter() {
		assertEquals(FormatConverter.DayStr2Int("R"),3);
	}
	@Test
	public void testDay_Thu_Full() {
		assertEquals(FormatConverter.DayStr2Int("Thursday"),3);
	}
	@Test
	public void testDay_Fri_Simple() {
		assertEquals(FormatConverter.DayStr2Int("Fri"),4);
	}
	@Test
	public void testDay_Fri_Letter() {
		assertEquals(FormatConverter.DayStr2Int("F"),4);
	}
	@Test
	public void testDay_Fri_Full() {
		assertEquals(FormatConverter.DayStr2Int("Friday"),4);
	}
	@Test
	public void testDay_Sat_Simple() {
		assertEquals(FormatConverter.DayStr2Int("Sat"),5);
	}
	@Test
	public void testDay_Sat_Letter() {
		assertEquals(FormatConverter.DayStr2Int("S"),5);
	}
	@Test
	public void testDay_Sat_Full() {
		assertEquals(FormatConverter.DayStr2Int("Saturday"),5);
	}
	@Test
	public void testDay_Sun_Simple() {
		assertEquals(FormatConverter.DayStr2Int("Sun"),6);
	}
	@Test
	public void testDay_Sun_Full() {
		assertEquals(FormatConverter.DayStr2Int("Sunday"),6);
	}
	@Test
	public void testDayStr_Full() {
		Boolean testBool = false;
		try{
			FormatConverter.DayStr2Int("October");
		}catch(IllegalArgumentException iaex){
			testBool = true;
		}
		assertEquals(testBool,Boolean.TRUE);
	}
	@Test
	public void testDayStr_Letter() {
		Boolean testBool = false;
		try{
			FormatConverter.DayStr2Int("O");
		}catch(IllegalArgumentException iaex){
			testBool = true;
		}
		assertEquals(testBool,Boolean.TRUE);
	}
	@Test
	public void testDayStr_Simple() {
		Boolean testBool = false;
		try{
			FormatConverter.DayStr2Int("Sep");
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
	public void test2500b(){
		Boolean testBool = false;
		try{
			FormatConverter.TimeStr2Int("2500");
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

