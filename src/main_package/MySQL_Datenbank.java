package main_package;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Arrays;

public class MySQL_Datenbank {

	private int counter = 0;
	private int platzierung = 1;
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	private final String MySQL_URL = "jdbc:mysql://torben-striegel.ddns.net:3306/space_Shooter?user=space&password=123456789";
    private String[] highscore_name = new String[10];
    private String[] highscore_score = new String[10];
    private String[] highscore_treffergenauigkeit = new String[10];
    private String[] highscore_vernichteteGegner = new String[10];
	public MySQL_Datenbank() {
		
	}

	public void Werte_auslesen(int level) {
		try {
			Arrays.fill(highscore_name, null);
			Arrays.fill(highscore_score, null);
			Arrays.fill(highscore_treffergenauigkeit, null);
			Arrays.fill(highscore_vernichteteGegner, null);
			System.out.println("Versuche eine Verbindung zum Server herzustellen. (Highscore abfrage)");
			connection = DriverManager.getConnection(MySQL_URL);
			System.out.println("Verbindung zum Server hergestellt.");
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM `Highscore` where Level = "+level+" ORDER BY Score DESC");
			while (result.next() && counter<10) {
				highscore_name[counter] = result.getString(4);
				highscore_score[counter] = result.getString(5);
				highscore_treffergenauigkeit[counter] = result.getString(6);
				highscore_vernichteteGegner[counter] = result.getString(7);
				counter++;
			}
			counter=0;
			connection.close();
			statement.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void Werte_auslesenAlle() {
		try {
			System.out.println("Versuche eine Verbindung zum Server herzustellen.");
			connection = DriverManager.getConnection(MySQL_URL);
			System.out.println("Verbindung zum Server hergestellt.");
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM `Highscore` ORDER BY Score DESC");
			while (result.next() && counter<10) {
				highscore_name[counter] = result.getString(4);
				highscore_score[counter] = result.getString(5);
				highscore_treffergenauigkeit[counter] = result.getString(6);
				highscore_vernichteteGegner[counter] = result.getString(7);
				counter++;
			}
			counter=0;
			connection.close();
			statement.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	public int platzierungBerechnen(int level, double ereichterScore) {
		try {
			System.out.println("Versuche eine Verbindung zum Server herzustellen.(Plazierung berechnen)");
			connection = DriverManager.getConnection(MySQL_URL);
			System.out.println("Verbindung zum Server hergestellt.");
			statement = connection.createStatement();
			result = statement.executeQuery("SELECT * FROM `Highscore` where Level = "+level+" ORDER BY Score DESC");
			while (result.next() && counter<10) {
				if(Integer.parseInt(result.getString(5)) <= ereichterScore){
					platzierung = counter + 1;
					System.out.println("Erreichter Platz:"+platzierung);
					break;
				}else{
					counter++;
					}
			}
			counter=0;
			connection.close();
			statement.close();
			result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return platzierung;
	}
	
	public String[] getHighscore_name() {
		return highscore_name;
	}

	public String[] getHighscore_score() {
		return highscore_score;
	}

	public String[] getHighscore_treffergenauigkeit() {
		return highscore_treffergenauigkeit;
	}

	public String[] getHighscore_vernichteteGegner() {
		return highscore_vernichteteGegner;
	}

	public int Werte_eintragen(int raumschiffTyp, int level, String name, int score, int treffergenauigkeit, int vernichtete_Gegner) {
		try {
			System.out.println("Versuche eine Verbindung zum Server herzustellen.");
			connection = DriverManager.getConnection(MySQL_URL);
			System.out.println("Verbindung zum Server hergestellt.");
			statement = connection.createStatement();
			return statement.executeUpdate("INSERT INTO `space_Shooter`.`Highscore` (`id`, `RaumschiffTyp`, `Level`, `Name`, `Score`, `Treffergenauigkeit`, `Vernichtete Gegner`) VALUES (NULL, '"+raumschiffTyp+"', '"+level+"', '"+name+"', '"+score+"', '"+treffergenauigkeit+"', '"+vernichtete_Gegner+"')");
		} catch (SQLException e) {
			return 0;
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
