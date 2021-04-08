package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class CodeBreaker {

	public static void main(String[] args) throws IOException {
	//A program for deciphering numeric or alphanumeric codes with no 
		//information or input from the code

		FileManager FM = new FileManager("Characters");
		KeyGenerator key=new KeyGenerator(FM.readToNumArray());
			
		key.generateKey(3, key.getKey());
		
		
		KeyDivide KD = new KeyDivide(key.getKey(),2);
		
		ArrayList<ArrayList<String>> keyLists = KD.getLists();
		
		Decoder DC = new Decoder("182",keyLists,key.getSize());
		
		System.out.println(DC.fullRundown(2));
	
		
	}

}
