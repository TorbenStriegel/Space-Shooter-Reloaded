package main_package;

public class Gegner_4 extends Gegner {

	public Gegner_4() {
		super();
		leben_default = 80;
		leben = leben_default;
		kollisionsSchaden = 100;
		xspeed = -2;
		yspeed = 0;
		schuss = false;
		gegner_bild = Var.gegner_4;
	}

}
