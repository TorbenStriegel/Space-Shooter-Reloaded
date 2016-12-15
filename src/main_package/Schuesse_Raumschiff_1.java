package main_package;

public class Schuesse_Raumschiff_1 extends Schuesse{
	
	public Schuesse_Raumschiff_1(Gegner[] gegner,int xpos,int ypos, Score score,boolean test,Var var) {
		super(var);
		schuss_xpos=xpos;
		schuss_ypos=ypos;
		schussSchaden = 20;
		speed =30;
		leben=1;
		schuss_bild = Var.raumschiff_schuss1_Bild;
		if (!test) {
			steuerung = new Schuesse_Raumschiff_Steuerung(this, gegner, score,var);
		}else{
			var.getGeschossliste().remove(this);
		}
	}
	
	public void zerstoeren(){
		steuerung.zerstoeren();
		steuerung=null;
	}
	
}
