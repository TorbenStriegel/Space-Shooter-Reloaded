package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Raumschiff_Steuerung {
	
	private Raumschiff raumschiff;
	private Timer timer;

	public Raumschiff_Steuerung(Raumschiff raumschiff,Var var) {
		this.raumschiff = raumschiff;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (Var.pause != true && var.verloren != true) {
					if (Var.moveup == true) {
						if (raumschiff.gibRaumschiff_ypos() > 5) {
							raumschiff.setY_Pos(raumschiff.gibRaumschiff_ypos() - raumschiff.gibRaumschiff_speedy());
							//System.out.println("Bewege hoch");
						}
					}if (Var.movedown) {
						if (raumschiff.gibRaumschiff_ypos() <= (Var.spielfeld_screenheight - raumschiff.gibRaumschiff_bild().getHeight() - 10)) {
							raumschiff.setY_Pos(raumschiff.gibRaumschiff_ypos() + raumschiff.gibRaumschiff_speedy());
							//System.out.println("Bewege runter");
						}
					}if (Var.moveleft) {
						if (raumschiff.gibRaumschiff_xpos() > 5) {
							raumschiff.setX_Pos(raumschiff.gibRaumschiff_xpos() - raumschiff.gibRaumschiff_speedx());
							//System.out.println("Bewege nach links");
						}
					}if (Var.moveright) {
						if (raumschiff.gibRaumschiff_xpos() <= (Var.spielfeld_screenwidth - raumschiff.gibRaumschiff_bild().getWidth() - 10)) {
							raumschiff.setX_Pos(raumschiff.gibRaumschiff_xpos() + raumschiff.gibRaumschiff_speedx());
							//System.out.println("Bewege nach rechts");
						}
					}
				}
			}

		}, 0, 12);
	}
}
