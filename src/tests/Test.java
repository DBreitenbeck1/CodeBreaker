package tests;
import main.FileManager;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Test {
	ArrayList<String> list;
	String code;
	String[] wrong;
	
	public Test(ArrayList<String> list, String code) {
		this.list=list;
		this.code=code;
	}
	
	public boolean check(String answer) {
		return code.equals(answer);
	}
	
	public String search(int steps) {
		
		return null;
	}
	
	public void addToExisting(String code) throws IOException {
		FileManager FM = new FileManager("existingCodes");
		FM.writeToFile(code);
		FM.close();
	}
	
	//remove incorrect answer
		protected void removeWrongAnswer(String answer) {
			list.remove(answer);
		}
	

	
	
}
