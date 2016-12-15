package main_package;

public class Gegner_2 extends Gegner {

	public Gegner_2(Var var){
		super(var);
		leben_default = 10;
		leben = leben_default;
		kollisionsSchaden = 10;
		xspeed = -3;
		yspeed = 3;
		schuss = false;
		gegner_bild = Var.gegner_2;
	}

	public void bewegen_y() {
		if (richtungy == 0) {
			ypos = ypos + yspeed;
			if (ypos < 0) {
				ypos = 0;
			}
		} else {
			ypos = ypos - yspeed;
			if (ypos + gegner_bild.getHeight() > Var.spielfeld_screenheight) {
				ypos = Var.spielfeld_screenheight - gegner_bild.getHeight() - 50;
			}
		}
		if (xpos % 150 == 0) {
			if (richtungy == 0) {
				richtungy = 1;
			} else {
				richtungy = 0;
			}
		}
	}
}
