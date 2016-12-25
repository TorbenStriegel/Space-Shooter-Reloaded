package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Level_Survival {

	private Var var;
	private Logik logik;
	private Timer timer;
	private int counter = 0;
	private boolean level_gestartet = false;
	
	public Level_Survival(Var var,Logik logik) {
		this.var = var;
		this.logik = logik;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!var.pause) {
					if (!level_gestartet) {
						level_gestartet = true;
						counter++;
					}else if(var.timer_finish){
						level_gestartet = false;
					}
				}
					
			}
		}, 0, 700);
	}
}
