package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Spieltimer {

	private Timer timer;
	private int zeit_Millisekunden = 0;
	private int zeit_Start = 0;
	private Var var;
	
	public Spieltimer(int millisekunden,Var vari) {
		zeit_Millisekunden = millisekunden;
		zeit_Start = zeit_Millisekunden;
		this.var =vari;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!var.pause&&!var.verloren){
					zeit_Millisekunden--;
					var.timer_finish = false;
					if (zeit_Millisekunden<= 0) {
						var.verloren = true;
						var.timer_finish = true;
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


