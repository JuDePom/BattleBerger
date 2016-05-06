package battleberger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Timer;

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
		
		width = height = 20;
	}
	
	
	public void play(){

		display.selectGridDimension();
		
		for(Player p : players){
			p.selectShips();
		}
		
		long start;
		while( ! isEndOfGame() ){
			start = System.currentTimeMillis();
			for(Player p : players){
				Shot s = p.play(this);
				display.fire(p, s);
				
				if(isEndOfGame()) break;
			}
			
			display.updateGameGrid();
			
			waitfps(start);
		}
		
	}

	
	private void waitfps(long start){
		try {
			Thread.sleep((long) Math.max( 100./6 - (System.currentTimeMillis() - start), 0)); //on fait du 60 fps
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	private boolean isEndOfGame(){
		return false;
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


}
