package main_package;

public class Raumschiff_5 extends Raumschiff {

	public Raumschiff_5(Score score,boolean test,Var var) {
		super(var);
		raumschiff_speedx = 5;
		raumschiff_speedy = 5;
		raumschiff_leben = 200;
		raumschiff_leben_default=raumschiff_leben;
		raumschiff_schild = 50;
		raumschiff_schildPlus = 5;
		raumschiff_schildMax = raumschiff_schild;
		raumschiff_bild=Var.raumschiff_5;
		raumschiffshild_bild=Var.raumschiffshield_1_Bild;
		geschoss_periode=12;
		anzahlschuesse=2;
		if (!test) {
			initTimer();
		}
		this.score = score;
	}
	
	
	
	@Override
	public void schiessen(){
		new Schuesse_Raumschiff_5(var.getGegnerArray(),this.raumschiff_xpos +this.raumschiff_bild.getWidth() -Var.raumschiff_schuss1_Bild.getWidth()-5, this.raumschiff_ypos +Var.raumschiff_schuss1_Bild.getHeight()/2+3, score,false,var);
		new Schuesse_Raumschiff_5(var.getGegnerArray(),this.raumschiff_xpos +this.raumschiff_bild.getWidth() -Var.raumschiff_schuss1_Bild.getWidth()-5, this.raumschiff_ypos +this.raumschiff_bild.getHeight()-Var.raumschiff_schuss1_Bild.getHeight()/2-10, score,false,var);
	}
}