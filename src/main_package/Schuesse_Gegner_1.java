package main_package;

public class Schuesse_Gegner_1 extends Schuesse{

	public Schuesse_Gegner_1(Raumschiff schiff,int xpos,int ypos) {
		super();
		schuss_xpos=xpos;
		schuss_ypos=ypos;
		schussSchaden = 20;
		speed = -20;
		leben=1;
		schuss_bild = Var.gegner_schuss1_Bild;
		steuerung_gegner = new Schuesse_Gegner_Steuerung(this, schiff);
	}

	public void zerstoeren(){
		steuerung_gegner.zerstoeren();
		steuerung_gegner=null;
	}
	
	
}
