package battleberger.view;

import java.util.Scanner;

import battleberger.model.Game;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;

public class Console implements IDisplay{

	private Scanner sc;
	private Game game;
	
	@Override
	public void updateGameGrid() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	@Override
	public void fire(Player p, Shot s) {
		System.out.println("player :" + p.toString() + " plays: " + s.toString() );	
	}




	@Override
	public void setGame(Game g){
		game = g;
		sc = new Scanner(System.in);
	}

	@Override
	public void selectGridDimension(){
		System.out.println("largeur ?");
		game.setWidth(sc.nextInt());
		System.out.println("hauteur ?");
		game.setHeight(sc.nextInt());
	}
	
}
