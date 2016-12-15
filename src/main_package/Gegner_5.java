package main_package;

public class Gegner_5 extends Gegner{

	public Gegner_5() {
		super();
		leben_default = 200;
		leben = leben_default;
		kollisionsSchaden = 300;
		xspeed = -2;
		yspeed = 0;
		schuss = false;
		gegner_bild = Var.gegner_5;
	}

}
