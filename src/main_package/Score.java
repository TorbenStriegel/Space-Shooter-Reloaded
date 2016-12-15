package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Score {
	private Timer timer_1, timer_2;
	private double aktuellerScore = 0;
	private int platzierung = 0;
	private double treffergenauigkeit = 100;
	private double schuesseDaneben = 0;
	private double schuesseGetroffen = 0;
	private int schuesseGesamt = 0;
	private boolean MySQL_hochgeladen = false;
	private MySQL_Datenbank mySQL_Datenbank;
	private int level = 0;
	private int raumschiffTyp = 0;
	private Var var ;
	private double finalscore;
	
	public Score(int level, int raumschiffTyp,MySQL_Datenbank mySQL_Datenbank,Var var) {
		this.level = level;
		this.var =var;
		this.raumschiffTyp = raumschiffTyp;
		this.mySQL_Datenbank = mySQL_Datenbank;
		timer_1 = new Timer();
		timer_1.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				schuesseGesamt = (int) (schuesseGetroffen + schuesseDaneben);
				if(schuesseGesamt != 0 && !var.verloren){
					treffergenauigkeit = (schuesseGetroffen/schuesseGesamt)*100;
				}
			}
		}, 0, 2000);
		
		timer_2 = new Timer();
		timer_2.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (var.verloren && !MySQL_hochgeladen && var.timer_finish){
					System.out.println("Wird in Score eingetragen");
					scoreEintragen();
					System.out.println("Platzierung wird berechnet");
					platzierungBerechnen();
					MySQL_hochgeladen=true;
				}
			}
		}, 0, 200);
	}


	public void setAktuellerScore(int aktuellerScoreAendernUm) {
		if(!var.verloren){
			aktuellerScore = aktuellerScore + aktuellerScoreAendernUm;
			finalscore = aktuellerScore;
		}
		
	}
	public void scoreEintragen(){
		mySQL_Datenbank.Werte_eintragen(raumschiffTyp, level, Var.name, getFinalScore(), getTreffergenauigkeit(), getSchuesseGetroffen());
	}
	public void erhoeheSchuesseGetroffen() {
		schuesseGetroffen++;
	}
	public void erhoeheSchussDaneben() {
		schuesseDaneben++;
	}
	
	public double getAktuellerScore() {
		return aktuellerScore;
	}
	public int getFinalScore() {
		return (int) (finalscore);
	}
	public int getTreffergenauigkeit() {
		return (int) treffergenauigkeit;
	}
	public int getSchuesseGetroffen() {
		return (int) schuesseGetroffen;
	}
	public int getSchuesseDaneben() {
		return (int) schuesseDaneben;
	}
	public void scoreAuslesen(int level){
		mySQL_Datenbank.Werte_auslesen(level);
	}
	public void platzierungBerechnen(){
		platzierung = mySQL_Datenbank.platzierungBerechnen(level,getFinalScore());
	}
	public String[] getHighscore_name() {
		return mySQL_Datenbank.getHighscore_name();
	}
	public String[] getHighscore_score() {
		return mySQL_Datenbank.getHighscore_score();
	}
	public String[] getHighscore_treffergenauigkeit() {
		return mySQL_Datenbank.getHighscore_treffergenauigkeit();
	}
	public String[] getHighscore_vernichteteGegner() {
		return mySQL_Datenbank.getHighscore_vernichteteGegner();
	}
	public int getPlatzierung() {
		return platzierung;
	}
}
