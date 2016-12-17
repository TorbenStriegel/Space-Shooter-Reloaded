package main_package;

import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;

public class ItemSpeed extends Items {
	private int counter =0;
	private Var var;
	public ItemSpeed(Raumschiff schiff1, Var var) {
		
		super(schiff1, var);
		bild=var.itemSpeed_bild;
		schiff.setDefaultWerte();
		this.var=var;
	}
	
	
	public void action(){
		schiff.erhoeheSpeed(4);
		xpos=-100;
		ypos=-100;
		
		Timer timer =new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(var.verloren){
					timer.cancel();
				}
				
				if(counter==1)schiff.setSpeedDefault();
				counter++;
			}
		}, 0, 5000);
	}
}
