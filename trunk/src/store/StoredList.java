package store;

import java.util.ArrayList;

public class StoredList {
	private ArrayList<StoredItem> items;
	private int priorityNums=-1;
	private Boolean[][] table;
	
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
