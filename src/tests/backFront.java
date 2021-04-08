package tests;

import java.util.ArrayList;

public class backFront extends Test {
	String[] wrong;

	public backFront(ArrayList<String> list, String code) {
		super(list, code);
	}

	public String search(int steps) {
		this.wrong = new String[steps];
		
		int wrongCount = 0;
		int size=list.size()-1;
		int backSteps = (size-steps>0) ? size-steps:  0; 
		
		for (int i=size; i>backSteps;i--) {
			try {
				//System.out.println("backFront " + list.get(i) + " " + i);
				if(check(list.get(i))==true) {
					return (list.get(i));
				}else {
					wrong[wrongCount] = list.get(i);
					wrongCount++;

				}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Back Out of Bounds: index "
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
