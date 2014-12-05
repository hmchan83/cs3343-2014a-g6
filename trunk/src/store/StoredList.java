package store;

import java.util.ArrayList;

public class StoredList {
	private ArrayList<StoredItem> items;
	private int priorityNums;
	private int handledCourse;
	private TimeTable table;
	private int totalCredits;
	
	public StoredList(){
		this.setItems(new ArrayList<StoredItem>());
		this.setTable(new TimeTable());
		//Boolean [i][j] ; i=0 -> Mon, i=1 ->Tue... ; j=0 -> 00:00 ... j=23 -> 23:00
		this.setPriorityNums(-1);
		this.setTotalCredits(0);
		this.setHandledCourse(0);
	}
	
	public StoredList(int ahandledCourse){
		this.setItems(new ArrayList<StoredItem>());
		this.setTable(new TimeTable());
		//Boolean [i][j] ; i=0 -> Mon, i=1 ->Tue... ; j=0 -> 00:00 ... j=23 -> 23:00
		this.setPriorityNums(-1);
		this.setTotalCredits(0);
		this.setHandledCourse(ahandledCourse);
	}
	
	public ArrayList<StoredItem> getItems() {
		return items;
	}
	public void add(StoredItem item,TimeTable table){
		items.add(item);
		this.totalCredits+=item.getSec().getCredit();
		this.table = table;
	}
	public void setItems(ArrayList<StoredItem> items) {
		this.items = items;
	}
	public int getPriorityNums() {
		if(priorityNums==-1)calPriorityNums();
		return priorityNums;
	}
	public void setPriorityNums(int priorityNums) {
		this.priorityNums = priorityNums;
	}
	public void calPriorityNums(){
		int totalPriority=0;
		for(StoredItem item : items){
			totalPriority+=item.getSec().getPriority();
		}
		this.priorityNums=totalPriority;
	}
	public TimeTable getTable() {
		return table;
	}
	public void setTable(TimeTable table) {
		this.table = table;
	}
	public String toString(){
		String str="{";
		for(int i=0;i<items.size();i++){
			if(i>0)str+=",";
			str+="["+items.get(i).toString()+"]";
		}
		str+="}";
		return str;
	}
	public String printTable(){
		return table.printTable();
	}

	public int getHandledCourse() {
		return handledCourse;
	}

	public void setHandledCourse(int handledCourse) {
		this.handledCourse = handledCourse;
	}

	public int getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(int totalCredits) {
		this.totalCredits = totalCredits;
	}
	
	public void addCredits(int n){
		this.totalCredits+=n;
	}
	public int getItemNums(){
		return items.size();
	}
	
}
