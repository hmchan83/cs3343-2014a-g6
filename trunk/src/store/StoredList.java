package store;

import java.util.ArrayList;

public class StoredList {
	private ArrayList<StoredItem> items;
	private int priorityNums;
	private Boolean[][] table;
	
	public StoredList(){
		this.items = new ArrayList<StoredItem>();
		this.table = new Boolean[7][24];
		//Boolean [i][j] ; i=0 -> Mon, i=1 ->Tue... ; j=0 -> 00:00 ... j=23 -> 23:00
		for(int i=0;i<7;i++){
			for(int j=0;j<24;j++){
				this.table[i][j]=false;// not used
			}
		}
		this.priorityNums=-1;
	}
	
	public ArrayList<StoredItem> getItems() {
		return items;
	}
	public void add(StoredItem item){
		items.add(item);
	}
	public void setItems(ArrayList<StoredItem> items) {
		this.items = items;
	}
	public int getPriorityNums() {
		return priorityNums;
	}
	public void setPriorityNums(int priorityNums) {
		if(this.priorityNums==-1){
			calPriorityNums();
		}
		this.priorityNums = priorityNums;
	}
	public void calPriorityNums(){
		int totalPriority=0;
		for(StoredItem item : items){
			totalPriority+=item.getSec().getPriority();
		}
		this.priorityNums=totalPriority;
	}
	public Boolean[][] getTable() {
		return table;
	}
	public void setTable(Boolean[][] table) {
		this.table = table;
	}
	public String toString(){
		String str="";
		for(StoredItem item : items){
			str+="{"+item.toString()+"},";
		}
		return str;
	}
	
}
