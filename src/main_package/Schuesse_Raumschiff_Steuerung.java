package main_package;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class Schuesse_Raumschiff_Steuerung {

	private Schuesse schuss;
	private Gegner gegner;
	private Score score;
	private Timer timer;
	private boolean zerstort;

	public Schuesse_Raumschiff_Steuerung(Schuesse schuss1, Gegner[] gegner, Score score) {
		this.schuss = schuss1;
		this.score = score;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!zerstort) {
					if (Var.pause != true && Var.verloren != true) {
						schuss.setSchuss_xpos();

						if (schuss.gibSchuss_xpos() > Var.spielfeld_screenwidth) {
							score.erhoeheSchussDaneben();
							zerstort = true;
						}

						Point p1 = new Point();
						p1.setLocation(schuss.gibSchuss_xpos() + schuss.gibImage().getWidth(), schuss.gibSchuss_ypos());
						Point p2 = new Point();
						p2.setLocation(schuss.gibSchuss_xpos() + schuss.gibImage().getWidth(),
								schuss.gibSchuss_ypos() + schuss.gibImage().getHeight());

						for (int i = 0; i < gegner.length; i++) {
							if (p1.getX() >= gegner[i].gibxpos()
									&& p1.getX() <= gegner[i].gibxpos() + gegner[i].getImage().getWidth()
									&& p1.getY() >= gegner[i].gibypos()
									&& p1.getY() <= gegner[i].gibypos() + gegner[i].getImage().getHeight()) {
								getroffen(gegner[i]);

							} else if (p2.getX() >= gegner[i].gibxpos()
									&& p2.getX() <= gegner[i].gibxpos() + gegner[i].getImage().getWidth()
									&& p2.getY() >= gegner[i].gibypos()
									&& p2.getY() <= gegner[i].gibypos() + gegner[i].getImage().getHeight()) {
								getroffen(gegner[i]);
							}
						}
					}
				} else {
					Var.geschossliste.remove(schuss);
				}
			}
		}, 0, 24);
	}

	public void zerstoeren() {
		zerstort = true;
	}

	private void getroffen(Gegner gegner) {
		if (!zerstort) {
			score.erhoeheSchuesseGetroffen();
			
			gegner.schaden(schuss.getSchaden());
			schuss.setLeben(gegner.getPunkte());
			if (gegner.gibleben() <= 0) {
				score.setAktuellerScore(gegner.getPunkte());
				gegner.reset();
				
				this.gegner = null;
			}
		}

	}

}
