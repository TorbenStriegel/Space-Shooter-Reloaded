package main_package;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class Schuesse_Gegner_Steuerung {

	private Schuesse schuss;
	private Raumschiff schiff;
	private Timer timer;
	private boolean zerstort;
	private Var var;
	
	public Schuesse_Gegner_Steuerung(Schuesse schuesse_schiff, Raumschiff schiff,Var var) {
		this.var=var;
		this.schiff=schiff;
		this.schuss = schuesse_schiff;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (var.verloren) {
					timer.cancel();
				}
				if (!zerstort) {
					if (var.pause != true && var.verloren != true) {
						schuss.setSchuss_xpos();

						if (schuss.gibSchuss_xpos() <0-schuss.gibImage().getWidth()) {
							zerstort = true;
						}
						/*hier wird getsetet ob der Schuss den Spieler trifft oder nicht. Man hat 3 punkte.
						 *  Diese Testen ob sie innerhalb des Bildes vom Raumschiff sind. 
						 *  Wenn sie es sind wird die Methode getroffen aufgerufen. 
						 */
						Point p1 = new Point();
						p1.setLocation(schuss.gibSchuss_xpos() , schuss.gibSchuss_ypos());
						Point p2 = new Point();
						p2.setLocation(schuss.gibSchuss_xpos() ,
								schuss.gibSchuss_ypos() + schuss.gibImage().getHeight());
						Point p3 = new Point();
						p3.setLocation(schuss.gibSchuss_xpos() ,
								schuss.gibSchuss_ypos() + schuss.gibImage().getHeight()/2);


						
							if (p1.getX() >= schiff.gibRaumschiff_xpos()
									&& p1.getX() <= schiff.gibRaumschiff_xpos() + schiff.gibRaumschiff_bild().getWidth()
									&& p1.getY() >= schiff.gibRaumschiff_ypos()
									&& p1.getY() <= schiff.gibRaumschiff_ypos() + schiff.gibRaumschiff_bild().getHeight()) {
								getroffen(schiff);

							} else if (p2.getX() >= schiff.gibRaumschiff_xpos()
									&& p2.getX() <= schiff.gibRaumschiff_xpos() + schiff.gibRaumschiff_bild().getWidth()
									&& p2.getY() >= schiff.gibRaumschiff_ypos()
									&& p2.getY() <= schiff.gibRaumschiff_ypos() + schiff.gibRaumschiff_bild().getHeight()) {
								getroffen(schiff);
							}else if (p3.getX() >= schiff.gibRaumschiff_xpos()
									&& p3.getX() <= schiff.gibRaumschiff_xpos() + schiff.gibRaumschiff_bild().getWidth()
									&& p3.getY() >= schiff.gibRaumschiff_ypos()
									&& p3.getY() <= schiff.gibRaumschiff_ypos() + schiff.gibRaumschiff_bild().getHeight()) {
								getroffen(schiff);
							}
						}
					
				} else {
					var.getGeschossliste().remove(schuss);
				}
			}
		}, 0, 24);
	}

	public void zerstoeren() {
		zerstort = true;
	}

	private void getroffen(Raumschiff schiff) {
		if (!zerstort) {
			schiff.berechneSchaden(schuss.getSchaden(),true);
			schuss.setLeben(100);
			if (schiff.gibRaumschiff_leben() <= 0) {
				System.out.println("Raumschiff kaputt");
				this.schiff = null;
			}
		}

	}




	
	
	
}
