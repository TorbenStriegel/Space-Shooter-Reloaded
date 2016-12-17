package main_package;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LevelTester {
	
	private Scanner scanner;
    private int levelfrei=0;
    private FileWriter writer;
    private File file;
    
  
    
	public LevelTester() {
		
		 try {
			 
			scanner = new Scanner(new File("data.txt"));
		 	} catch (FileNotFoundException e) {
		 	}
		 
		 
		 scannen();
		
	}

	public void scannen(){
		while (scanner.hasNext()) {
			String a =scanner.next();
			levelfrei=Integer.parseInt(a);
		}
		scanner.close();
	}
	
	
	public boolean freigeschaltet(int level){
		if(level>levelfrei){
			return false;
		}
		return true;
		
		
	}
	
	public void schreibeLevel(int i){
		try {
			writer = new FileWriter(new File("data.txt"));
			writer.write(i+"");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getlevelfrei(){
		return levelfrei;
	}
	
	
}
