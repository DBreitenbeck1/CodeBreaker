package main;

public class CodeGen {

	char[] list = {'1','2','3','4','5','6','7','8','9','0'};
	String code= "";
	
	
	
	
	CodeGen(int length){
		
		for(int i = 0; i<length; i++) {
		int rand = (int)(Math.random()*list.length);
		code+=list[rand];
		}
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	
	
}
