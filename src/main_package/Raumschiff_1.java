package main_package;

public class Raumschiff_1 extends Raumschiff {

	public Raumschiff_1(Score score,boolean test) {
		raumschiff_speedx = 6;
		raumschiff_speedy = 6;
		raumschiff_leben = 100;
		raumschiff_leben_default=raumschiff_leben;
		raumschiff_schild = 250;
		raumschiff_schildPlus = 20;
		raumschiff_schildMax = raumschiff_schild;
		raumschiff_bild=Var.raumschiff_1;
		raumschiffshild_bild=Var.raumschiffshield_1_Bild;
		geschoss_periode=6;
		anzahlschuesse=2;
		if (!test) {
			initTimer();
		}
		this.score = score;
	}
	
	
	
	@Override
	public void schiessen(){
		new Schuesse_Raumschiff_1(gegner,this.raumschiff_xpos +this.raumschiff_bild.getWidth() -Var.raumschiff_schuss1_Bild.getWidth()-5, this.raumschiff_ypos +Var.raumschiff_schuss1_Bild.getHeight()/2+3, score,false);
		new Schuesse_Raumschiff_1(gegner,this.raumschiff_xpos +this.raumschiff_bild.getWidth() -Var.raumschiff_schuss1_Bild.getWidth()-5, this.raumschiff_ypos +this.raumschiff_bild.getHeight()-Var.raumschiff_schuss1_Bild.getHeight()/2-10, score,false);
	}
}
