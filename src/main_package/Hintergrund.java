package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Hintergrund {
	Timer timer;
	int variable = 5;

	public Hintergrund(Var var) {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if ((Var.background_x1) > (-Var.spielfeld_screenwidth + variable)) {
					Var.background_x1 -= 2;
				} else {
					Var.background_x1 = (Var.spielfeld_screenwidth - variable);
				}

				if ((var.background_x2) > (-Var.spielfeld_screenwidth + variable)) {
					Var.background_x2 -= 2;
				} else {
					Var.background_x2 = (Var.spielfeld_screenwidth - variable);
				}
			}
		}, 0, Var.background_speed);
	}

}
