package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Schild_Steuerung {

	private Raumschiff raumschiff;
	private Timer timer_1;

	public Schild_Steuerung(Raumschiff raumschiff) {
		this.raumschiff = raumschiff;
		timer_1 = new Timer();
		timer_1.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (Var.pause != true && !Var.verloren) {	
					if (raumschiff.gibRaumschiff_schild() < raumschiff.gibRaumschiff_schildMax()){
						raumschiff.setRaumschiff_schildanzeigen(true);
						raumschiff.setSchild(raumschiff.gibRaumschiff_schild() + raumschiff.gibRaumschiff_schildPlus());
					}
				}
			}
		}, 0, 8000);
	}
}
