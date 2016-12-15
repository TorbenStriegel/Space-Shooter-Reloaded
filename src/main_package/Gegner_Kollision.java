package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Gegner_Kollision {

	private Timer timer;
	private Gegner_Level gegner_level;
	private Raumschiff raumschiff;
	private Gegner[] gegner_Array = new Gegner[Var.anzahlGegner];
	private int schaden = 0;

	public Gegner_Kollision(Gegner_Level gegner_level, Raumschiff raumschiff) {
		this.gegner_level = gegner_level;
		this.raumschiff = raumschiff;
		gegner_Array = gegner_level.getGegner_Array();
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!Var.verloren && !Var.pause) {
					for (int i = 0; i < gegner_Array.length; i++) {
						if ((raumschiff.gibRaumschiff_xpos()
								+ raumschiff.gibRaumschiff_bild().getWidth()) >= (gegner_Array[i].gibxpos())
								&& (raumschiff.gibRaumschiff_xpos()
										+ raumschiff.gibRaumschiff_bild().getWidth()) <= (gegner_Array[i].gibxpos()
												+ gegner_Array[i].getImage().getWidth())) {
							if ((raumschiff.gibRaumschiff_ypos() <= gegner_Array[i].gibypos())
									&& (raumschiff.gibRaumschiff_ypos()
											+ raumschiff.gibRaumschiff_bild().getHeight()) >= (gegner_Array[i].gibypos()
													+ gegner_Array[i].getImage().getHeight())) {
								System.out.println("Kolidiert vorne/zentral auf das Raumschiff");
								gegner_Array[i].reset();
								schaden = gegner_Array[i].gibKollisionsSchaden() * 2;
								raumschiff.berechneSchaden(schaden, true);
							} else if (((raumschiff.gibRaumschiff_ypos()
									+ raumschiff.gibRaumschiff_bild().getHeight()) >= gegner_Array[i].gibypos()
									&& (raumschiff.gibRaumschiff_ypos()
											+ raumschiff.gibRaumschiff_bild().getHeight()) <= (gegner_Array[i].gibypos()
													+ gegner_Array[i].getImage().getHeight()))) {
								System.out.println("Kolidiert vorne/unten am Raumschiff");
								gegner_Array[i].reset();
								schaden = gegner_Array[i].gibKollisionsSchaden();
								raumschiff.berechneSchaden(schaden, true);
							} else if (raumschiff
									.gibRaumschiff_ypos() <= (gegner_Array[i].gibypos()
											+ gegner_Array[i].getImage().getHeight())
									&& raumschiff.gibRaumschiff_ypos() >= gegner_Array[i].gibypos()) {
								System.out.println("Kolidiert vorne/oben am Raumschiff");
								gegner_Array[i].reset();
								schaden = gegner_Array[i].gibKollisionsSchaden();
								raumschiff.berechneSchaden(schaden, true);
							}
						}
						if ((raumschiff.gibRaumschiff_xpos()) >= (gegner_Array[i].gibxpos())
								&& (raumschiff.gibRaumschiff_xpos()) <= (gegner_Array[i].gibxpos()
										+ gegner_Array[i].getImage().getWidth())) {
							if ((raumschiff.gibRaumschiff_ypos() <= gegner_Array[i].gibypos())
									&& (raumschiff.gibRaumschiff_ypos()
											+ raumschiff.gibRaumschiff_bild().getHeight()) >= (gegner_Array[i].gibypos()
													+ gegner_Array[i].getImage().getHeight())) {
								System.out.println("Kolidiert hinten/zentral auf das Raumschiff");
								gegner_Array[i].reset();
								schaden = gegner_Array[i].gibKollisionsSchaden() * 2;
								raumschiff.berechneSchaden(schaden, false);
							} else if (((raumschiff.gibRaumschiff_ypos()
									+ raumschiff.gibRaumschiff_bild().getHeight()) >= gegner_Array[i].gibypos()
									&& (raumschiff.gibRaumschiff_ypos()
											+ raumschiff.gibRaumschiff_bild().getHeight()) <= (gegner_Array[i].gibypos()
													+ gegner_Array[i].getImage().getHeight()))) {
								System.out.println("Kolidiert hinten/unten am Raumschiff");
								gegner_Array[i].reset();
								schaden = gegner_Array[i].gibKollisionsSchaden();
								raumschiff.berechneSchaden(schaden, false);
							} else if (raumschiff
									.gibRaumschiff_ypos() <= (gegner_Array[i].gibypos()
											+ gegner_Array[i].getImage().getHeight())
									&& raumschiff.gibRaumschiff_ypos() >= gegner_Array[i].gibypos()) {
								System.out.println("Kolidiert hinten/oben am Raumschiff");
								gegner_Array[i].reset();
								schaden = gegner_Array[i].gibKollisionsSchaden();
								raumschiff.berechneSchaden(schaden, false);
							}
						}
						if (raumschiff.gibRaumschiff_xpos() < gegner_Array[i].gibxpos()
								&& (raumschiff.gibRaumschiff_xpos()
										+ raumschiff.gibRaumschiff_bild().getWidth()) > gegner_Array[i].gibxpos()
												+ gegner_Array[i].getImage().getWidth()
								&& raumschiff.gibRaumschiff_ypos()
										+ raumschiff.gibRaumschiff_bild().getHeight() > gegner_Array[i].gibypos()
								&& raumschiff.gibRaumschiff_ypos()
										+ raumschiff.gibRaumschiff_bild().getHeight() < gegner_Array[i].gibypos()
												+ gegner_Array[i].getImage().getHeight()) {
							System.out.println("Kolidiert unten am Raumschiff");
							gegner_Array[i].reset();
							schaden = gegner_Array[i].gibKollisionsSchaden();
							raumschiff.berechneSchaden(schaden, false);
						}
						if (raumschiff.gibRaumschiff_xpos() < gegner_Array[i].gibxpos()
								&& (raumschiff.gibRaumschiff_xpos()
										+ raumschiff.gibRaumschiff_bild().getWidth()) > gegner_Array[i].gibxpos()
												+ gegner_Array[i].getImage().getWidth()
								&& raumschiff.gibRaumschiff_ypos() < gegner_Array[i].gibypos()
										+ gegner_Array[i].getImage().getHeight()
								&& raumschiff.gibRaumschiff_ypos() > gegner_Array[i].gibypos()) {
							System.out.println("Kolidiert oben am Raumschiff");
							gegner_Array[i].reset();
							schaden = gegner_Array[i].gibKollisionsSchaden();
							raumschiff.berechneSchaden(schaden, false);
						}
					}
				}
			}

		}, 0, 80);
	}
}
