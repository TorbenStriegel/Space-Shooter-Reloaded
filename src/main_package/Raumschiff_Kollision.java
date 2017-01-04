package main_package;

import java.util.Timer;
import java.util.TimerTask;

public class Raumschiff_Kollision {

	private Timer timer;
	private Raumschiff raumschiff;
	private int schaden = 0;

	public Raumschiff_Kollision(Raumschiff raumschiff,Var var) {
		this.raumschiff = raumschiff;
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if (!var.verloren && !var.pause) {
					for (int i = 0; i < var.getGegnerArray().length; i++) {
						if ((raumschiff.gibRaumschiff_xpos()
								+ raumschiff.gibRaumschiff_bild().getWidth()) >= (var.getGegnerArray()[i].gibxpos())
								&& (raumschiff.gibRaumschiff_xpos()
										+ raumschiff.gibRaumschiff_bild().getWidth()) <= (var.getGegnerArray()[i].gibxpos()
												+ var.getGegnerArray()[i].getImage().getWidth())) {
							if ((raumschiff.gibRaumschiff_ypos() <= var.getGegnerArray()[i].gibypos())
									&& (raumschiff.gibRaumschiff_ypos()
											+ raumschiff.gibRaumschiff_bild().getHeight()) >= (var.getGegnerArray()[i].gibypos()
													+ var.getGegnerArray()[i].getImage().getHeight())) {
								System.out.println("Kolidiert vorne/zentral auf das Raumschiff");
								var.getGegnerArray()[i].reset();
								schaden = var.getGegnerArray()[i].gibKollisionsSchaden() * 2;
								raumschiff.berechneSchaden(schaden, true);
							} else if (((raumschiff.gibRaumschiff_ypos()
									+ raumschiff.gibRaumschiff_bild().getHeight()) >= var.getGegnerArray()[i].gibypos()
									&& (raumschiff.gibRaumschiff_ypos()
											+ raumschiff.gibRaumschiff_bild().getHeight()) <= (var.getGegnerArray()[i].gibypos()
													+ var.getGegnerArray()[i].getImage().getHeight()))) {
								System.out.println("Kolidiert vorne/unten am Raumschiff");
								var.getGegnerArray()[i].reset();
								schaden = var.getGegnerArray()[i].gibKollisionsSchaden();
								raumschiff.berechneSchaden(schaden, true);
							} else if (raumschiff
									.gibRaumschiff_ypos() <= (var.getGegnerArray()[i].gibypos()
											+ var.getGegnerArray()[i].getImage().getHeight())
									&& raumschiff.gibRaumschiff_ypos() >= var.getGegnerArray()[i].gibypos()) {
								System.out.println("Kolidiert vorne/oben am Raumschiff");
								var.getGegnerArray()[i].reset();
								schaden = var.getGegnerArray()[i].gibKollisionsSchaden();
								raumschiff.berechneSchaden(schaden, true);
							}
						}
						if ((raumschiff.gibRaumschiff_xpos()) >= (var.getGegnerArray()[i].gibxpos())
								&& (raumschiff.gibRaumschiff_xpos()) <= (var.getGegnerArray()[i].gibxpos()
										+ var.getGegnerArray()[i].getImage().getWidth())) {
							if ((raumschiff.gibRaumschiff_ypos() <= var.getGegnerArray()[i].gibypos())
									&& (raumschiff.gibRaumschiff_ypos()
											+ raumschiff.gibRaumschiff_bild().getHeight()) >= (var.getGegnerArray()[i].gibypos()
													+ var.getGegnerArray()[i].getImage().getHeight())) {
								System.out.println("Kolidiert hinten/zentral auf das Raumschiff");
								var.getGegnerArray()[i].reset();
								schaden = var.getGegnerArray()[i].gibKollisionsSchaden() * 2;
								raumschiff.berechneSchaden(schaden, false);
							} else if (((raumschiff.gibRaumschiff_ypos()
									+ raumschiff.gibRaumschiff_bild().getHeight()) >= var.getGegnerArray()[i].gibypos()
									&& (raumschiff.gibRaumschiff_ypos()
											+ raumschiff.gibRaumschiff_bild().getHeight()) <= (var.getGegnerArray()[i].gibypos()
													+ var.getGegnerArray()[i].getImage().getHeight()))) {
								System.out.println("Kolidiert hinten/unten am Raumschiff");
								var.getGegnerArray()[i].reset();
								schaden = var.getGegnerArray()[i].gibKollisionsSchaden();
								raumschiff.berechneSchaden(schaden, false);
							} else if (raumschiff
									.gibRaumschiff_ypos() <= (var.getGegnerArray()[i].gibypos()
											+ var.getGegnerArray()[i].getImage().getHeight())
									&& raumschiff.gibRaumschiff_ypos() >= var.getGegnerArray()[i].gibypos()) {
								System.out.println("Kolidiert hinten/oben am Raumschiff");
								var.getGegnerArray()[i].reset();
								schaden = var.getGegnerArray()[i].gibKollisionsSchaden();
								raumschiff.berechneSchaden(schaden, false);
							}
						}
						if (raumschiff.gibRaumschiff_xpos() < var.getGegnerArray()[i].gibxpos()
								&& (raumschiff.gibRaumschiff_xpos()
										+ raumschiff.gibRaumschiff_bild().getWidth()) > var.getGegnerArray()[i].gibxpos()
												+ var.getGegnerArray()[i].getImage().getWidth()
								&& raumschiff.gibRaumschiff_ypos()
										+ raumschiff.gibRaumschiff_bild().getHeight() > var.getGegnerArray()[i].gibypos()
								&& raumschiff.gibRaumschiff_ypos()
										+ raumschiff.gibRaumschiff_bild().getHeight() < var.getGegnerArray()[i].gibypos()
												+ var.getGegnerArray()[i].getImage().getHeight()) {
							System.out.println("Kolidiert unten am Raumschiff");
							var.getGegnerArray()[i].reset();
							schaden = var.getGegnerArray()[i].gibKollisionsSchaden();
							raumschiff.berechneSchaden(schaden, false);
						}
						if (raumschiff.gibRaumschiff_xpos() < var.getGegnerArray()[i].gibxpos()
								&& (raumschiff.gibRaumschiff_xpos()
										+ raumschiff.gibRaumschiff_bild().getWidth()) > var.getGegnerArray()[i].gibxpos()
												+ var.getGegnerArray()[i].getImage().getWidth()
								&& raumschiff.gibRaumschiff_ypos() < var.getGegnerArray()[i].gibypos()
										+ var.getGegnerArray()[i].getImage().getHeight()
								&& raumschiff.gibRaumschiff_ypos() > var.getGegnerArray()[i].gibypos()) {
							System.out.println("Kolidiert oben am Raumschiff");
							var.getGegnerArray()[i].reset();
							schaden = var.getGegnerArray()[i].gibKollisionsSchaden();
							raumschiff.berechneSchaden(schaden, false);
						}
					}
				}
			}

		}, 0, 80);
	}
}
