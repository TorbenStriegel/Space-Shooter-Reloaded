package main_package;

public class Raumschiff_Level {
	
	private Raumschiff raumschiff;

	public Raumschiff_Level(int raumschiffTyp , Score score,Var var) {
		if (raumschiffTyp == 0){
			raumschiff = new Raumschiff_1(score,false,var);
		}else if (raumschiffTyp == 1){
			raumschiff = new Raumschiff_2(score,false,var);
		}else if (raumschiffTyp == 2){
			raumschiff = new Raumschiff_3(score,false,var);
		}else if (raumschiffTyp == 3){
			raumschiff = new Raumschiff_4(score,false,var);
		}
	}
	public Raumschiff gibRaumschiff(){
		return raumschiff;
	}
	
}
