package main_package;

public class Schuesse_Gegner_4 extends Schuesse {
	private Raumschiff schiff;
	public Schuesse_Gegner_4(Raumschiff schiff,int xpos,int ypos,Var var) {
		super(var);
		this.schiff=schiff;
		schuss_xpos=xpos;
		schuss_ypos=ypos;
		schussSchaden = 8;
		speed = -15;
		leben=1;
		schuss_bild = Var.gegner_schuss4_Bild;
		steuerung_gegner = new Schuesse_Gegner_Steuerung(this, schiff,var);
	}

	public void zerstoeren(){
		steuerung_gegner.zerstoeren();
		steuerung_gegner=null;
	}
	
	public void setSchuss_xpos(){
		schuss_xpos +=speed;
		if(schiff.gibRaumschiff_ypos()+schiff.gibRaumschiff_bild().getHeight()/2>schuss_ypos){
			schuss_ypos+=3;
		}else if(schiff.gibRaumschiff_ypos()+schiff.gibRaumschiff_bild().getHeight()/2<schuss_ypos){
			schuss_ypos-=3;
		}
	}
	
}
