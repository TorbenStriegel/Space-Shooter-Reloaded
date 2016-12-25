package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Level_Survival {

	private Var var;
	private Logik logik;
	private Timer timer;
	private boolean level_lauft = false;
	
	public Level_Survival(Var var,Logik logik) {
		Var.survival = true;
		this.var = var;
		this.logik = logik;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!var.pause) {
					if (!level_lauft) {
						level_lauft = true;
					}else if(var.timer_finish){
						level_lauft = false;
						logik.weiter();
//						var.startCounter=true;
					}
				}
					
			}
		}, 0, 700);
	}
}
