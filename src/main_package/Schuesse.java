package main_package;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Schuesse {

	protected Schuesse_Raumschiff_Steuerung steuerung;
	protected Schuesse_Gegner_Steuerung steuerung_gegner;
	protected Score score;
	protected int schussSchaden;
	protected int speed;
	protected int schuss_xpos = 0;
	protected int schuss_ypos = 0;
	protected BufferedImage schuss_bild;
	protected int leben;
	protected Var var;
	
	public Schuesse(Var var) {
		this.var=var;
		var.getGeschossliste().add(this);
	}

	public int getSchaden(){
		return schussSchaden;
	}
	
	protected void zerstoeren(){
		
	}
	public void setSchuss_xpos(){
		schuss_xpos +=speed;
	}
	
	public void setLeben(int schaden){
		leben-=schaden;
		if(leben<=0){
			zerstoeren();
		}
	}
	public int getLeben(){
		return leben;
	}
	
	public int gibSchuss_xpos(){
		return schuss_xpos;
	}
	public int gibSchuss_ypos(){
		return schuss_ypos;
	}
	public int gibSpeed(){
		return speed;
	}
	
	public BufferedImage gibImage(){
		return schuss_bild;
	}
}
