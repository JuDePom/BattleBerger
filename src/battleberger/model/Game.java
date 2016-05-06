package battleberger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import battleberger.model.player.Player;
import battleberger.model.player.Shot;
import battleberger.view.IDisplay;

public class Game extends Observable {

	private List<Player> players;
	private int width, height;
	private IDisplay display;
	
	public Game(Player p1, Player p2, IDisplay disp){
		players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		display = disp;
		display.setGame(this);
	}
	
	
	public void play(){

		display.selectGridDimension();
		
		while( ! isEndOfGame() ){
			
			for(Player p : players){
				Shot s = p.play(this);
				display.fire(p, s);
			}
			
			display.updateGameGrid();
		}
	}


	
	private boolean isEndOfGame(){
		return false;
	}

	
	
	/**
	 * 
	 * @return un bateau si c'est un bateau du joueur, null sinon
	 */
	public AbstractShip selectShip(Player p){
		System.out.println("choisissez une position");
		System.out.println("x ?");
		int x = sc.nextInt();
		System.out.println("y ?");
		int y = sc.nextInt();
		for(AbstractShip s : p.getShips()){
			if(s.hovers(x,y)){
				return s;
			}
		}
		return null;
	}


	public List<Player> getPlayers() {
		return players;
	}


	public void setPlayers(List<Player> players) {
		this.players = players;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}



	
	
	public int getWorldWidth(){
		return 20;
	}
	
	public int getWorldHeight(){
		return 20;
	}

	public int getWorldSize() {
		return getWorldWidth() * getWorldHeight();
	}
	
	public List<Player> getPlayers(){
		return players;
	}
}
