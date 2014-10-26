package store;

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
				this.table[i][j]=false;
			}
		}
	}
	public void setTable(Boolean[][] table) {
		this.table = table;
	}
	public void set(int i,int j){
		this.table[i][j]=true;
	}
	public Boolean[][] getTable(){
		return table;
	}
	public Boolean get(int i,int j){
		return table[i][j];
	}
}