package main_package;

public class Schuesse_Raumschiff_6 extends Schuesse{
private int yspeed;
	
	public Schuesse_Raumschiff_6(Gegner[] gegner,int xpos,int ypos, Score score,boolean test,Var var,int xplus,int ygesch) {
		super(var);
		schuss_xpos=xpos+xplus;
		schuss_ypos=ypos;
		schussSchaden = 15;
		speed = 20;
		leben=20;
		yspeed =ygesch;
		schuss_bild = Var.raumschiff_schuss6_Bild;
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
	
	public void setSchuss_xpos(){
		schuss_xpos +=speed;
		schuss_ypos +=yspeed;
	}
	
}

