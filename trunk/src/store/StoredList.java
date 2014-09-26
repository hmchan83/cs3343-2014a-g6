package store;

import java.util.ArrayList;

public class StoredList {
	private ArrayList<StoredItem> items;
	private int priorityNums;
	
	public ArrayList<StoredItem> getItems() {
		return items;
	}
	public void setItems(ArrayList<StoredItem> items) {
		this.items = items;
	}
	public int getPriorityNums() {
		return priorityNums;
	}
	public void setPriorityNums(int priorityNums) {
		this.priorityNums = priorityNums;
	}
	
	
}
