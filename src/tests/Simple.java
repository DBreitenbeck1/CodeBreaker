package tests;

import java.util.ArrayList;

public class Simple extends Test {
	
	public Simple(ArrayList<String> list, String code) {
		super(list, code);
		// TODO Auto-generated constructor stub
	}

	public String search(){
		String test = null;
		for (String s:list) {
			if(check(s)==true) {
			//	System.out.println("simple " + s);
				test=(s);
				return test;
			}
		}
		list.clear();
		return test;
	}

}
