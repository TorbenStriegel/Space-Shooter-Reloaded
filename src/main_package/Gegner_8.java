package main_package;

public class Gegner_8 extends Gegner {

	public Gegner_8() {
		super();
		leben_default = 20;
		leben = leben_default;
		kollisionsSchaden = 5;
		xspeed = -2;
		yspeed = 0;
		schuss = true;
		gegner_bild = Var.gegner_8;
		schuss_periode=100+(int)(Math.random()*400);
	
		
	}
	public void schiessen(){
		new Schuesse_Gegner_4(schiff, this.xpos, this.ypos+this.gegner_bild.getHeight()/2-Var.gegner_schuss1_Bild.getHeight()/2);
		
	}
	
	
	
}
