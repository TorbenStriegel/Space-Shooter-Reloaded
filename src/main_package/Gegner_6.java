package main_package;

public class Gegner_6 extends Gegner{
	int random_zahl=0;
	int zahl=0;
	public Gegner_6() {
		// TODO Auto-generated constructor stub
		super();
		leben_default = 200;
		leben = leben_default;
		kollisionsSchaden = 100;
		xspeed = -10;
		yspeed = 3;
		schuss = true;
		gegner_bild = Var.gegner_6;
		schuss_periode=100+(int)(Math.random()*300);
		richtungy=0;
		 random_zahl=(int)(Math.random()*600)+gegner_bild.getWidth();
		 zahl = gegner_bild.getWidth();
	}
	
	public void schiessen(){
		new Schuesse_Gegner_2(schiff, this.xpos, this.ypos+this.gegner_bild.getHeight()/2-Var.gegner_schuss1_Bild.getHeight()/2);
		
	}
	
	
		public void bewegen_y() {
			if(xpos<Var.spielfeld_screenwidth-random_zahl&&random_zahl!=0){
				xspeed=0;
			}
			if (richtungy == 0) {
				ypos = ypos + yspeed;
				
			} else {
				ypos = ypos - yspeed;
				
			}
			if (ypos <= 0) {
				
					richtungy = 0;
				} else if (ypos + zahl  > Var.spielfeld_screenheight) {
					
					richtungy = 1;
				}
			}
	
	
		public void reset(){
			ypos=(int) (Math.random()*(Var.spielfeld_screenheight-80));
			xpos=Var.spielfeld_screenwidth+ (int) (Math.random()*1500);
			leben = leben_default;
			xspeed=-10;
		}
	
}
