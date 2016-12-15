package main_package;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI_Spielfeld {
	
	JFrame jFrame_Spielfeld;
	public GUI_Spielfeld(Label_Spielfeld label_Spielfeld,Var var) {
		
		jFrame_Spielfeld = new JFrame();
		jFrame_Spielfeld.setSize(Var.spielfeld_screenwidth, Var.spielfeld_screenheight); 																// Bildschirm
		jFrame_Spielfeld.setResizable(false);
		jFrame_Spielfeld.setLocation(0, 0);
		jFrame_Spielfeld.requestFocus();
		jFrame_Spielfeld.setUndecorated(true);
		jFrame_Spielfeld.addKeyListener(new KeyHandler(var));
		jFrame_Spielfeld.setVisible(true);
		label_Spielfeld.setBounds(0, 0, Var.spielfeld_screenwidth, Var.spielfeld_screenheight);
		jFrame_Spielfeld.getContentPane().add(label_Spielfeld);
		label_Spielfeld.setVisible(true);
		label_Spielfeld.setSpielfeld(jFrame_Spielfeld);
	}
	
	

}
