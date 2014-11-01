package controller;

/**
 * Converting String object to int with defined rule
 * @author Marcus
 *
 */

public class FormatConventor {
	/**
	 * given a day string and convert it to a int
	 * @param str a string that describe the day of a week, accepted value : Mon - Fri and M,T,W (from Mastering Schedule)
	 * @return 0 for Monday ... 6 for Sunday
	 */
	public static int DayStr2Int(String str){
		int daypos;
		switch(str){
			case "Mon" : case "M" : daypos=0; break;
			case "Tue" : case "T" : daypos=1; break;
			case "Wed" : case "W" : daypos=2; break;
			case "Thu" : case "R" : daypos=3; break;
			case "Fri" : case "F" : daypos=4; break;
			case "Sat" : case "S" : daypos=5; break;
			case "Sun" :  daypos=6; break; // This may be unless, but keep it in this stage
			default : daypos=-1; break; // normally unreachable		
		}
		return daypos;
	}
	
	/**
	 * convert a time string to int, eg 2300 become 23 / 23:00 become 23
	 * @param str time string in 1100,1000,2200 etc format
	 * @return 2300 return 23, the position in the timetable / return -1 if wrong input
	 */
	public static int TimeStr2Int(String str)throws IllegalArgumentException {
		if(str.length()==4){
			if(Integer.parseInt(str)>2300 || Integer.parseInt(str)<0){
				throw new IllegalArgumentException();
			}
			return (Integer.parseInt(str)/100);
		}else if(str.length()==5){
			String first = str.substring(0,2);
			if(Integer.parseInt(first)>23 || Integer.parseInt(first)<0){
				throw new IllegalArgumentException();
			}
			return(Integer.parseInt(first));
		}			
		throw new IllegalArgumentException();
	}
	
}
