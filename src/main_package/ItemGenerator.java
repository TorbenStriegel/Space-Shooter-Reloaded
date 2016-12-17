package main_package;

public class ItemGenerator {
public ItemGenerator(Raumschiff raumschiff,Var var,int anzahl,LevelTester tester) {

	for (int i = 0; i < anzahl; i++) {
		
		int y =(int)(Math.random()*15);
		if(y<=3){
		new Items_Leben(raumschiff,var);
		}else if(y<=6){
			new ItemSchuss(raumschiff, var);
		}else if(y<=9){
			new ItemSpeed(raumschiff, var);
		}else if(y<=12){
			new ItemSchild(raumschiff,var);
		}else {
			new ItemFreischalten(raumschiff, var, tester);
		}
	}
}	
	
}
      