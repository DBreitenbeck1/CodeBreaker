package main;
import java.util.ArrayList;

public class KeyDivide {
	private ArrayList<ArrayList<String>> lists;
	private int numList;
	
	KeyDivide(ArrayList<String> key, int numList){
		this.lists = new ArrayList<>();
		this.numList=numList;
		int start =0;
		int sectionSize = key.size()/numList;
		
		int end = start+sectionSize;
	
		for(int i = 0;i<numList;i++) {
		this.lists.add(new ArrayList<String>(key.subList(start, end)));
		start+=sectionSize;
		end = start+sectionSize;
		}

		if (key.size()%numList!=0) {
			start = (key.size()-key.size()%numList);
			end = key.size();
			this.lists.add(new ArrayList<String>(key.subList(start, end)));
		}
	}
	
	
	public ArrayList<ArrayList<String>> getLists() {
		return this.lists;
	}
	
	public int getNumberLists() {
		return this.numList;
	}
	
	

}
