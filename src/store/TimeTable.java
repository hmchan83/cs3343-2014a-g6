package store;

import Controller.FormatConventor;

/**
 * store.TimeTable
 * A time table used to mark the time slot is used or not
 * @author Marcus
 *
 */

public class TimeTable {

	private Boolean[][] table;
	
	
	public TimeTable(){
		reset();
	}
	
	public void reset(){
		this.table = new Boolean[7][24];
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
		return set(FormatConventor.DayStr2Int(day),FormatConventor.TimeStr2Int(starttime),FormatConventor.TimeStr2Int(endtime));
		
	}
	
	public boolean check(String day, String startitme,String Endtime){
		return this.check(FormatConventor.DayStr2Int(day), FormatConventor.TimeStr2Int(startitme), FormatConventor.TimeStr2Int(Endtime));
	}
	
	public boolean check(int day,int starttime, int endtime){
		//check
		for(int i=starttime;i<endtime;i++){
			if(this.table[day][i]==true) return false; // time slot overlap
		}
		return true;
	}
	
	public boolean set(int day,int starttime, int endtime){
		if(check(day,starttime,endtime)==false) return false; //check the time slot is available or not
		
		//set the timeslot is used
		for(int i=starttime;i<endtime;i++){
			this.table[day][i]=true; // time slot used
		}
		return true;
	}
	
	
	
}
