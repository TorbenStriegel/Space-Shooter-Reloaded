package main_package;

public class Raumschiff_3 extends Raumschiff {

	public Raumschiff_3(Score score,boolean test) {
		raumschiff_speedx = 4;
		raumschiff_speedy = 4;
		raumschiff_leben = 350;
		raumschiff_leben_default=raumschiff_leben;
		raumschiff_schild = 150;
		raumschiff_schildPlus = 10;
		raumschiff_bild=Var.raumschiff_3;
		raumschiffshild_bild=Var.raumschiffshield_1_Bild;
		raumschiff_schildMax = raumschiff_schild;
		geschoss_periode=14;
		anzahlschuesse=2;
		if (!test) {
			initTimer();
		}
		this.score = score;
	}
	
	
	
	public void schiessen(){
		new Schuesse_Raumschiff_3(gegner,this.raumschiff_xpos +this.raumschiff_bild.getWidth() -Var.raumschiff_schuss3_Bild.getWidth()*2-10, this.raumschiff_ypos +Var.raumschiff_schuss3_Bild.getHeight()/2+5, score,false);
		new Schuesse_Raumschiff_3(gegner,this.raumschiff_xpos +this.raumschiff_bild.getWidth() -Var.raumschiff_schuss3_Bild.getWidth()*2-10, this.raumschiff_ypos +this.raumschiff_bild.getHeight()-Var.raumschiff_schuss3_Bild.getHeight()/2-20, score,false);
		}
}
