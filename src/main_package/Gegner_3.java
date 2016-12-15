package main_package;

public class Gegner_3 extends Gegner {
	
	public Gegner_3(Var var) {
		super(var);
		leben_default = 20;
		leben = leben_default;
		kollisionsSchaden = 5;
		xspeed = -4;
		yspeed = 0;
		schuss = true;
		gegner_bild = Var.gegner_3;
		schuss_periode=200+(int)(Math.random()*600);
	
		
	}
	public void schiessen(){
		new Schuesse_Gegner_1(schiff, this.xpos, this.ypos+this.gegner_bild.getHeight()/2-Var.gegner_schuss1_Bild.getHeight()/2,var);
		
	}
	
	public void bewegen_y() {
			ypos=(int)(Math.sin((xpos/15)*(0.15))*5)+ypos;
	}
	
	
	
}
