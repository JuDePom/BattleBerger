package battleberger.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import battleberger.model.player.Player;

public class Game extends Observable {

	List<Player> players;
	
	
	public Game(Player p1, Player p2){
		players = new ArrayList<>();
		players.add(p1);
		players.add(p2);
	}
	
	
	public void play(){
		boolean end = false;
		
		while( ! end ){
			
			for(Player p : players){
				p.play(this);
			}
			
		}
		
		
	}
	

}
