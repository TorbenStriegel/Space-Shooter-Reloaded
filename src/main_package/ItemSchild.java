package main_package;

public class ItemSchild extends Items {





	public ItemSchild(Raumschiff schiff1, Var var) {
		super(schiff1, var);
		bild=var.itemShild_bild;
	}
	
	
	public void action(){
		if(!(schiff.gibRaumschiff_schildMax()==schiff.gibRaumschiff_schild())){
			schiff.setSchild(schiff.gibRaumschiff_schild()+40);
			if(schiff.gibRaumschiff_schildMax()<schiff.gibRaumschiff_schild()){
				schiff.setSchild(schiff.gibRaumschiff_schildMax());
			}
		}
		
		xpos=-100;
		ypos=-100;
	}
	
}
