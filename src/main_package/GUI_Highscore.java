package main_package;

import java.util.Arrays;

import javax.swing.*;

public class GUI_Highscore {

    private String[] highscore_name = new String[10];
    private String[] highscore_score = new String[10];
    private String[] highscore_treffergenauigkeit = new String[10];
    private String[] highscore_vernichteteGegner = new String[10];
	
	GUI_Highscore(MySQL_Datenbank mySQL_Datenbank, int level){
		highscore_name = mySQL_Datenbank.getHighscore_name();
		highscore_score = mySQL_Datenbank.getHighscore_score();
		highscore_treffergenauigkeit = mySQL_Datenbank.getHighscore_treffergenauigkeit();
		highscore_vernichteteGegner = mySQL_Datenbank.getHighscore_vernichteteGegner();
		mySQL_Datenbank.Werte_auslesen(level);
		String[][] rowData = {
	    {highscore_name[0],highscore_score[0],highscore_treffergenauigkeit[0],highscore_vernichteteGegner[0]},
	    {highscore_name[1],highscore_score[1],highscore_treffergenauigkeit[1],highscore_vernichteteGegner[1]},
	    {highscore_name[2],highscore_score[2],highscore_treffergenauigkeit[2],highscore_vernichteteGegner[2]},
	    {highscore_name[3],highscore_score[3],highscore_treffergenauigkeit[3],highscore_vernichteteGegner[3]},
	    {highscore_name[4],highscore_score[4],highscore_treffergenauigkeit[4],highscore_vernichteteGegner[4]},
	    {highscore_name[5],highscore_score[5],highscore_treffergenauigkeit[5],highscore_vernichteteGegner[5]},
	    {highscore_name[6],highscore_score[6],highscore_treffergenauigkeit[6],highscore_vernichteteGegner[6]},
	    {highscore_name[7],highscore_score[7],highscore_treffergenauigkeit[7],highscore_vernichteteGegner[7]},
	    {highscore_name[8],highscore_score[8],highscore_treffergenauigkeit[8],highscore_vernichteteGegner[8]},
	    {highscore_name[9],highscore_score[9],highscore_treffergenauigkeit[9],highscore_vernichteteGegner[9]}
	    };

	    String[] columnNames =  {
	      "Name", "Score", "Treffergenauigkeit (%)", "vernichtete Gegner"
	    };

	    JFrame f = new JFrame("Highscore / Level:"+level);
	    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    JTable table = new JTable( rowData, columnNames );
	    f.add(new JScrollPane( table ));

	    f.pack();
	    f.setVisible( true );
	  
	}
}
