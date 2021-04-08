package tests;

import java.util.ArrayList;

public class midUp extends Test {
	String[] wrong;

	public midUp(ArrayList<String> list, String code) {
		super(list, code);
		// TODO Auto-generated constructor stub
	}
	
	public String search(int steps) {
		wrong = new String[steps];
		int wrongCount = 0;
		int mid=list.size()/2;
		int upSteps = (mid+steps<=list.size()) ? mid+steps: list.size(); 
		for (int i=mid; i<upSteps;i++) {
			try {
			//System.out.println("midUp " + list.get(i) + " " + i);
			if(check(list.get(i))==true) {
				return (list.get(i));
			}else {
				wrong[wrongCount] = list.get(i);
				wrongCount++;
			}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Midup Out of Bounds: index " 
			+ i + " of " + list.size());
				continue;
			}
		}
			for(String w: wrong) {
				removeWrongAnswer(w);
			}
			
		return null;
	}
	
	

}
