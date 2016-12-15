package main_package;

public class Schuesse_Gegner_3 extends Schuesse{

	public Schuesse_Gegner_3(Raumschiff schiff,int xpos,int ypos) {
		super();
		schuss_xpos=xpos;
		schuss_ypos=ypos;
		schussSchaden = 80;
		speed = -30;
		leben=1;
		schuss_bild = Var.gegner_schuss3_Bild;
		steuerung_gegner = new Schuesse_Gegner_Steuerung(this, schiff);
	}

	public void zerstoeren(){
		steuerung_gegner.zerstoeren();
		steuerung_gegner=null;
	}
	
}
