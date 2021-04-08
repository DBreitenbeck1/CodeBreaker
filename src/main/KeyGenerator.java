package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class KeyGenerator {
	private ArrayList<String> Key;	
	private FileManager FM; 
	
	KeyGenerator (String[]list) throws IOException {
		Key=new ArrayList<>(Arrays.asList(list));
		FM = new FileManager("existingCodes");
	}
	
	KeyGenerator (ArrayList<String> L) throws IOException{
		Key=new ArrayList<>(L);
		FM = new FileManager("existingCodes");
	}
	
	
	private ArrayList<String> addToKey(ArrayList<String> newList){
		// 
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i<Key.size();i++) {
			for(String L:newList) {
				list.add(Key.get(i)+L);
				
			}
		}
		
		return list;
	}
	
	public void generateKey(int size, ArrayList<String> newList){
		for(int i = 1;i<size;i++) {
			this.Key=addToKey(newList);
		}
		
		
	}
	
	public void clearExisting() throws IOException {
		String line;
		while ((line=FM.readFile())!=null) {
		if(Key.contains(line)) {
			Key.remove(line);
		}
		}
	}
		
	
	public void saveKey(String filename) throws IOException {
		FileManager fileManager =new FileManager(filename);
		for (String K:Key) {
			fileManager.writeToFile(K);
		}
		
		fileManager.close();
	}
	
	public void replaceKey(String filename) throws IOException {
		FileManager fileManager =new FileManager(filename, false);
		for (String K:Key) {
			fileManager.writeToFile(K);
		}
		
		fileManager.close();
	}
	
	public void setKey(ArrayList<String> newList) {
		this.Key=newList;
	}
	
	public ArrayList<String> getKey(){
		return this.Key;
	}
	
	public int getSize() {
		return Key.size();
	}
			

	
	
}

