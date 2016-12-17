package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class ItemSchuss extends Items {
	private Var var;
	private int counter =0;
	public ItemSchuss(Raumschiff schiff1, Var var) {
		super(schiff1, var);
		bild=var.itemSchuss_bild;
		schiff.setDefaultWerte();
		this.var =var;
	}
	
	
	public void action(){
		schiff.verbesserePeriode(10);
		xpos=-100;
		ypos=-100;
		
		Timer timer =new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(var.verloren){
					timer.cancel();
				}
				
				if(counter==1)schiff.setPeriodeDefault();
				counter++;
			}
		}, 0, 5000);
	}
}
