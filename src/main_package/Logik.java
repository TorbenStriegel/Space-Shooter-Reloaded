package main_package;

public class Logik {
	
	Raumschiff raumschiff;
	Spieltimer spieltimer;
	MySQL_Datenbank mySQL_Datenbank;
	Gegner[] gegner_Array = new Gegner[Var.anzahlGegner];
	Var var;
	GUI_Startfenster start;
	Hintergrund hintergrund;
	KeyHandler keyHandler;
	Raumschiff_Level raumschiff_Level;
	Score score;
	Raumschiff_Steuerung raumschiff_Steuerung;
	 Gegner_Level gegner_Level;
	 Gegner_Kollision gegner_Kollision;
	 Label_Spielfeld label_Spielfeld;
	 Schild_Steuerung schild ;
	 GUI_Spielfeld gui_spiel;
	 AudioPlayer audio ;
	
	
	
	Logik(){
		var =new Var();
		mySQL_Datenbank = new MySQL_Datenbank();
		start =new GUI_Startfenster(this, mySQL_Datenbank);
		
	}
	
	/*Logik(int reset){
		raumschiff=null;
		spieltimer=null;
		mySQL_Datenbank=null;
		gegner_Array=null;
		var=null;
		start=null;
		hintergrund=null;
		keyHandler=null;
		raumschiff_Level=null;
		score=null;
		raumschiff_Steuerung=null;
		gegner_Level=null;
		gegner_Kollision=null;
		label_Spielfeld=null;
		schild =null;
		gui_spiel=null;
		audio =null;
		
		System.gc();
			
		
		
		gegner_Array = new Gegner[Var.anzahlGegner];
		var =new Var();
		mySQL_Datenbank = new MySQL_Datenbank();
		start =new GUI_Startfenster(this, mySQL_Datenbank);
		
	}*/
	

	public void starten(String name,int raumschiffTyp,GUI_Startfenster fenster,int level){
		Var.name = name;

	    hintergrund=new Hintergrund();
	    keyHandler = new KeyHandler();
	    score = new Score(level, raumschiffTyp,mySQL_Datenbank);
	    raumschiff_Level = new Raumschiff_Level(raumschiffTyp, score);
	    raumschiff = raumschiff_Level.gibRaumschiff();
	    raumschiff_Steuerung = new Raumschiff_Steuerung(raumschiff);
	    gegner_Level = new Gegner_Level(level);
	    gegner_Array = gegner_Level.getGegner_Array();
	    spieltimer = gegner_Level.getSpieltimer();
	    for (int i = 0; i < gegner_Array.length; i++) {
	    	gegner_Array[i].setRaumschiff(raumschiff);
		}
	    raumschiff.setGegner(gegner_Array);
	    gegner_Kollision = new Gegner_Kollision(gegner_Level,raumschiff);
	    label_Spielfeld = new Label_Spielfeld(gegner_Level,raumschiff,score,spieltimer);
	    gui_spiel = new GUI_Spielfeld(label_Spielfeld);
	    schild = new Schild_Steuerung(raumschiff);
	    if(Var.musik){
	    	audio = new AudioPlayer();
	    }
	    fenster.dispose();
	  }
}
