package battleberger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;

import battleberger.model.player.Player;
import battleberger.model.player.Shot;

public class Game extends Observable {

	private List<Player> players;
	private int width, height;
	private Scanner sc;
	
	
	public Game(Player p1, Player p2){
		players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
		sc = new Scanner(System.in);
	}
	
	
	public void play(){
		boolean end = false;
		selectGrid();
		while( ! end ){
			
			for(Player p : players){
				Shot s = p.play(this);
				System.out.println("player :" + p.toString() + " plays: " + s.toString() );
				
			}
			
		}
		
		
	}
	
	public void selectGrid(){
		System.out.println("largeur ?");
		width = sc.nextInt();
		System.out.println("hauteur ?");
		height = sc.nextInt();
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



	
	
	
	
}
