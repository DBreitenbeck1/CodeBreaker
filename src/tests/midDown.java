package tests;

import java.util.ArrayList;

public class midDown extends Test {


	public midDown(ArrayList<String> list, String code) {
		super(list, code);
		// TODO Auto-generated constructor stub
	}
	
	public String search(int steps) {
		wrong = new String[steps];
		int wrongCount = 0;
		int mid=list.size()/2;
		int backSteps = (mid-steps>0) ? mid-steps:  0; 
		for (int i=mid; i>backSteps;i--) {
			try {
			//	System.out.println("midDown " + list.get(i) + " " + i);
			if(check(list.get(i))==true) {
				
				return (list.get(i));
			}else {
				wrong[wrongCount] = list.get(i);
				wrongCount++;
			}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Middown Out of Bounds: index "
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
