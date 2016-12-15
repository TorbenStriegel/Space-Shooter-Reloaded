package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Gegner_Steuerung {

	Timer timer;
	Gegner gegner;
	private int counter = 0;
	 

	public Gegner_Steuerung(Gegner gegner,Var var) {
		this.gegner = gegner;
		
		if (gegner.isSchuss()) {
			Var.schuessegegner++;
		}
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				if (var.verloren) {
					timer.cancel();
				}
				if (Var.pause != true) {

					if (Var.pause != true && var.verloren != true) {
						gegner.bewegen_x();
						gegner.bewegen_y();
						if (gegner.gibxpos() < -gegner.getImage().getWidth()) {
							gegner.reset();
							counter = 0;
						}
						if (gegner.isSchuss()) {

							counter++;
							if (gegner.gibxpos() < Var.spielfeld_screenwidth - gegner.getImage().getWidth()) {

								if (counter >= gegner.getSchussPeriode()) {
									gegner.schiessen();
									counter = 0;
								}
							}

						}
					}

				}
			}
		}, 0, 13);

	}
}
