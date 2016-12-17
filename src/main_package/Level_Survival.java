package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Level_Survival {

	Gegner_Level gegner_Level;
	Timer timer;
	
	public Level_Survival(Gegner_Level gegner_Level) {
		this.gegner_Level = gegner_Level;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
		
					
			}
		}, 0, 1000);
	}
}
