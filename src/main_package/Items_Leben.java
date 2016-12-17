package main_package;

public class Items_Leben extends Items {

	

	public Items_Leben(Raumschiff schiff1, Var var) {
		super(schiff1, var);
		bild=var.itemLeben_bild;
	}
	
	
	public void action(){
		schiff.berechneSchaden(-40, false);
		xpos=-100;
		ypos=-100;
	}

}
