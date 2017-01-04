package main_package;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Gegner {

	protected Var var;


	protected int counter = -1;
	protected int leben = 100;
	protected int leben_default;
	protected int kollisionsSchaden;
	protected int schussSchaden;
	protected int xpos=Var.spielfeld_screenwidth;
	protected int ypos=30;
	protected int yspeed;
	protected int xspeed;
	protected boolean schuss = false;
	protected int schuss_periode;
	protected Raumschiff schiff;
	protected boolean raumschiff_uebergeben = false;
	protected BufferedImage gegner_bild = Var.gegner_1;
	protected int richtungy =0; 
	protected Gegner_Steuerung gegner_Steuerung;
	
	/*------------------------------------------------------------*/
	public Gegner(Var var) {
		this.var =var;
		gegner_Steuerung = new Gegner_Steuerung(this,var);
		reset();
	}
	/*------------------------------------------------------------*/
	
	public void cancelSteuerung(){
		gegner_Steuerung.cancel();
	}
	
	public void bewegen_x(){
		xpos = xpos+xspeed;
	}
	public void bewegen_y(){
		ypos = ypos+yspeed;
	}
	public void schaden(int schaden){
		leben-=schaden;
	}
	public void schiessen(){
		
	}
	
	public void setRaumschiff(Raumschiff schiff){
		this.schiff=schiff;
		raumschiff_uebergeben = true;
	}
	
	public void reset(){
	if(var.keinReset){
		 var.gegnerAusSpielfeld++;
		 xspeed=0;
	}
	ypos=(int) (Math.random()*(Var.spielfeld_screenheight-80));
	xpos=Var.spielfeld_screenwidth+ (int) (Math.random()*1500);
	leben = leben_default;
	counter++;
		
	}
	public void sonstige_Befehle(){

	}
	
	
	public boolean isSchuss(){
		return schuss;
	}
	
	public int gibypos() {
		return ypos;
	}

	public int gibxpos() {
		return xpos;
	}
	
	public int gibKollisionsSchaden() {
		return kollisionsSchaden;
	}
	
	public int gibSchussSchaden() {
		return schussSchaden;
	}
	
	public int gibleben() {
		return leben;
	}

	public BufferedImage getImage() {
		return gegner_bild;	
	}
	public int getSchussPeriode(){
		return schuss_periode;
	}

	public int getPunkte(){
		return leben_default;
	}
	
}
