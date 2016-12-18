package main_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;



public class LableHighscore extends JLabel {

	private boolean schreiben=false;
	private String[][] labels = new String[3][11];
	  private String[] highscore_name = new String[10];
	    private String[] highscore_score = new String[10];
	    private String[] highscore_treffergenauigkeit = new String[10];
	    private String[] highscore_vernichteteGegner = new String[10];
	    private MySQL_Datenbank mySQL_Datenbank;
    String[] columnNames =  {
      "Name", "Score", "Treffergenauigkeit (%)", "vernichtete Gegner"
    };


public LableHighscore(MySQL_Datenbank mySQL_Datenbank1,int level){
	schreiben=false;
	mySQL_Datenbank=mySQL_Datenbank1;
	mySQL_Datenbank.Werte_auslesen(level);
	highscore_name = mySQL_Datenbank.getHighscore_name();
	highscore_score = mySQL_Datenbank.getHighscore_score();
	highscore_treffergenauigkeit = mySQL_Datenbank.getHighscore_treffergenauigkeit();
	highscore_vernichteteGegner = mySQL_Datenbank.getHighscore_vernichteteGegner();
	schreiben=true;

}

public void level(int level){
	schreiben=false;
	mySQL_Datenbank.Werte_auslesen(level);
	highscore_name = mySQL_Datenbank.getHighscore_name();
	highscore_score = mySQL_Datenbank.getHighscore_score();
	highscore_treffergenauigkeit = mySQL_Datenbank.getHighscore_treffergenauigkeit();
	highscore_vernichteteGegner = mySQL_Datenbank.getHighscore_vernichteteGegner();
	schreiben=true;
}

protected void paintComponent(Graphics g) { // Überschreiben von
	// "paintComponent"
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	g.setFont(new Font("Monospaced", Font.BOLD, 20));
	g.setColor(Color.WHITE);
	if(schreiben){
	

		
	for (int i = 0; i < labels.length; i++) {
		for (int j = 0; j < labels[i].length; j++) {
			
			switch (i) {
			case 0:
				if (j==1){
					g.drawString("Name", this.getWidth()/3*i, this.getHeight()/11*j);
				}else{
					try {
						String a=highscore_name[j-2];
					if(a.length()>12){
						 a =a.substring(0, 9);
						a+="...";
					}
						g.drawString(a,this.getWidth()/3*i, this.getHeight()/11*j);
					
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				break;
				
			case 1:
				if (j==1){
					g.drawString("Score", this.getWidth()/3*i, this.getHeight()/11*j);
				}else{
					try {
					g.drawString(highscore_score[j-2],this.getWidth()/3*i, this.getHeight()/11*j);

					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
				break;
			case 2:
				if (j==1){
					g.drawString("Treffer(%)", this.getWidth()/3*i, this.getHeight()/11*j);
				}else{
					try {
			
					g.drawString(highscore_treffergenauigkeit[j-2],this.getWidth()/3*i, this.getHeight()/11*j);

				} catch (Exception e) {
					// TODO: handle exception
				}
				
				}
			break;
			


			default:
				break;
			}
			
			
		}
	
	repaint();
	
}
	}

}



}
