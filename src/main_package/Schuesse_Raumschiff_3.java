package main_package;

public class Schuesse_Raumschiff_3 extends Schuesse{

	public Schuesse_Raumschiff_3(Gegner[] gegner,int xpos,int ypos, Score score,boolean test) {
		super();
		schuss_xpos=xpos;
		schuss_ypos=ypos;
		schussSchaden = 30;
		speed = 15;
		leben=10;
		schuss_bild = Var.raumschiff_schuss3_Bild;
		if (!test) {
			steuerung = new Schuesse_Raumschiff_Steuerung(this, gegner, score);
		}else{
			Var.geschossliste.remove(this);
		}
		
	}
	
	public void zerstoeren(){
		steuerung.zerstoeren();
		steuerung=null;
	}
	
}
