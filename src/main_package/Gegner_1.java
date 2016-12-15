package main_package;

public class Gegner_1 extends Gegner {

	public Gegner_1(){
		super();
		leben_default = 5;
		leben = leben_default;
		kollisionsSchaden = 5;
		xspeed = -3;
		yspeed = 0;
		schuss = false;
		gegner_bild = Var.gegner_1;
	}
}
