package main_package;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;

public class GUI_Startfenster extends JFrame {

	private JPanel contentPane;
	private Logik logik;
	private JTextField txtName;
	private final Action actionlv1;
	private final Action actionlv2;
	private final Action actionm1;
	private final Action actionm2;
	private final Action action;
	private final Action action_1;
	private final Action action_2;
	private final Action action_3;
	private final Action actionbeenden;
	private MySQL_Datenbank mySQL_Datenbank;
	private JLabel label;
	private String name ="Name";
	private int level=1;
	private JLabel lblLevel;
	private JLabel musiklabel;
	private Label_Start_Info labelstart;
	private int musik=0;
	private int raumschiffTyp =0; //0=ship_1 1=ship_2
	 
	public GUI_Startfenster(Logik l, MySQL_Datenbank mySQL_Datenbank,Var var) {
		this.mySQL_Datenbank = mySQL_Datenbank;
		actionm1=new SwingActionm1(this);
		actionm2=new SwingActionm2(this);
		actionlv1=new SwingActionlv1(this);
		actionlv2=new SwingActionlv2(this);
		action = new SwingAction(this);
		action_1 = new SwingAction_1(this);
		action_2 = new SwingAction_2(this);
		action_3  = new SwingAction_3(mySQL_Datenbank);

		actionbeenden  = new SwingActioab();
		logik=l;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setUndecorated(true);
		setSize(Var.spielfeld_screenwidth,Var.spielfeld_screenheight);
		setLocation(0, 0);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblSpaceInvaderRelaoded = new JLabel("Space Invader Reloaded");
		lblSpaceInvaderRelaoded.setForeground(Color.WHITE);
		lblSpaceInvaderRelaoded.setFont(new Font("Monospaced", Font.BOLD, 65));
		lblSpaceInvaderRelaoded.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceInvaderRelaoded.setBounds(0, 20, 1356, 61);
		lblSpaceInvaderRelaoded.setSize(Var.spielfeld_screenwidth,Var.spielfeld_screenheight/10);
		contentPane.add(lblSpaceInvaderRelaoded);
		
		JButton btnStarten = new JButton("Starten");
		btnStarten.setAction(action_2);
		btnStarten.setSize(Var.spielfeld_screenwidth/5, Var.spielfeld_screenheight/15);
		btnStarten.setLocation(Var.spielfeld_screenwidth/2-btnStarten.getWidth()/2,Var.spielfeld_screenheight/2+btnStarten.getHeight()*3);
		btnStarten.setBackground(Color.WHITE);
		btnStarten.setBorder(null);
		btnStarten.setFont(new Font("Monospaced", Font.BOLD, 30));
		contentPane.add(btnStarten);
		
		JButton btnexit = new JButton("X");
		btnexit.setAction(actionbeenden);
		btnexit.setSize(Var.spielfeld_screenwidth/15, Var.spielfeld_screenheight/15);
		btnexit.setLocation(Var.spielfeld_screenwidth-btnexit.getWidth(),0 );
		btnexit.setBackground(Color.RED);
		btnexit.setBorder(null);
		btnexit.setForeground(Color.BLACK);
		btnexit.setFont(new Font("Monospaced", Font.BOLD, 30));
		contentPane.add(btnexit);
		
		JButton btnHighscore = new JButton("Highscore");
		btnHighscore.setAction(action_3);
		btnHighscore.setSize(Var.spielfeld_screenwidth/5, Var.spielfeld_screenheight/15);
		btnHighscore.setLocation(Var.spielfeld_screenwidth/2-btnHighscore.getWidth()/2,Var.spielfeld_screenheight/2+btnHighscore.getHeight()*4+10);
		btnHighscore.setBackground(Color.WHITE);
		btnHighscore.setBorder(null);
		btnHighscore.setFont(new Font("Monospaced", Font.BOLD, 30));
		contentPane.add(btnHighscore);
		
		label = new JLabel(new ImageIcon(Var.raumschiff_2_Bildpfad));
		label.setSize(Var.spielfeld_screenwidth/4, Var.spielfeld_screenheight/4);
		label.setLocation(Var.spielfeld_screenwidth/2-label.getWidth()/2,Var.spielfeld_screenheight/2-label.getHeight()/2-10);
		contentPane.add(label);
		
		
		txtName = new JTextField();
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		txtName.setFont(new Font("Monospaced", Font.BOLD, 30));
		txtName.setText("Name");
		txtName.setBounds(547, 457, 273, 51);
		txtName.setSize(Var.spielfeld_screenwidth/5, Var.spielfeld_screenheight/15);
		txtName.setLocation(Var.spielfeld_screenwidth/2-btnStarten.getWidth()/2,Var.spielfeld_screenheight/2+btnStarten.getHeight()*2-10 );
		txtName.setBorder(null);
		txtName.addFocusListener(new FocusListener (){
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				txtName.setText(" ");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(!(txtName.getText().equals("")||txtName.getText().equals(" "))){
					name = txtName.getText();
				}
				txtName.setText(name);
			}
		});
		contentPane.add(txtName);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.setAction(action);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Monospaced", Font.BOLD, 50));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setSize(Var.spielfeld_screenwidth/15, Var.spielfeld_screenheight/10);
		btnNewButton_1.setLocation(Var.spielfeld_screenwidth/2+btnNewButton_1.getWidth()*2,Var.spielfeld_screenheight/2-btnNewButton_1.getHeight()/2);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.setAction(action_1);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Monospaced", Font.BOLD, 50));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setSize(Var.spielfeld_screenwidth/15, Var.spielfeld_screenheight/10);
		btnNewButton.setLocation(Var.spielfeld_screenwidth/2-btnNewButton_1.getWidth()*3,Var.spielfeld_screenheight/2-btnNewButton_1.getHeight()/2);
		contentPane.add(btnNewButton);
		
		
		lblLevel = new JLabel("Level:1");
		lblLevel.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevel.setSize(Var.spielfeld_screenwidth/5, Var.spielfeld_screenheight/15);
		lblLevel.setLocation(Var.spielfeld_screenwidth/2-lblLevel.getWidth()/2,Var.spielfeld_screenheight/2-lblLevel.getHeight()*3 );
		lblLevel.setFont(new Font("Monospaced", Font.BOLD, 30));
		lblLevel.setForeground(Color.WHITE);
		
		contentPane.add(lblLevel);
		
		
		musiklabel = new JLabel("Standart");
		musiklabel.setHorizontalAlignment(SwingConstants.CENTER);
		musiklabel.setSize(Var.spielfeld_screenwidth/5, Var.spielfeld_screenheight/15);
		musiklabel.setLocation(Var.spielfeld_screenwidth/2-musiklabel.getWidth()/2,Var.spielfeld_screenheight/2-musiklabel.getHeight()*5 );
		musiklabel.setFont(new Font("Monospaced", Font.BOLD, 25));
		musiklabel.setForeground(Color.WHITE);
		
		contentPane.add(musiklabel);
		Var.musik_default=Var.musik_1;
		
		
		JButton btnNewButton_11 = new JButton(">");
		btnNewButton_11.setAction(actionlv2);
		btnNewButton_11.setBorder(null);
		btnNewButton_11.setBackground(Color.BLACK);
		btnNewButton_11.setFont(new Font("Monospaced", Font.BOLD, 50));
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setSize(Var.spielfeld_screenwidth/15, Var.spielfeld_screenheight/10);
		btnNewButton_11.setLocation(Var.spielfeld_screenwidth/2+btnNewButton_1.getWidth()*2,Var.spielfeld_screenheight/2-(int)(btnNewButton_1.getHeight()*2.2));
		contentPane.add(btnNewButton_11);
		
		JButton btnNewButton1 = new JButton("<");
		btnNewButton1.setAction(actionlv1);
		btnNewButton1.setBorder(null);
		btnNewButton1.setBackground(Color.BLACK);
		btnNewButton1.setFont(new Font("Monospaced", Font.BOLD, 50));
		btnNewButton1.setForeground(Color.WHITE);
		btnNewButton1.setSize(Var.spielfeld_screenwidth/15, Var.spielfeld_screenheight/10);
		btnNewButton1.setLocation(Var.spielfeld_screenwidth/2-btnNewButton_1.getWidth()*3,Var.spielfeld_screenheight/2-(int)(btnNewButton_1.getHeight()*2.2));
		contentPane.add(btnNewButton1);
		
		
		JButton btnNewButton_111 = new JButton(">");
		btnNewButton_111.setAction(actionm2);
		btnNewButton_111.setBorder(null);
		btnNewButton_111.setBackground(Color.BLACK);
		btnNewButton_111.setFont(new Font("Monospaced", Font.BOLD, 50));
		btnNewButton_111.setForeground(Color.WHITE);
		btnNewButton_111.setSize(Var.spielfeld_screenwidth/15, Var.spielfeld_screenheight/10);
		btnNewButton_111.setLocation(Var.spielfeld_screenwidth/2+btnNewButton_1.getWidth()*2,Var.spielfeld_screenheight/2-(int)(btnNewButton_1.getHeight()*3.5));
		contentPane.add(btnNewButton_111);
		
		JButton btnNewButton111 = new JButton("<");
		btnNewButton111.setAction(actionm1);
		btnNewButton111.setBorder(null);
		btnNewButton111.setBackground(Color.BLACK);
		btnNewButton111.setFont(new Font("Monospaced", Font.BOLD, 50));
		btnNewButton111.setForeground(Color.WHITE);
		btnNewButton111.setSize(Var.spielfeld_screenwidth/15, Var.spielfeld_screenheight/10);
		btnNewButton111.setLocation(Var.spielfeld_screenwidth/2-btnNewButton_1.getWidth()*3,Var.spielfeld_screenheight/2-(int)(btnNewButton_1.getHeight()*3.5));
		contentPane.add(btnNewButton111);
		
		labelstart = new Label_Start_Info(raumschiffTyp,var);
		labelstart.setSize(Var.spielfeld_screenwidth/4,400);
		labelstart.setLocation(Var.spielfeld_screenwidth/2-(int)(labelstart.getWidth()*1.8),Var.spielfeld_screenheight/2-labelstart.getHeight()/2);
		labelstart.setVisible(true);
		contentPane.add(labelstart);
		
		vor();
		zuruck();
		
		JLabel bildlabel = new JLabel(new ImageIcon(Var.background_1));
		bildlabel.setLocation(0,0);
		bildlabel.setSize(Var.spielfeld_screenwidth,Var.spielfeld_screenheight);
		contentPane.add(bildlabel);
		
		requestFocus();
		setVisible(true);
	}
	
	public void starten(){
		if(!(txtName.getText().equals("Name"))){
			name = txtName.getText();
			logik.starten(name,raumschiffTyp,this,level);
		}else{
			JLabel labelkeinname = new JLabel("Name eintragen!");
			labelkeinname.setHorizontalAlignment(SwingConstants.CENTER);
			labelkeinname.setSize(Var.spielfeld_screenwidth/5, Var.spielfeld_screenheight/15);
			labelkeinname.setLocation(Var.spielfeld_screenwidth/2-labelkeinname.getWidth()/2,Var.spielfeld_screenheight/2+labelkeinname.getHeight()*6 );
			labelkeinname.setFont(new Font("Monospaced", Font.BOLD, 30));
			labelkeinname.setForeground(Color.RED);
			contentPane.add(labelkeinname,0);
			repaint();
		}
		
	}
	public void vor(){
		raumschiffTyp++;
		if(raumschiffTyp>3){
			raumschiffTyp=0;
		}
		if(raumschiffTyp==0){
			label.setIcon(new ImageIcon(Var.raumschiff_1_Bildpfad));
		}else if(raumschiffTyp==1){
			label.setIcon(new ImageIcon(Var.raumschiff_2_Bildpfad));
		}else if(raumschiffTyp==2){
			label.setIcon(new ImageIcon(Var.raumschiff_3_Bildpfad));
		}else if(raumschiffTyp==3){
			label.setIcon(new ImageIcon(Var.raumschiff_4_Bildpfad));
		}
		labelstart.aendern(raumschiffTyp);
		
	}
	
	public void zuruck(){
		raumschiffTyp--;
		if(raumschiffTyp<0){
			raumschiffTyp=3;
		}
		if(raumschiffTyp==0){
			label.setIcon(new ImageIcon(Var.raumschiff_1_Bildpfad));
		}else if(raumschiffTyp==1){
			label.setIcon(new ImageIcon(Var.raumschiff_2_Bildpfad));
		}else if(raumschiffTyp==2){
			label.setIcon(new ImageIcon(Var.raumschiff_3_Bildpfad));
		}else if(raumschiffTyp==3){
			label.setIcon(new ImageIcon(Var.raumschiff_4_Bildpfad));
		}
		labelstart.aendern(raumschiffTyp);
	}
	
	public void vorlv(){
		if(level==0){
			level=1;
		}else if(level==1){
			level=2;
		}else if(level==2){
			level=3;
		}else if(level==3){
			level=4;
		}else if(level==4){
			level=5;
		}else if(level==5){
			level=6;
		}else if(level==6){
			level=7;
		}else if(level==7){
			level=8;
		}else if(level==8){
			level=9;
		}else if(level==9){
			level=10;
		}else if(level==10){
			level=11;
		}else if(level==11){
			level=12;
		}else if(level==12){
			level=0;
		}
		
		lblLevel.setText("Level:"+level);
	}
	
	public void zurucklv(){
		if(level==12){
			level=11;
		}else if(level==11){
			level=10;
		}else if(level==10){
			level=9;
		}else if(level==9){
			level=8;
		}else if(level==8){
			level=7;
		}else if(level==7){
			level=6;
		}else if(level==6){
			level=5;
		}else if(level==5){
			level=4;
		}else if(level==4){
			level=3;
		}else if(level==3){
			level=2;
		}else if(level==2){
			level=1;
		}else if(level==1){
			level=0;
		}else if(level==0){
			level=12;
		}
		lblLevel.setText("Level:"+level);
	}
	
	public void vorm(){
		if(musik==0){
			musik=1;
			Var.musik = true;
			Var.musik_default=Var.musik_3;
			musiklabel.setText("Pirates of the Caribbean");
		}else if(musik==1){
			musik=2;
			Var.musik = true;
			Var.musik_default=Var.musik_2;
			musiklabel.setText("Starwars");
		}else if(musik==2){
			musik=3;
			Var.musik = true;
			Var.musik_default=Var.musik_4;
			musiklabel.setText("Batman-The Dark Night");
		}else if(musik==3){
			musik=4;
			Var.musik = true;
			Var.musik_default=Var.musik_1;
			musiklabel.setText("Standart");
		}else if(musik==4){
			musik=0;
			Var.musik = false;
			musiklabel.setText("Keine Musik");
		}
		
	}
	
	public void zuruckm(){
		if(musik==0){
			musik=4;
			Var.musik = true;
			Var.musik_default=Var.musik_1;
			musiklabel.setText("Standart");
		}else if(musik==1){
			musik=0;
			Var.musik = true;
			musiklabel.setText("Keine Musik");
		}else if(musik==2){
			musik=1;
			Var.musik = true;
			Var.musik_default=Var.musik_3;
			musiklabel.setText("Pirates of the Caribbean");
		}else if(musik==3){
			musik=2;
			Var.musik = true;
			Var.musik_default=Var.musik_2;
			musiklabel.setText("Starwars");
		}else if(musik==4){
			musik=3;
			Var.musik_default=Var.musik_4;
			musiklabel.setText("Batman-The Dark Night");
		}
	}
	
	private class SwingAction extends AbstractAction {
		GUI_Startfenster fenster;
		public SwingAction(GUI_Startfenster fenster) {
			this.fenster = fenster;
			putValue(NAME, ">");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			fenster.vor();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		GUI_Startfenster fenster;
		public SwingAction_1(GUI_Startfenster fenster) {
			this.fenster = fenster;
			putValue(NAME, "<");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			fenster.zuruck();
		}
	}
	private class SwingAction_2 extends AbstractAction {
		GUI_Startfenster fenster;
		public SwingAction_2(GUI_Startfenster fenster) {
			this.fenster = fenster;
			putValue(NAME, "Starten");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			fenster.starten();
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3(MySQL_Datenbank mySQL_Datenbank) {
			putValue(NAME, "Highscoreliste");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			new GUI_Highscore(mySQL_Datenbank,level);
		}
	}
	private class SwingActionlv1 extends AbstractAction {
		GUI_Startfenster fenster;
		public SwingActionlv1(GUI_Startfenster fenster) {
			this.fenster = fenster;
			putValue(NAME, "<");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			fenster.zurucklv();
		}
	}
	private class SwingActionlv2 extends AbstractAction {
		GUI_Startfenster fenster;
		public SwingActionlv2(GUI_Startfenster fenster) {
			this.fenster = fenster;
			putValue(NAME, ">");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			fenster.vorlv();
		}
	}
	
	private class SwingActionm1 extends AbstractAction {
		GUI_Startfenster fenster;
		public SwingActionm1(GUI_Startfenster fenster) {
			this.fenster = fenster;
			putValue(NAME, "<");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			fenster.zuruckm();
		}
	}
	private class SwingActionm2 extends AbstractAction {
		GUI_Startfenster fenster;
		public SwingActionm2(GUI_Startfenster fenster) {
			this.fenster = fenster;
			putValue(NAME, ">");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			fenster.vorm();
		}
	}
	
	private class SwingActioab extends AbstractAction {
		public SwingActioab() {
			putValue(NAME, "X");
			putValue(SHORT_DESCRIPTION, "");
		}
		public void actionPerformed(ActionEvent e) {
			System.exit(1000);
		}
	}
	
}
