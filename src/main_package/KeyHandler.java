package main_package;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyHandler implements KeyListener{ //implementiere Interface um Klassen nicht selber schreiben zu müssen.
	private Var var;
	public KeyHandler(Var var) {
		// TODO Auto-generated constructor stub
		this.var=var;
	}
	
	@Override
	public void keyPressed(KeyEvent taste) {				//Setzt "true" wenn Taste gedrückt
		
		if(taste.getKeyCode() == KeyEvent.VK_UP){
			Var.moveup=true;
		}
		if(taste.getKeyCode() == KeyEvent.VK_DOWN){
			Var.movedown=true;
		}
		if(taste.getKeyCode() == KeyEvent.VK_LEFT){
			Var.moveleft=true;
		}
		if(taste.getKeyCode() == KeyEvent.VK_RIGHT){
			Var.moveright=true;
		}
		if(taste.getKeyCode() == KeyEvent.VK_SPACE){
			Var.space=true;
		}
		if(taste.getKeyCode() == KeyEvent.VK_ESCAPE){
			Var.esc=true;
			System.exit(0);
		}
	
	}

	@Override
	public void keyReleased(KeyEvent taste) {				//Setzt "false" wenn Taste losgelassen wird
		if(taste.getKeyCode() == KeyEvent.VK_UP){
			Var.moveup=false;
		}
		if(taste.getKeyCode() == KeyEvent.VK_DOWN){
			Var.movedown=false;
		}
		if(taste.getKeyCode() == KeyEvent.VK_LEFT){
			Var.moveleft=false;
		}
		if(taste.getKeyCode() == KeyEvent.VK_RIGHT){
			Var.moveright=false;
		}
		if(taste.getKeyCode() == KeyEvent.VK_SPACE){
			Var.space=false;
		}
		if(taste.getKeyCode() == KeyEvent.VK_ESCAPE){
			Var.esc=false;
		}
		if(taste.getKeyCode() == KeyEvent.VK_P){
			if(var.pause){
				var.startCounter=true;
			}else{
				var.pause=true;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) { //nicht benötigt
	}

}
