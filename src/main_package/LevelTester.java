package main_package;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LevelTester {
	
	private Scanner scanner;
    private int levelfrei=0;
    private FileWriter writer;
    private int schifffrei =0;
    
  
    
	public LevelTester() {
		scannen();
	}

	public void scannen(){
		 try {
			 
				scanner = new Scanner(new File(".data.txt"));
			 
		while (scanner.hasNext()) {
			String a =scanner.next();
			if(a.equals("Level")){
				String s = scanner.next();
				levelfrei=Integer.parseInt(s);
			}
			
			if(a.equals("Schiff")){
				String s = scanner.next();
				schifffrei=Integer.parseInt(s);
			}
			
		}
		scanner.close();
		} catch (FileNotFoundException e) {
		}
	}
	
	
	public boolean freigeschaltet(int level){
		if(level>levelfrei){
			return false;
		}
		return true;
		
		
	}
	
	public boolean freigeschaltetSchiff(int schiff){
		if(schiff>schifffrei){
			return false;
		}
		return true;
		
		
	}
	
	public void schreibeLevel(int i){
		if(i>levelfrei){
		try {
			writer = new FileWriter(new File(".data.txt"));
			
			for (int j = 0; j < 1000; j++) {
				writer.write((char)(Math.random()*100)+" ");
			}
			writer.write("Level "+i+" ");
			for (int j = 0; j < 1000; j++) {
				writer.write((char)(Math.random()*100)+" ");
			}
			writer.write("Schiff "+schifffrei+" ");
			for (int j = 0; j < 1000; j++) {
				writer.write((char)(Math.random()*100)+" ");
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		scannen();
		
	}
	
	public void schreibeSchiff(int i){
		try {
			writer = new FileWriter(new File(".data.txt"));
			for (int j = 0; j < 1000; j++) {
				writer.write((char)(Math.random()*100)+" ");
			}
			writer.write("Level "+levelfrei+" ");
			for (int j = 0; j < 1000; j++) {
				writer.write((char)(Math.random()*100)+" ");
			}
			writer.write("Schiff "+i+" ");
			for (int j = 0; j < 1000; j++) {
				writer.write((char)(Math.random()*100)+" ");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scannen();
		
	}
	
	
	public int getlevelfrei(){
		return levelfrei;
	}
	
	public int getSchifffrei(){
		return schifffrei;
	}
	
	
}
