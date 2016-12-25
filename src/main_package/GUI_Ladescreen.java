package main_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI_Ladescreen extends JFrame {

	private JPanel contentPane;
	private BufferedImage logo_1,background_1;

	public GUI_Ladescreen(boolean sound) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Var.spielfeld_screenwidth, Var.spielfeld_screenheight); 																// Bildschirm
		setResizable(false);
		setLocation(0, 0);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.BLACK);
		setContentPane(contentPane);
		
		try {
			logo_1 = ImageIO.read(new File("Bilder/logo_1.png"));
			System.out.println("Logo geladen");
			background_1 = ImageIO.read(new File("Bilder/hintergrund_2.jpg"));
			System.out.println("Hintergrund_Ladescreen geladen");
		} catch (IOException e) {
			System.out.println("Bilder nicht gefunden (GUI_Ladescreen)");
			e.printStackTrace();
		}
		
		JLabel logo = new JLabel(new ImageIcon(logo_1));
		logo.setLocation(0,0);
		logo.setSize(Var.spielfeld_screenwidth,Var.spielfeld_screenheight);
		contentPane.add(logo);
		
		JLabel hintergrund = new JLabel(new ImageIcon(background_1));
		hintergrund.setLocation(0,0);
		hintergrund.setSize(Var.spielfeld_screenwidth,Var.spielfeld_screenheight);
		contentPane.add(hintergrund);
		setVisible(true);
		if (sound) {
			new AudioPlayer(Var.sound_1);
		}	
	}
}
