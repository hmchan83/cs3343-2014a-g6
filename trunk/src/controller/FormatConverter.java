package controller;

/**
 * Converting String object to int with defined rule
 * @author Marcus
 *
 */

public class FormatConverter {
	/**
	 * given a day string and convert it to a int
	 * @param str a string that describe the day of a week, accepted value : Mon - Fri and M,T,W (from Mastering Schedule)
	 * @return 0 for Monday ... 6 for Sunday
	 */
	public static int DayStr2Int(String str)throws IllegalArgumentException{
		int daypos=-1;
		if(str.length()==1){
			daypos=LetterDayStr2Int(str);
		}else if(str.length()==3){
			daypos=SimpleDayStr2Int(str);
		}else{
			daypos=FullDayStr2Int(str);
		}
		if(daypos==-1){
			throw new IllegalArgumentException();
		}
		return daypos;
	}
	
	private static int FullDayStr2Int(String str){
		str = str.toUpperCase();
		if(str.equals("MONDAY"))
			return 0;
		else if(str.equals("TUESDAY"))
			return 1;
		else if(str.equals("WEDNESDAY"))
			return 2;
		else if(str.equals("THURSDAY"))
			return 3;
		else if(str.equals("FRIDAY"))
			return 4;
		else if(str.equals("SATURDAY"))
			return 5;
		else if(str.equals("SUNDAY"))
			return 6;
		else
			return -1;
	}
	
	private static int SimpleDayStr2Int(String str){
		str = str.toUpperCase();
		if(str.equals("MON"))
			return 0;
		else if(str.equals("TUE"))
			return 1;
		else if(str.equals("WED"))
			return 2;
		else if(str.equals("THU"))
			return 3;
		else if(str.equals("FRI"))
			return 4;
		else if(str.equals("SAT"))
			return 5;
		else if(str.equals("SUN"))
			return 6;
		else
			return -1;
	}
	
	private static int LetterDayStr2Int(String str){
		str = str.toUpperCase();
		if(str.equals("M"))
			return 0;
		else if(str.equals("T"))
			return 1;
		else if(str.equals("W"))
			return 2;
		else if(str.equals("R"))
			return 3;
		else if(str.equals("F"))
			return 4;
		else if(str.equals("S"))
			return 5;
		else
			return -1;
	}
	
	/**
	 * convert a time string to int, eg 2300 become 23 / 23:00 become 23
	 * @param str time string in 1100,1000,2200 etc format
	 * @return 2300 return 23, the position in the timetable / return -1 if wrong input
	 */
	public static int TimeStr2Int(String str)throws IllegalArgumentException {
		if(str.length()==4){
			if(Integer.parseInt(str)>2300){
				throw new IllegalArgumentException();
			}if(Integer.parseInt(str)<0){
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
