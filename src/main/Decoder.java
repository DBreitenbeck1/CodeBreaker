package main;
import tests.*;
import java.io.IOException;
import java.util.ArrayList;

import tests.Test;

public class Decoder {
	private String code;
	private ArrayList<ArrayList<String>> keyList;
	private int total; 
	private int steps;
	private boolean save = false;
	
	Decoder(String code, ArrayList<ArrayList<String>> list, int total){
		this.code =code;
		this.keyList=list;
		this.total=total;
	}
	
	
	public void enableSave() throws IOException {
		saveKeys();
		this.save=true;
	}
	
	public void addToExisting(String code) throws IOException {
		FileManager FM = new FileManager("existingCodes");
		FM.writeToFile(code);
		FM.close();
	}
	
	
	public void disableSave() {
		this.save=false;
	}
	
	//save Keys to file manager
	private void saveKeys() throws IOException {
		int count=1;
		for(ArrayList<String> list:keyList) {
			FileManager FM = new FileManager("Key"+String.valueOf(count), false);
			for(String L: list) {
				FM.writeToFile(L);
			}
			FM.close();
			count++;
		}
	}
	
	
	//check the answer
	private boolean check(String key) {
		return code.equals(key);
	}
	
	//Select a Random List
	private ArrayList<String> getRandomList(){
		
		ArrayList<ArrayList<String>> AL = new ArrayList<ArrayList<String>>(); 		
		if ((AL=listCycle())!=null) {
		//	System.out.println("AL size " + AL.size());
			if (AL.size()>1) {
				int randomList = (int)(Math.random()*AL.size());
			//	System.out.println("Random List " + randomList);
			//	System.out.println("Random List size " + AL.get(randomList).size());
				return AL.get(randomList);
			} else {
			//	System.out.println("List 0");
				return	AL.get(0);
			} 
		} else {
			return null;
		}
				
	}
	
	//Create a list of Lists (to avoid out-of-bound errors)
	private ArrayList<ArrayList<String>> listCycle() {
		//System.out.println("KL size " + keyList.size());
		ArrayList<ArrayList<String>> KL =new ArrayList<>();
		for(ArrayList<String> L:keyList) {
			if (L.size()>0) {
				KL.add(L);
			}
			
		}
		
		if(KL.size()!=0) {
		return KL;
		} else {
			return null;
		}
		
	}
	
	
	//factory method for creating tests
	public Test getTest(ArrayList<String>L, String Code, int select) {
		
		switch(select){
			case 1: 
				return new frontBack(L, code);
			case 2: 
				return new backFront(L, code);
			case 3:
				return new midUp(L,code);
			case 4: 
				return new midDown(L,code);
			case 5:
				return new random(L,code);
			default:
				System.out.println("invalid entry");
				return null;
		}
		
	}
	
	private String tests(ArrayList<String>L) {
		String answer;
		Test codeSearch; 
		codeSearch = new frontBack(L, code);
		for(int i = 1; i<6;i++) {
			if (L.size()>5) {
			codeSearch=getTest(L,code,i);
			if((answer=codeSearch.search(steps))!=null)
				{
				return answer;
				}
			} else if (L.size()>0) {
				codeSearch=new Simple(L, code);
				if((answer=codeSearch.search(steps))!=null)
				{
				return answer;
				}
			}
		}
		return null;
	}
	
	
	public String simpleRandom(int steps) {
		this.steps=steps;
		SimpleRandom SR = new SimpleRandom(getRandomList(), code);
		String answer = SR.search(steps);
		if (answer!=null) {
			return answer;
		}	
		return ("Not Found");
	}
		

	public String attempt(String test) {
		
		if(check(test)) {
			try {
				addToExisting(test);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return test + " is correct";
		}
		
		return test+ " is incorrect";
	}
	
	

	public String fullRundown(int steps) {
		this.steps=steps;
		String countReport = "";
		String test ="";
		String answer="";
		int count =0;
		while (count<total) {
			count++;
			ArrayList<String> L = new ArrayList<>();
			if((L = getRandomList())!=null) {		
					if((test=tests(L))!=null) {
						countReport= "Count is " + String.valueOf(count);
						answer="Answer is "+ test + "\n" + countReport;
						if(this.save) {
							try {
								addToExisting(test);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						return answer;
					} 
			} else {
				count=total;
			}
			
		}
		return "Not Found. Count is " + count;
		
	}
	
}
