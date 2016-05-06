package battleberger.model.player;

import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.Game;

public abstract class Player {
	
	private List<AbstractShip> ships;
	
	public abstract Shot play(Game g);

	
	public int nbShips(){
		return ships.size();
	}
	
	public AbstractShip getShip(int s){
		return ships.get(s);
	}
	
	public List<AbstractShip> getShips(){
		return ships;
	}
	

}
