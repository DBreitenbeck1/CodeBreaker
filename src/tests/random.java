package tests;

import java.util.ArrayList;

public class random extends Test {
	

	public random(ArrayList<String> list, String code) {
		super(list, code);
		// TODO Auto-generated constructor stub
	}
	
	public String search(int steps) {
		wrong = new String[steps];
		int rand = generateRandom();
		int wrongCount = 0;
		if(check(list.get(rand))==true) {
			return list.get(rand);
		} else {
			wrong[wrongCount] = list.get(rand);
			wrongCount++;
		}

		String extra;
		if((extra = randomPlus(rand, steps)) !=null) {
			return extra;
		}
	
		for(String w: wrong) {
			removeWrongAnswer(w);
		}
		
		return null;
	}
	
	
	private String randomPlus(int rand, int steps) {
		wrong = new String[steps];
		int wrongCount = 0;
		steps = steps/2;
		int backSteps = (rand-steps>0) ? rand-steps:  0;
		int frontSteps =(rand+steps<list.size()) ? rand+steps:  list.size();
		
		for (int i=rand; i>backSteps;i--) {
			try {
			//	System.out.println("random down " + list.get(i) + " " + i);
			if(check(list.get(i))==true) {
				
				return (list.get(i));
			}else {
				wrong[wrongCount] = list.get(i);
				wrongCount++;
			}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Random Down Out of Bounds: index "
			+ i + " of " + list.size());
				continue;
			}
		}
		
		for (int i=rand; i<frontSteps;i++) {
			try {
			//	System.out.println("random up " + list.get(i) + " " + i);
			if(check(list.get(i))==true) {
				
				return (list.get(i));
			}else {
				wrong[wrongCount] = list.get(i);
				wrongCount++;
			}
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Random Up Out of Bounds: index "
			+ i + " of " + list.size());
				continue;
			}
		}
		
		for(String w: wrong) {
			removeWrongAnswer(w);
		}
		
		
		return null;
	}
	
	
	private int generateRandom() {
		int rand = (int)(Math.random()*list.size());
		return rand;
	}
	

}
