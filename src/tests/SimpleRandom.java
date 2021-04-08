package tests;

import java.util.ArrayList;

public class SimpleRandom extends Test {


	public SimpleRandom(ArrayList<String> list, String code) {
		super(list, code);
		// TODO Auto-generated constructor stub
	}

	public String search(int steps) {
		int rand;
		wrong = new String[steps];
		int wrongCount = 0;
		String answer;
		for(int i = 0; i<steps;i++) {
			rand = generateRandom();
			answer = list.get(rand);
			if(check(answer)){
				return answer;}
			else {
				wrong[wrongCount] = answer;
				wrongCount++;
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
