package main_package;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Items {
	
	protected int  xpos=-100;
	protected int ypos =-100;
	protected Raumschiff schiff;
	protected Timer timer;
	protected boolean eingesammelt = false;
	protected BufferedImage bild;
	protected int randomerscheinen;
	protected int counter =0;
	
	public Items(Raumschiff schiff1,Var var) {
		var.addItemliste(this);
		this.schiff =schiff1;
		randomerscheinen=(int)(Math.random()*700)+100;
		bild=var.itemLeben_bild;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				counter ++;
				if (var.verloren) {
					timer.cancel();
				}
				if (!eingesammelt) {
					if (var.pause != true && var.verloren != true) {
						


						Point p1 = new Point();
						p1.setLocation(xpos ,ypos);
						Point p2 = new Point();
						p2.setLocation(xpos+bild.getWidth() ,ypos);
						Point p3 = new Point();
						p3.setLocation(xpos ,ypos+bild.getHeight());
						Point p4 = new Point();
						p4.setLocation(xpos+bild.getWidth() ,ypos+bild.getHeight());


						
							if (p1.getX() >= schiff.gibRaumschiff_xpos()
									&& p1.getX() <= schiff.gibRaumschiff_xpos() + schiff.gibRaumschiff_bild().getWidth()
									&& p1.getY() >= schiff.gibRaumschiff_ypos()
									&& p1.getY() <= schiff.gibRaumschiff_ypos() + schiff.gibRaumschiff_bild().getHeight()) {
							eingesammelt =true;
							action();
							

							} else if (p2.getX() >= schiff.gibRaumschiff_xpos()
									&& p2.getX() <= schiff.gibRaumschiff_xpos() + schiff.gibRaumschiff_bild().getWidth()
									&& p2.getY() >= schiff.gibRaumschiff_ypos()
									&& p2.getY() <= schiff.gibRaumschiff_ypos() + schiff.gibRaumschiff_bild().getHeight()) {
								eingesammelt =true;
								action();
							}else if (p3.getX() >= schiff.gibRaumschiff_xpos()
									&& p3.getX() <= schiff.gibRaumschiff_xpos() + schiff.gibRaumschiff_bild().getWidth()
									&& p3.getY() >= schiff.gibRaumschiff_ypos()
									&& p3.getY() <= schiff.gibRaumschiff_ypos() + schiff.gibRaumschiff_bild().getHeight()) {
								eingesammelt =true;
								action();
							}else if (p4.getX() >= schiff.gibRaumschiff_xpos()
									&& p4.getX() <= schiff.gibRaumschiff_xpos() + schiff.gibRaumschiff_bild().getWidth()
									&& p4.getY() >= schiff.gibRaumschiff_ypos()
									&& p4.getY() <= schiff.gibRaumschiff_ypos() + schiff.gibRaumschiff_bild().getHeight()) {
								eingesammelt =true;
								action();
							}
						}
					
					
					if(counter==randomerscheinen){
						counter++;
						xpos = (int)(Math.random()*(var.spielfeld_screenwidth-bild.getWidth()));
						ypos = (int)(Math.random()*(var.spielfeld_screenheight-bild.getHeight()));
					}
					
				} 
			}
		}, 0, 24);

	}

	public int gibYpos() {
		// TODO Auto-generated method stub
		return ypos;
	}
	public int gibXpos() {
		// TODO Auto-generated method stub
		return xpos;
	}
	public BufferedImage gibBild() {
		// TODO Auto-generated method stub
		return bild;
	}
	
	public void action(){
		System.out.println("action");
	}

}
