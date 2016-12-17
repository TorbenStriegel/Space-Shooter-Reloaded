package main_package;

public class ItemFreischalten extends Items {
	private LevelTester tester;

	public ItemFreischalten(Raumschiff schiff1, Var var,LevelTester tester) {
		super(schiff1, var);
		this.tester =tester;
		bild=var.itemFrei_bild;
		randomerscheinen=(int)(Math.random()*50)+2000;
	}
	
	
	public void action(){
		tester.schreibeSchiff(tester.getSchifffrei()+1);
		xpos=-100;
		ypos=-100;
	}
}
