package main_package;

public class Schuesse_Raumschiff_4 extends Schuesse{

	public Schuesse_Raumschiff_4(Gegner[] gegner,int xpos,int ypos, Score score,boolean test) {
		super();
		schuss_xpos=xpos;
		schuss_ypos=ypos;
		schussSchaden = 70;
		speed = 15;
		leben=30;
		schuss_bild = Var.raumschiff_schuss4_Bild;
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
