package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Level_Survival {

	private Var var;
	private Logik logik;
	private Timer timer;
	private boolean level_lauft = false;
	
	public Level_Survival(Var vari,Logik logic) {
		Var.survival = true;
		this.var = vari;
		this.logik = logic;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				
					if(var.timer_finish){
						logik.weiter();
					var.timer_finish=false;
//						var.startCounter=true;
					}
				
					
			}
		}, 0, 700);
	}
}
