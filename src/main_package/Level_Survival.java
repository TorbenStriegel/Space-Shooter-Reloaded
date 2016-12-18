package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Level_Survival {

	private Var var;
	private Timer timer;
	private int counter = 0;
	private boolean level_gestartet = false;
	
	public Level_Survival(Var var) {
		this.var = var;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!var.pause) {
					if (!level_gestartet) {
						new Gegner_Level(counter,var);
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
