package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Start_Counter {

	private Timer timer;
	private int counter = 3;
	
	public Start_Counter(Var var) {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (var.startCounter) {
					var.pause = true;
					counter--;
					if (counter == 0) {
						var.pause = false;
						var.startCounter = false;
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


