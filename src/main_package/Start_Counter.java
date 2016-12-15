package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Start_Counter {

	private Timer timer;
	private int counter = 3;
	
	public Start_Counter() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (Var.startCounter) {
					Var.pause = true;
					counter--;
					if (counter == 0) {
						Var.pause = false;
						Var.startCounter = false;
						counter = 3;
					}
				}
			}
		}, 0, 1000);
	}

	public int getCounter() {
		return counter;
	}
}


