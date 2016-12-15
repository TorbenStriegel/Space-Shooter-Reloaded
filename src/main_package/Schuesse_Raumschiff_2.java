package main_package;

public class Schuesse_Raumschiff_2 extends Schuesse {
	
	public Schuesse_Raumschiff_2(Gegner[] gegner,int xpos,int ypos, Score score,boolean test,Var var) {
		super(var);
		schuss_xpos=xpos;
		schuss_ypos=ypos;
		schussSchaden = 50;
		speed = 15;
		leben=80;
		schuss_bild = Var.raumschiff_schuss2_Bild;
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
