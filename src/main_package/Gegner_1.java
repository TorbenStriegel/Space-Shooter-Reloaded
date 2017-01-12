package main_package;

public class Gegner_1 extends Gegner {
	/* durch Polymorphie und Vererbung sind die einzelnen Klassen von den Gegnern sehr klein
	 */
	public Gegner_1(Var var){
		super(var);
		leben_default = 5;
		leben = leben_default;
		kollisionsSchaden = 5;
		xspeed = -3;
		yspeed = 0;
		schuss = false;
		gegner_bild = Var.gegner_1;
	}
}
