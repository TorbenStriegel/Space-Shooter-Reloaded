package main_package;

public class Gegner_Level {

	private Gegner[] gegner;
	private Spieltimer spieltimer;
	private int level = 0;
	private Var var;

	public Gegner_Level(int level,Var var) {
		this.var =var;
		this.level = level;
		switch (level) {
		case 0:
			starteLevel1();
			break;
		case 1:
			starteLevel1();
			break;
		case 2:
			starteLevel2();
			break;
		case 3:
			starteLevel3();
			break;
		case 4:
			starteLevel4();
			break;
		case 5:
			starteLevel5();
			break;
		case 6:
			starteLevel6();
			break;
		case 7:
			starteLevel7();
			break;
		case 8:
			starteLevel8();
			break;
		case 9:
			starteLevel9();
			break;
		case 10:
			starteLevel10();
			break;
		case 11:
			starteLevel11();
			break;
		case 12:
			starteLevel12();
			break;

		default:
			break;
		}
	}
	private void starteLevel1() {
		Var.anzahlGegner = 80;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length; a++) {
			gegner[a] = new Gegner_1(var);
		}
		spieltimer = new Spieltimer(60,var);
	}

	private void starteLevel2() {
		Var.anzahlGegner = 40;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length; a++) {
			gegner[a] = new Gegner_2(var);
		}
		spieltimer = new Spieltimer(60,var);
	}

	private void starteLevel3() {
		Var.anzahlGegner = 60;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length - 10; a++) {
			gegner[a] = new Gegner_1(var);
		}
		for (int a = 30; a < gegner.length; a++) {
			gegner[a] = new Gegner_2(var);
		}
		spieltimer = new Spieltimer(90,var);
	}

	private void starteLevel4() {
		Var.anzahlGegner = 55;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length - 30; a++) {
			gegner[a] = new Gegner_1(var);
		}
		for (int a = 25; a < gegner.length - 5; a++) {
			gegner[a] = new Gegner_2(var);
		}
		for (int a = 50; a < gegner.length; a++) {
<<<<<<< HEAD
			gegner[a] = new Gegner_8(var);
=======
			gegner[a] = new Gegner_3();
>>>>>>> 71b81ab1edbb93783e96afc87e94ad0cdba6c246
		}
		spieltimer = new Spieltimer(90,var);
	}

	private void starteLevel5() {
		Var.anzahlGegner = 35;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length - 25; a++) {
			gegner[a] = new Gegner_1(var);
		}
		for (int a = 10; a < gegner.length; a++) {
			gegner[a] = new Gegner_3(var);
		}
		spieltimer = new Spieltimer(90,var);
	}

	private void starteLevel6() {
		Var.anzahlGegner = 60;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length-50; a++) {
			gegner[a] = new Gegner_3(var);
		}
		for (int a = 10; a < gegner.length-30; a++) {
			gegner[a] = new Gegner_2(var);
		}
		for (int a = 30; a < gegner.length; a++) {
			gegner[a] = new Gegner_1(var);
		}
		spieltimer = new Spieltimer(90,var);
	}
	
	private void starteLevel7() {
		Var.anzahlGegner = 50;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length-30; a++) {
			gegner[a] = new Gegner_3(var);
		}
		for (int a = 20; a < gegner.length-10; a++) {
			gegner[a] = new Gegner_2(var);
		}
		for (int a = 40; a < gegner.length; a++) {
			gegner[a] = new Gegner_1(var);
		}
		spieltimer = new Spieltimer(120,var);
	}
	
	private void starteLevel8() {
		Var.anzahlGegner = 50;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length-45; a++) {
			gegner[a] = new Gegner_3(var);
		}
		for (int a = 5; a < gegner.length-40; a++) {
			gegner[a] = new Gegner_4(var);
		}
		for (int a = 10; a < gegner.length-20; a++) {
			gegner[a] = new Gegner_2(var);
		}
		for (int a = 30; a < gegner.length; a++) {
			gegner[a] = new Gegner_1(var);
		}
		spieltimer = new Spieltimer(120,var);
	}
	
	private void starteLevel9() {
		Var.anzahlGegner = 40;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length-37; a++) {
			gegner[a] = new Gegner_5(var);
		}
		for (int a = 3; a < gegner.length-30; a++) {
			gegner[a] = new Gegner_4(var);
		}
		for (int a = 10; a < gegner.length-10; a++) {
			gegner[a] = new Gegner_2(var);
		}
		for (int a = 30; a < gegner.length; a++) {
			gegner[a] = new Gegner_3(var);
		}
		spieltimer = new Spieltimer(120,var);
	}
	
	private void starteLevel10() {
		Var.anzahlGegner = 20;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length-17; a++) {
			gegner[a] = new Gegner_5(var);
		}for (int a = 3; a < gegner.length-15; a++) {
			gegner[a] = new Gegner_6(var);
		}for (int a = 5; a < gegner.length-5; a++) {
			gegner[a] = new Gegner_4(var);
		}for (int a = 15; a < gegner.length; a++) {
			gegner[a] = new Gegner_3(var);
		}
		spieltimer = new Spieltimer(120,var);
	}
	
	private void starteLevel11() {
		Var.anzahlGegner = 30;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length-24; a++) {
			gegner[a] = new Gegner_5(var);
		}for (int a = 6; a < gegner.length-20; a++) {
			gegner[a] = new Gegner_6(var);
		}for (int a = 10; a < gegner.length-10; a++) {
			gegner[a] = new Gegner_4(var);
		}for (int a = 20; a < gegner.length; a++) {
			gegner[a] = new Gegner_2(var);
		}
		spieltimer = new Spieltimer(120,var);
	}
	
	private void starteLevel12() {
		Var.anzahlGegner = 1;
		gegner = new Gegner[Var.anzahlGegner];
		for (int a = 0; a < gegner.length; a++) {
			gegner[a] = new Gegner_7(var);
		}
		spieltimer = new Spieltimer(120,var);
	}

	public int getLevel() {
		return level;
	}

	public Gegner[] getGegner_Array() {
		return gegner;
	}
	public Spieltimer getSpieltimer() {
		return spieltimer;
	}

}
