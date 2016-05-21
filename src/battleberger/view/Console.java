package battleberger.view;

import java.util.List;
import java.util.Scanner;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Human;
import battleberger.model.player.Player;
import battleberger.model.player.Shot;

public class Console implements IDisplay{


	private Scanner sc;
	private Game game;
	
	public Scanner getSc() {
		return sc;
	}

	public void setSc(Scanner sc) {
		this.sc = sc;
	}

	public Game getGame() {
		return game;
	}

	@Override
	public void updateGameGrid() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public AbstractShip selectShip(Player p){
		
		while(true){
			System.out.println("choisissez une position");
		
			System.out.println("x ?");
			int x = sc.nextInt();
			System.out.println("y ?");
			int y = sc.nextInt();
			for(AbstractShip s : p.getShips()){
				if(s.overlap(x,y)){
					return s;
				}
			}
			System.out.println("ce n'est pas un bateau");
		}
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

	@Override
	public void placeShips(List<AbstractShip> ships) {}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shot getShot(Human h) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}
}
