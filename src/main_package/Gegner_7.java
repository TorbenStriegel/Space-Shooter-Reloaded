package main_package;

public class Gegner_7 extends Gegner {

	private boolean komplettImBild = false;
	
	public Gegner_7() {
		super();
		leben_default = 500;
		leben = leben_default;
		kollisionsSchaden = 1000;
		xspeed = -8;
		yspeed = 2;
		schuss = true;
		gegner_bild = Var.gegner_7;
		schuss_periode = 40;
	}

	public void schiessen() {
		new Schuesse_Gegner_3(schiff, this.xpos, this.ypos + this.gegner_bild.getHeight()/2- Var.gegner_schuss3_Bild.getHeight()/2);
	}

	public void bewegen_y() {
		if (raumschiff_uebergeben) {
			if (schiff.gibRaumschiff_ypos() < this.ypos) {
				this.ypos = this.ypos - yspeed;
			} else if (schiff.gibRaumschiff_ypos() > this.ypos) {
				this.ypos = this.ypos + yspeed;
			}
		}

	}

	public void bewegen_x() {
		xpos = xpos + xspeed;
		if(xpos<Var.spielfeld_screenwidth-gegner_bild.getWidth()){
			xspeed = -2;
			komplettImBild = true;
		}
		if (raumschiff_uebergeben && komplettImBild) {
			if (xpos < Var.spielfeld_screenwidth / 2 && schiff.gibRaumschiff_xpos() < this.xpos) {
				xspeed = 0;
			}
			else if (schiff.gibRaumschiff_xpos() > this.xpos){
				xspeed = 2;
			}
			else if (schiff.gibRaumschiff_xpos() < this.xpos){
				xspeed = -2;
			}
		}
	}
}
