package main;
import java.io.IOException;

public class SimpleDecoder {
	private String code;
	
	SimpleDecoder(String code){
		this.code=code;
	}
	
	
	//check the answer
	private boolean check(String key) {
		return code.equals(key);
	}
	
	private void addToExisting(String code) throws IOException {
		FileManager FM = new FileManager("existingCodes");
		FM.writeToFile(code);
		FM.close();
	}
	
	
public String attempt(String test) {
		
		if(check(test)) {
			
			return test + " is correct";
		}
		
		return test+ " is incorrect";
	}

}
