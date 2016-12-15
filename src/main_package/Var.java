package main_package;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class Var {
	
	static int spielfeld_screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;  	// Fragt Weite vom Bildschirm ab
	static int spielfeld_screenheight = Toolkit.getDefaultToolkit().getScreenSize().height; // Fragt Höhe vom Bildschirm ab
	
	static final String background_1_Bildpfad = "Bilder/hintergrund.jpg";
	 
	static int schuessegegner=0;
	
	static final String raumschiff_1_Bildpfad = "Bilder/ship_1.png";
	static final String raumschiff_2_Bildpfad = "Bilder/ship_2.png";
	static final String raumschiff_3_Bildpfad = "Bilder/ship_3.png";
	static final String raumschiff_4_Bildpfad = "Bilder/ship_4.png";
	
	static final String gegner_1_Bildpfad = "Bilder/gegner_1.png";
	static final String gegner_2_Bildpfad = "Bilder/gegner_2.png";
	static final String gegner_3_Bildpfad = "Bilder/gegner_3.png";
	static final String gegner_4_Bildpfad = "Bilder/gegner_4.png";
	static final String gegner_5_Bildpfad = "Bilder/gegner_5.png";
	static final String gegner_6_Bildpfad = "Bilder/gegner_6.png";
	static final String gegner_7_Bildpfad = "Bilder/gegner_7.png";
	static final String gegner_8_Bildpfad = "Bilder/gegner_8.png";
	
	static final String gegner_schuss1_Bildpfad = "Bilder/schuss_gegner_1.png";
	static final String gegner_schuss2_Bildpfad = "Bilder/schuss_gegner_2.png";
	static final String gegner_schuss3_Bildpfad = "Bilder/schuss_gegner_3.png";
	static final String gegner_schuss4_Bildpfad = "Bilder/schuss_gegner_4.png";
	
	
	static final String raumschiffshield_1_Bildpfad = "Bilder/shield_1.png";
	
	static final String raumschiff_schuss1_Bildpfad = "Bilder/schuss_ship_1.png";
	static final String raumschiff_schuss2_Bildpfad = "Bilder/schuss_ship_2.png";
	static final String raumschiff_schuss3_Bildpfad = "Bilder/schuss_ship_3.png";
	static final String raumschiff_schuss4_Bildpfad = "Bilder/schuss_ship_4.png";
		
	static String musik_default = "Musik/musik_Star_Wars.wav";
	static final String musik_1 = "Musik/musik_standart.wav";
	static final String musik_2 = "Musik/musik_Star_Wars.wav";
	static final String musik_3 = "Musik/musik_Pirates_of_the_Caribbean.wav";
	static final String musik_4 = "Musik/musik_The_Dark_Knight_Rises.wav";
	
	static BufferedImage background_1,background_2; //Hintergrund

	static BufferedImage gegner_1,gegner_2,gegner_3,gegner_4,gegner_5,gegner_6,gegner_7,gegner_8;
	static BufferedImage raumschiff_1,raumschiff_2,raumschiff_3,raumschiff_4;
	static BufferedImage raumschiffshield_1_Bild;
	static BufferedImage raumschiff_schuss1_Bild,raumschiff_schuss2_Bild,raumschiff_schuss3_Bild,raumschiff_schuss4_Bild;
	static BufferedImage gegner_schuss1_Bild, gegner_schuss2_Bild, gegner_schuss3_Bild,gegner_schuss4_Bild;
	
	static int background_x1 = 0,background_x2 = Toolkit.getDefaultToolkit().getScreenSize().width; 
	static int background_speed = 40;
	
	static ArrayList<Schuesse> geschossliste= new ArrayList<Schuesse>();
	
	static String name = "Error";
	
	static int anzahlGegner = 0;
	
	static boolean pause = false;
	static boolean verloren = false;
	static boolean timer_finish = false;
	static boolean musik = true;
	
	static boolean moveup=false,movedown=false,moveright=false,moveleft=false,space=false,esc=false;
	
	public Var(){
		//reset();
		try{
			background_1 = ImageIO.read(new File(background_1_Bildpfad));
			background_2 = ImageIO.read(new File(background_1_Bildpfad));
			System.out.println("Hintergrund geladen");
			gegner_1 = ImageIO.read(new File(gegner_1_Bildpfad));
			gegner_2 = ImageIO.read(new File(gegner_2_Bildpfad));
			gegner_3 = ImageIO.read(new File(gegner_3_Bildpfad));
			gegner_4 = ImageIO.read(new File(gegner_4_Bildpfad));
			gegner_5 = ImageIO.read(new File(gegner_5_Bildpfad));
			gegner_6 = ImageIO.read(new File(gegner_6_Bildpfad));
			gegner_7 = ImageIO.read(new File(gegner_7_Bildpfad));
			gegner_8 = ImageIO.read(new File(gegner_8_Bildpfad));
			System.out.println("Gegner geladen");
			raumschiff_1 = ImageIO.read(new File(raumschiff_1_Bildpfad));
			raumschiff_2 = ImageIO.read(new File(raumschiff_2_Bildpfad));
			raumschiff_3 = ImageIO.read(new File(raumschiff_3_Bildpfad));
			raumschiff_4 = ImageIO.read(new File(raumschiff_4_Bildpfad));
			raumschiffshield_1_Bild=ImageIO.read(new File(raumschiffshield_1_Bildpfad));
			System.out.println("Raumschiffe geladen");
			raumschiff_schuss1_Bild = ImageIO.read(new File(raumschiff_schuss1_Bildpfad));
			raumschiff_schuss2_Bild = ImageIO.read(new File(raumschiff_schuss2_Bildpfad));
			raumschiff_schuss3_Bild = ImageIO.read(new File(raumschiff_schuss3_Bildpfad));
			raumschiff_schuss4_Bild = ImageIO.read(new File(raumschiff_schuss4_Bildpfad));
			System.out.println("Schüsse Raumschiff geladen");
			gegner_schuss1_Bild = ImageIO.read(new File(gegner_schuss1_Bildpfad));
			gegner_schuss2_Bild = ImageIO.read(new File(gegner_schuss2_Bildpfad));
			gegner_schuss3_Bild = ImageIO.read(new File(gegner_schuss3_Bildpfad));
			gegner_schuss4_Bild = ImageIO.read(new File(gegner_schuss4_Bildpfad));
			System.out.println("Schüsse Gegener geladen");
		}catch (IOException fehlermeldung){
			fehlermeldung.printStackTrace();
			System.out.println("Bilder nicht gefunden!!! (Var)");
		}
	}
	
	
	
	/*public void reset(){
		schuessegegner=0;
		background_x1 = 0;
		background_x2 = Toolkit.getDefaultToolkit().getScreenSize().width; 
	    background_speed = 40;
		
	    geschossliste= new ArrayList<Schuesse>();
		
		 name = "Error";
		
		 anzahlGegner = 0;
		
		 pause = false;
		 verloren = false;
		 timer_finish = false;
		 musik = true;
	}*/
}
