package main_package;

public class Raumschiff_4 extends Raumschiff {

	public Raumschiff_4(Score score,boolean test,Var var) {
		super(var);
		raumschiff_speedx = 5;
		raumschiff_speedy = 5;
		raumschiff_leben = 200;
		raumschiff_leben_default=raumschiff_leben;
		raumschiff_schild = 150;
		raumschiff_schildPlus = 10;
		raumschiff_bild=Var.raumschiff_4;
		raumschiffshild_bild=Var.raumschiffshield_1_Bild;
		raumschiff_schildMax = raumschiff_schild;
		geschoss_periode=30;
		anzahlschuesse=1;
		if (!test) {
			initTimer();
		}
		this.score = score;
	}

	public void schiessen(){
		new Schuesse_Raumschiff_4(gegner,this.raumschiff_xpos +this.raumschiff_bild.getWidth() -Var.raumschiff_schuss2_Bild.getWidth(), this.raumschiff_ypos+this.raumschiff_bild.getHeight()/2-Var.raumschiff_schuss2_Bild.getHeight()/2, score,false,var);		
	}
}
