package main_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class Label_Start_Info extends JLabel {

	private int raumschifftyp;
	private String raumschiffname="";
	private Raumschiff schiff;
	private int schussschaden;
	private Schuesse schuss;
	private Var var;
	public Label_Start_Info(int raumschifftyp,Var var) {
		this.var = var;
		this.raumschifftyp=raumschifftyp;
		aendern(raumschifftyp);
	}
	
	public void aendern(int i ){
		raumschifftyp =i;
		switch (raumschifftyp) {
		case 0:
			schiff=new Raumschiff_1(null,true,var);
			schuss=new Schuesse_Raumschiff_1(null, 0, 0, null, true,var);
			schussschaden=schuss.getSchaden();
			raumschiffname="X-Wing";
			break;
		case 1:
			schiff=new Raumschiff_2(null,true,var);
			schuss=new Schuesse_Raumschiff_2(null, 0, 0, null, true,var);
			schussschaden=schuss.getSchaden();
			raumschiffname="Tempest";
			break;
		case 2:
			schiff=new Raumschiff_3(null,true,var);
			schuss=new Schuesse_Raumschiff_3(null, 0, 0, null, true,var);
			schussschaden=schuss.getSchaden();
			raumschiffname="Kreuzer";
			break;
		case 3:
			schiff=new Raumschiff_4(null,true,var);
			schuss=new Schuesse_Raumschiff_4(null, 0, 0, null, true,var);
			schussschaden=schuss.getSchaden();
			raumschiffname="Destroyer";
			break;
			
		default:
			break;
		}
	}

	protected void paintComponent(Graphics g) { // Überschreiben von
		// "paintComponent"
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g.setFont(new Font("Monospaced", Font.BOLD, 20));
		g.setColor(Color.WHITE);
		g.drawString("Raumschiff "+raumschiffname, 20,20);
		g.drawString("Leben: ", 20, this.getHeight()/10*2);
		g.fillRect(20, this.getHeight()/10*2+10,schiff.getRaumschiff_Leben_Default()/2 , 20);
		g.drawString("Schild: ", 20,this.getHeight()/10*3+10);
		g.fillRect(20, this.getHeight()/10*3+20,schiff.gibRaumschiff_schildMax()/2 , 20);
		g.drawString("Schildregeneration:", 20,this.getHeight()/10*5-10 );
		g.fillRect(20, this.getHeight()/10*5,schiff.gibRaumschiff_schildPlus()*5 , 20);
		g.drawString("Geschwindigkeit:", 20, this.getHeight()/10*6);
		g.fillRect(20, this.getHeight()/10*6+10,(schiff.gibRaumschiff_speedx()+schiff.gibRaumschiff_speedy())*20, 20);
		g.drawString("Schaden:", 20, this.getHeight()/10*7+10);
		g.fillRect(20,this.getHeight()/10*7+20,schussschaden*6, 20);
		g.drawString("Angriffsgeschwindigkeit:", 20, this.getHeight()/10*8+20);
		g.fillRect(20,this.getHeight()/10*9-10,(40-schiff.getSchussPeriode())*5, 20);
		repaint();
		
	}

}
