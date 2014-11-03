package store;


public class TimeTable implements Cloneable{
	private Boolean[][] tableContents;
	
	
	public TimeTable(){
		reset();
	}
	public TimeTable(Boolean[][] aTable){
		this.tableContents = aTable;
	}
	
	public void reset(){
		this.tableContents = new Boolean[7][24];	
		
		//Boolean [i][j] ; i=0 -> Mon, i=1 ->Tue... ; j=0 -> 00:00 ... j=23 -> 23:00
		for(int i=0;i<7;i++){
			for(int j=0;j<24;j++){
				this.tableContents[i][j]=false;
			}
		}
	}
	public void setTableContents(Boolean[][] table) {
		this.tableContents = table;
	}
	public void setTableContents(int i,int j){
		this.tableContents[i][j]=true;
	}
	public Boolean[][] getTableContents(){
		return tableContents;
	}
	public Boolean getTableContents(int i,int j){
		return tableContents[i][j];
	}
	public String printTable(){
		String str = "";
		for(int i=0;i<7;i++){
			if(i>0)str+=",";
			str += "\n\t\t\tday="+(i)+" : {";
			for(int j=0;j<24;j++){
				if(j>0)str+=",";
				str +=tableContents[i][j];
			}
			str += "}";
		}
		return str;
	}
	public TimeTable clone() {
		Boolean[][] newTable = new Boolean[7][24];
		for(int i =0;i<7;i++){
			for(int j=0;j<24;j++){
				if(this.getTableContents(i, j)==true) newTable[i][j]=true;
				else newTable[i][j]=false;
			}
		}
		return new TimeTable(newTable);
	}
}