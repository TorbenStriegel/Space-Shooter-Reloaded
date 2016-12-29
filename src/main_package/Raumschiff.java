package main_package;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public abstract class Raumschiff {

	protected int raumschiff_xpos = 30;
	protected int raumschiff_ypos = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
	protected int raumschiff_speedy = 5, raumschiff_speedx = 6;
	protected int speed_default;
	protected int raumschiff_leben = 100;
	protected int raumschiff_leben_default;
	protected int raumschiff_schild = 50;
	protected int raumschiff_schildMax = 0;
	protected int raumschiff_schildPlus = 5;
	protected Score score;
	protected Timer timer;
	protected Var var;
	protected int geschoss_periode;
	protected int geschoss_periode_default;
	protected boolean raumschiff_schildanzeigen = true;
	protected BufferedImage raumschiff_bild;
	protected BufferedImage raumschiffshild_bild;
	protected boolean schieﬂenErlaubt = true;
	protected int counter = 0;
	protected int anzahlschuesse = 0;
	public Raumschiff(Var var) {
		this.var=var;
	}

	protected void initTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (var.pause != true) {
					if (Var.space) {
						if (schieﬂenErlaubt) {
							schieﬂenErlaubt = false;
							counter = 0;
							schiessen();
						}
					}
					counter++;
					if ((counter % geschoss_periode)==0) {
						schieﬂenErlaubt = true;
						counter=0;
					}
					
				}
			}

		}, 0, 22);
	}

	

	public void schiessen() {

	}

	public void berechneSchaden(int schaden, boolean vorne) {
		if(schaden <0){
			setLeben(raumschiff_leben-schaden);
			if(gibRaumschiff_leben()>=raumschiff_leben_default){
				setLeben(raumschiff_leben_default);
			}
		}else{
		score.setAktuellerScore(-schaden);
		if (gibRaumschiff_schild() > 0 && vorne) {
			raumschiff_schildanzeigen = true;
			setSchild(gibRaumschiff_schild() - schaden);
			if (gibRaumschiff_schild() < 0) {
				setRaumschiff_schildanzeigen(false);
				setLeben(gibRaumschiff_leben() + gibRaumschiff_schild());
				setSchild(0);
				if (gibRaumschiff_leben()<=0){
					var.verloren = true;
				}
			}
		} else {
			if(vorne){
				setRaumschiff_schildanzeigen(false);
			}
			setLeben(gibRaumschiff_leben() - schaden);
			if (gibRaumschiff_leben()<=0){
				var.verloren = true;
			}
		}
		}
	}

	
	public void setX_Pos(int x_Pos) {
		raumschiff_xpos = x_Pos;
	}

	public void setY_Pos(int y_Pos) {
		raumschiff_ypos = y_Pos;
	}

	public void setSchild(int schild) {
		raumschiff_schild = schild;
	}

	public void setLeben(int leben) {
		raumschiff_leben = leben;
	}
	public void setRaumschiff_schildanzeigen(boolean raumschiff_schildanzeigen) {
		this.raumschiff_schildanzeigen = raumschiff_schildanzeigen;
	}
	public int gibRaumschiff_xpos() {
		return raumschiff_xpos;
	}

	public int gibRaumschiff_ypos() {
		return raumschiff_ypos;
	}

	public int gibRaumschiff_speedy() {
		return raumschiff_speedy;
	}

	public int gibRaumschiff_speedx() {
		return raumschiff_speedx;
	}

	public int gibRaumschiff_leben() {
		return raumschiff_leben;
	}
	public int gibRaumschiff_schild() {
		return raumschiff_schild;
	}
	public int gibRaumschiff_schildMax() {
		return raumschiff_schildMax;
	}
	public int gibRaumschiff_schildPlus() {
		return raumschiff_schildPlus;
	}
	public boolean gibRaumschiff_schildanzeigen(){
		return raumschiff_schildanzeigen;
	}
	public BufferedImage gibRaumschiff_bild() {
		return raumschiff_bild;
	}
	public BufferedImage gibRaumschiffschild_bild() {
		return raumschiffshild_bild;
	}
	
	public int getSchussPeriode(){
		return geschoss_periode;
	}
	public int getRaumschiff_Leben_Default(){
		return raumschiff_leben_default;
	}
	public int gibAnzahlSchuesse(){
		return anzahlschuesse;
	}
	
	public void setPeriodeDefault(){
		geschoss_periode= geschoss_periode_default;
	}
	
	public void verbesserePeriode(int i){
		
			geschoss_periode-=i;
	
		if(geschoss_periode<4){
			geschoss_periode=3;
		}
	
	}
	
	public void setDefaultWerte(){
		speed_default=raumschiff_speedx;
		geschoss_periode_default= geschoss_periode;
	}
	
	public void setSpeedDefault(){
		raumschiff_speedx=speed_default;
		raumschiff_speedy=speed_default;
	}
	
	public void erhoeheSpeed(int i){
		raumschiff_speedx+=i;
		raumschiff_speedy+=i;
	}
}
