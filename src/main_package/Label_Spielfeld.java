package main_package;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;



public class Label_Spielfeld extends JLabel { // Erbt von JLabel, damit alle Funktionen vorhanden sind
	
	private boolean beendet=false;
	private JFrame spielfeld;
	private Var var;
	private Gegner_Level gegner_level;
	private Raumschiff raumschiff;
	private Score score;
	private Spieltimer spieltimer;
	private Start_Counter start_Counter;
	boolean gegner = false;
	private Gegner[] gegner_Arrays = new Gegner[Var.anzahlGegner];
	private final Action action = new SwingAction();


	public Label_Spielfeld(Gegner_Level gegner_level, Raumschiff raumschiff, Score score, Spieltimer spieltimer,Var var,Start_Counter start_Counter) {
		this.var =var;

		this.gegner_level = gegner_level;
		this.raumschiff = raumschiff;
		this.score = score;
		this.spieltimer = spieltimer;
		this.start_Counter = start_Counter;
		gegner_Arrays = gegner_level.getGegner_Array();
		gegner = true;
		System.out.println("übergeben");
		 beendet=false;
	}

	@Override
	protected void paintComponent(Graphics g) { // Überschreiben von
												// "paintComponent"
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		if (!var.verloren) {
			g.drawImage(Var.background_1, var.background_x1, 0, Var.spielfeld_screenwidth, Var.spielfeld_screenheight,
					null);
			g.drawImage(Var.background_2, var.background_x2, 0, Var.spielfeld_screenwidth, Var.spielfeld_screenheight,
					null);

			if (gegner) {
				for (int i = 0; i < gegner_Arrays.length; i++) {
					g.drawImage(gegner_Arrays[i].getImage(), gegner_Arrays[i].gibxpos(), gegner_Arrays[i].gibypos(),
							null);
				}
			}
			g.drawImage(raumschiff.gibRaumschiff_bild(), raumschiff.gibRaumschiff_xpos(),
					raumschiff.gibRaumschiff_ypos(), null);
			if (raumschiff.gibRaumschiff_schildanzeigen()) {
				g.drawImage(raumschiff.gibRaumschiffschild_bild(),
						raumschiff.gibRaumschiff_xpos() + raumschiff.gibRaumschiff_bild().getWidth() - 10,
						raumschiff.gibRaumschiff_ypos() - 15, 50, raumschiff.gibRaumschiff_bild().getHeight() + 30,
						null);
			}

			for (int i = 0; i < var.getGeschossliste().size(); i++) {
				try {

					g.drawImage(var.getGeschossliste().get(i).gibImage(), var.getGeschossliste().get(i).gibSchuss_xpos(), var.getGeschossliste().get(i).gibSchuss_ypos(), null);
					} catch (Exception e) {
				}
				}
			
			g.setColor(Color.GRAY);
			g.fillRect(20, 35, raumschiff.getRaumschiff_Leben_Default(), 20);

			g.setColor(new Color(190,60,60));
			g.fillRect(20, 35, raumschiff.gibRaumschiff_leben(), 20);

			g.setColor(Color.GRAY);
			g.fillRect(20, 60, raumschiff.gibRaumschiff_schildMax(), 20);

			g.setColor(new Color(60,60,190));
			g.fillRect(20, 60, raumschiff.gibRaumschiff_schild(), 20);

			g.setColor(Color.YELLOW);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
			g.drawString("Score:" + score.getFinalScore(), Var.spielfeld_screenwidth / 2 - 50, 60);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			g.drawString("Treffergenauigkeit:" + score.getTreffergenauigkeit() + "%",
					Var.spielfeld_screenwidth / 2 - 120, 100);
			g.setColor(Color.GREEN);
			g.drawString("Zeit:" + spieltimer.getZeit_Millisekunden(), Var.spielfeld_screenwidth / 2, 140);

			if(spieltimer.getZeit_Millisekunden()<=10){
				g.setFont(new Font("Arial", Font.BOLD, 90));
				g.drawString(""+spieltimer.getZeit_Millisekunden(), Var.spielfeld_screenwidth / 2, Var.spielfeld_screenheight/2);
			}
			
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Level:" + gegner_level.getLevel(), (Var.spielfeld_screenwidth - 150), 35);

			

			
			if(Var.zeigeLebenGegner){
				g.setColor(Color.RED);
				g.setFont(new Font("Arial", Font.BOLD, 50));
				g.drawString("Boss:" + gegner_Arrays[0].gibleben()+" Leben", (Var.spielfeld_screenwidth/2 - 80),Var.spielfeld_screenheight-35);
			}
			
			
			beendet=false;
		} 
		if (var.pause && !var.startCounter) {
			g.setColor(new Color(100, 100, 100, 128));
			g.fillRect(0, 0, Var.spielfeld_screenwidth, Var.spielfeld_screenheight);
		}
		else if (var.startCounter) {
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, 140));
			g.drawString(""+start_Counter.getCounter(), (Var.spielfeld_screenwidth/2-30),Var.spielfeld_screenheight/2+40);
			g.setColor(new Color(100, 100, 100, 128));
			g.fillRect(0, 0, Var.spielfeld_screenwidth, Var.spielfeld_screenheight);

		} else if (var.verloren) {

			g.setColor(Color.BLACK);
			g.fillRect(0, 0, Var.spielfeld_screenwidth, Var.spielfeld_screenheight);
			if(var.timer_finish){
				g.setColor(Color.GREEN);
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("Dein Platz:"+score.getPlatzierung(), (Var.spielfeld_screenwidth / 2 - 200), (Var.spielfeld_screenheight / 2 - 30));
			}else{
				g.setColor(Color.RED);
				g.setFont(new Font("Arial", Font.BOLD, 60));
				g.drawString("GAME OVER", (Var.spielfeld_screenwidth / 2 - 210), (Var.spielfeld_screenheight / 2 - 30));
			}
			g.setFont(new Font("Arial", Font.BOLD, 30));
			g.drawString("Dein Score: " + score.getFinalScore(), (Var.spielfeld_screenwidth / 2 - 150),(Var.spielfeld_screenheight / 2 + 10));
			if (!beendet){
				beendet = true;
				zeichneButton();

			}
		
		}
		repaint();
	}
	
	
	
		


	
	public void setSpielfeld(JFrame jFrame_Spielfeld){
		spielfeld=jFrame_Spielfeld;
	}
	
	public void zeichneButton(){
		JButton btnNewButton = new JButton("Neues Spiel");
		btnNewButton.setAction(action);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 20));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setSize(Var.spielfeld_screenwidth/5, Var.spielfeld_screenheight/10);
		btnNewButton.setLocation(Var.spielfeld_screenwidth/2-btnNewButton.getWidth()/2,Var.spielfeld_screenheight/2+btnNewButton.getHeight()*2);
		spielfeld.getContentPane().add(btnNewButton,0);
	}
	
	private class SwingAction extends AbstractAction {
	
		public SwingAction() {
			putValue(NAME, "Neues Spiel");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			
			spielfeld.dispose();
			new Logik();
		}
	}

}
