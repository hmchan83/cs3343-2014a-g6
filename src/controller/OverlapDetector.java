package controller;

import store.TimeTable;
import ioModule.DebugMessager;


/**
 * A time table used to mark the time slot is used or not
 * @author Marcus
 *
 */

public class OverlapDetector {	
	static String title = "OverlapDetector : ";
	static private Boolean[][] baseTable;
	//private Boolean[][] table;
	private TimeTable table;
	
	
	public OverlapDetector(){
		table= new TimeTable();
		reset();
	}
	
	public OverlapDetector(TimeTable table){
		table= new TimeTable();
		this.table=table;
	}
	
	public OverlapDetector(Boolean[][] table){
		this.table= new TimeTable();
		this.table.setTableContents(table);
	}
	
	public void reset(){
		if(baseTable!=null){
			table.setTableContents(baseTable);
		}
		table.reset();
	}
	
	public TimeTable getTable() {
		return table;
	}
	
	public Boolean[][] getTableContents() {
		return table.getTableContents();
	}

	public void setTable(Boolean[][] table) {
		this.table.setTableContents(table);
	}
	
	public void setTable(TimeTable table){
		this.table=table;
	}

	public boolean set(String day,String starttime,String endtime){ // converting String item to the postion of array
		try{
			int dayint = FormatConverter.DayStr2Int(day);
			int start = FormatConverter.TimeStr2Int(starttime);
			int end = FormatConverter.TimeStr2Int(endtime);
			DebugMessager.debug(title+"set("+dayint+","+start+","+end+")");
			return set(dayint,start,end);
		}catch(Exception e){
			return false;
		}		
	}
	
	public boolean check(String day, String startitme,String Endtime){
		try{
			int dayint = FormatConverter.DayStr2Int(day);
			int start = FormatConverter.TimeStr2Int(startitme);
			int end = FormatConverter.TimeStr2Int(Endtime);
			DebugMessager.debug(title+"check("+dayint+","+start+","+end+")");
			return check(dayint,start,end);
		}catch(Exception e){
			return false;
		}
	}
	
	public boolean check(int day,int starttime, int endtime){
		//check
		if(starttime<0 && starttime>23) return false;
		if(endtime<0 && endtime>23) return false;
		if(day<0 && day>6) return false;
		for(int i=starttime;i<endtime;i++){
			if(this.table.getTableContents(day, i)==TimeTable.USED){
				DebugMessager.debug(title+"day = "+day+", time = "+i+" is used!!");
				return false; // time slot overlap
			}
		}
		return true;
	}
	
	public boolean set(int day,int starttime, int endtime){
		if(check(day,starttime,endtime)==false) return false; //check the time slot is available or not
		
		//set the time slot to used
		for(int i=starttime;i<endtime;i++){
			table.setTableContents(day, i); // time slot used
		}
		return true;
	}
	
	static public void setBaseTable(Boolean[][] table){
		baseTable=table;
	}
	static public Boolean[][] getBaseTable(){
		return baseTable;
	}
	
	
}
