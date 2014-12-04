package store;

/**
 * a time table used for storing the status of time slot
 * @author Marcus
 *
 */
public class TimeTable implements Cloneable{
	private Boolean[][] tableContents;
	public static final Boolean USED = true;
	public static final Boolean AVALIBALE = false;
	
	
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
				this.tableContents[i][j]=TimeTable.AVALIBALE;
			}
		}
	}
	public void setTableContents(Boolean[][] table) {
		this.tableContents = table;
	}
	public void setTableContents(int i,int j){
		this.tableContents[i][j]=TimeTable.USED;
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
				if(this.getTableContents(i, j)==TimeTable.USED) newTable[i][j]=TimeTable.USED;
				else newTable[i][j]=TimeTable.AVALIBALE;
			}
		}
		return new TimeTable(newTable);
	}
}