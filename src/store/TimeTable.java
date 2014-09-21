package store;

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
		int daypos;
		switch(day){
			case "Mon" : case "M" : daypos=0; break;
			case "Tue" : case "T" : daypos=1; break;
			case "Wed" : case "W" : daypos=2; break;
			case "Thu" : case "R" : daypos=3; break;
			case "Fri" : case "F" : daypos=4; break;
			case "Sat" : case "S" : daypos=5; break;
			case "Sun" :  daypos=6; break; // This may be unless, but keep it in the stage
			default : daypos=0; break; // normally unreachable
			
		}
		return set(daypos,Integer.parseInt(starttime)/100-1,Integer.parseInt(endtime)/100-1);
		
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
