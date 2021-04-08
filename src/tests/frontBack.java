package tests;

import java.util.ArrayList;

public class frontBack extends Test {


	public frontBack(ArrayList<String> list, String code) {
		super(list, code);
	}

	public String search(int steps) {
		this.wrong = new String[steps];
		int start=0;
		for (int i=start; i<start+steps;i++) {
			try {	
			//	System.out.println("frontBack " + list.get(i) + " " + i);
				if(check(list.get(i))==true) {
					return (list.get(i));
				}else {
					wrong[i] = list.get(i);
					
				}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Front Out of Bounds: index "
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
