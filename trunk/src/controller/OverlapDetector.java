package controller;

import ioModule.DebugMessager;


/**
 * A time table used to mark the time slot is used or not
 * @author Marcus
 *
 */

public class OverlapDetector {	
	static String title = "OverlapDetector : ";
	static private Boolean[][] baseTable;
	private Boolean[][] table;
	
	
	public OverlapDetector(){
		reset();
	}
	
	public void reset(){
		this.table = new Boolean[7][24];		
		//TODO : if baseTable contain something, copy it
		//Boolean [i][j] ; i=0 -> Mon, i=1 ->Tue... ; j=0 -> 00:00 ... j=23 -> 23:00
		for(int i=0;i<7;i++){
			for(int j=0;j<24;j++){
				this.table[i][j]=false;// not used
			}
		}
	}
	
	public Boolean[][] getTable() {
		return table;
	}

	public void setTable(Boolean[][] table) {
		this.table = table;
	}

	public boolean set(String day,String starttime,String endtime){ // converting String item to the postion of array
		try{
			int dayint = FormatConventor.DayStr2Int(day);
			int start = FormatConventor.TimeStr2Int(starttime);
			int end = FormatConventor.TimeStr2Int(endtime);
			DebugMessager.debug(title+"set("+dayint+","+start+","+end+")");
			return set(dayint,start,end);
		}catch(Exception e){
			return false;
		}		
	}
	
	public boolean check(String day, String startitme,String Endtime){
		try{
			int dayint = FormatConventor.DayStr2Int(day);
			int start = FormatConventor.TimeStr2Int(startitme);
			int end = FormatConventor.TimeStr2Int(Endtime);
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
			if(this.table[day][i]==true){
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
			this.table[day][i]=true; // time slot used
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