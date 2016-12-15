package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Spieltimer {

	private Timer timer;
	private int zeit_Millisekunden = 0;
	private int zeit_Start = 0;
	
	public Spieltimer(int millisekunden) {
		zeit_Millisekunden = millisekunden;
		zeit_Start = zeit_Millisekunden;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!Var.pause){
					zeit_Millisekunden--;
					if (zeit_Millisekunden<= 0) {
						Var.verloren = true;
						Var.timer_finish = true;
					}
				}
			}
		}, 0, 1000);
	}
	
	public int getZeit_Start() {
		return zeit_Start;
	}
	public int getZeit_Millisekunden() {
		return zeit_Millisekunden;
	}
}


