package Controller;

/**
 * Converting String object to int with defined rule
 * 
 * @author Marcus
 *
 */

public class FormatConventor {
	
	public static int DayStr2Int(String str){
		int daypos;
		switch(str){
			case "Mon" : case "M" : daypos=0; break;
			case "Tue" : case "T" : daypos=1; break;
			case "Wed" : case "W" : daypos=2; break;
			case "Thu" : case "R" : daypos=3; break;
			case "Fri" : case "F" : daypos=4; break;
			case "Sat" : case "S" : daypos=5; break;
			case "Sun" :  daypos=6; break; // This may be unless, but keep it in the stage
			default : daypos=0; break; // normally unreachable		
		}
		return daypos;
	}
	
	public static int TimeStr2Int(String str){
		return (Integer.parseInt(str)/100 - 1);
	}
	
}
