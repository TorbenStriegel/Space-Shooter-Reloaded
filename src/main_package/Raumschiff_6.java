package main_package;

public class Raumschiff_6 extends Raumschiff {

	public Raumschiff_6(Score score,boolean test,Var var) {
		super(var);
		raumschiff_speedx = 5;
		raumschiff_speedy = 5;
		raumschiff_leben = 150;
		raumschiff_leben_default=raumschiff_leben;
		raumschiff_schild = 80;
		raumschiff_schildPlus = 8;
		raumschiff_schildMax = raumschiff_schild;
		raumschiff_bild=Var.raumschiff_6;
		raumschiffshild_bild=Var.raumschiffshield_1_Bild;
		geschoss_periode=16;
		anzahlschuesse=2;
		if (!test) {
			initTimer();
		}
		this.score = score;
	}
	
	
	
	@Override
	public void schiessen(){
		new Schuesse_Raumschiff_6(var.getGegnerArray(),this.raumschiff_xpos +this.raumschiff_bild.getWidth()/2, this.raumschiff_ypos +this.raumschiff_bild.getHeight()/2+Var.raumschiff_schuss1_Bild.getHeight()*6, score,false,var,20,0);
		new Schuesse_Raumschiff_6(var.getGegnerArray(),this.raumschiff_xpos +this.raumschiff_bild.getWidth()/2, this.raumschiff_ypos +this.raumschiff_bild.getHeight()/2+Var.raumschiff_schuss1_Bild.getHeight()*9, score,false,var,0,1);
		new Schuesse_Raumschiff_6(var.getGegnerArray(),this.raumschiff_xpos +this.raumschiff_bild.getWidth()/2, this.raumschiff_ypos +this.raumschiff_bild.getHeight()/2-Var.raumschiff_schuss1_Bild.getHeight()*11, score,false,var,0,-1);
		new Schuesse_Raumschiff_6(var.getGegnerArray(),this.raumschiff_xpos +this.raumschiff_bild.getWidth()/2, this.raumschiff_ypos +this.raumschiff_bild.getHeight()/2-Var.raumschiff_schuss1_Bild.getHeight()*8, score,false,var,20,0);
	}
}