package main_package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI_Ladescreen extends JFrame {

	private JPanel contentPane;

	public GUI_Ladescreen(boolean sound) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Var.spielfeld_screenwidth, Var.spielfeld_screenheight); 																// Bildschirm
		setResizable(false);
		setLocation(0, 0);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		JLabel logo = new JLabel(new ImageIcon(Var.logo_1));
		logo.setLocation(0,0);
		logo.setSize(Var.spielfeld_screenwidth,Var.spielfeld_screenheight);
		contentPane.add(logo);
		
		JLabel hintergrund = new JLabel(new ImageIcon(Var.background_1));
		hintergrund.setLocation(0,0);
		hintergrund.setSize(Var.spielfeld_screenwidth,Var.spielfeld_screenheight);
		contentPane.add(hintergrund);
		setVisible(true);
		if (sound) {
			new AudioPlayer(Var.sound_1);
		}	
	}
}
