package main_package;

import javax.swing.JFrame;

public class Logik {
	
	Raumschiff raumschiff;
	Spieltimer spieltimer;
	MySQL_Datenbank mySQL_Datenbank;
	Gegner[] gegner_Array = new Gegner[Var.anzahlGegner];
	Var var =new Var();;
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
	 AudioPlayer audio;
	LevelTester levelTest;
	Level_Survival level_Survival;
	GUI_Ladescreen gUI_Ladescreen;
	Start_Counter start_Counter;
	
	Logik(){
		gUI_Ladescreen = new GUI_Ladescreen(true);
		levelTest=new LevelTester();
		mySQL_Datenbank = new MySQL_Datenbank();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}gUI_Ladescreen.dispose();
		start =new GUI_Startfenster(this, mySQL_Datenbank,var,levelTest,new JFrame());	
		
	}
	
	Logik(int reset, JFrame label_spielfeld){
		//audio.musikStoppen();
		raumschiff=null;
		spieltimer=null;
		mySQL_Datenbank=null;
		gegner_Array=null;
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
		levelTest =null;
		start_Counter=null;
		level_Survival=null;
		gUI_Ladescreen=null;	
		
		levelTest=new LevelTester();
		gegner_Array = new Gegner[Var.anzahlGegner];
		var.reset();
		mySQL_Datenbank = new MySQL_Datenbank();
		start =new GUI_Startfenster(this, mySQL_Datenbank,var,levelTest,label_spielfeld);
	}
	
	
	
	Logik(int reset,int weiter){
		raumschiff=null;
		spieltimer=null;
		mySQL_Datenbank=null;
		gegner_Array=null;
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
		levelTest =null;
		start_Counter=null;	
		level_Survival=null;
		gUI_Ladescreen=null;
		
		levelTest=new LevelTester();
		gegner_Array = new Gegner[Var.anzahlGegner];
		var.reset();
		mySQL_Datenbank = new MySQL_Datenbank();

		starten(var.name, var.raumschifftyp, null, var.level+1);
	}
	

	public void starten(String name,int raumschiffTyp,GUI_Startfenster fenster,int level){
		var.level=level;
		var.raumschifftyp=raumschiffTyp;
		Var.name = name;
		fenster.dispose();
		hintergrund=new Hintergrund(var);
	    start_Counter = new Start_Counter(var);
	    keyHandler = new KeyHandler(var);
	    score = new Score(level, raumschiffTyp,mySQL_Datenbank,var);
	    raumschiff_Level = new Raumschiff_Level(raumschiffTyp, score,var);
	    raumschiff = raumschiff_Level.gibRaumschiff();
	    raumschiff_Steuerung = new Raumschiff_Steuerung(raumschiff,var);
	    gegner_Level = new Gegner_Level(level,var);
	    gegner_Array = gegner_Level.getGegner_Array();
	    spieltimer = gegner_Level.getSpieltimer();
	    score.setSpieltimer(spieltimer);
	    for (int i = 0; i < gegner_Array.length; i++) {
	    	gegner_Array[i].setRaumschiff(raumschiff);
		}
	    raumschiff.setGegner(gegner_Array);
	    gegner_Kollision = new Gegner_Kollision(gegner_Level,raumschiff,var);
	    label_Spielfeld = new Label_Spielfeld(gegner_Level,raumschiff,score,spieltimer,var,start_Counter,this);
	    gui_spiel = new GUI_Spielfeld(label_Spielfeld,var);
	    schild = new Schild_Steuerung(raumschiff,var);
	    new ItemGenerator(raumschiff, var,level,levelTest);
	    if(Var.musik){
	    	audio = new AudioPlayer();
	    }
		var.startCounter = true;
	  }
	
	
	public void gewonnen(){
		levelTest.schreibeLevel(var.level+1);
	}
}
