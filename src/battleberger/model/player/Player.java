package battleberger.model.player;

import java.util.ArrayList;
import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.Game;

public abstract class Player {
	
	protected List<AbstractShip> ships = new ArrayList<AbstractShip>();
	protected Game game;
	protected int maxShipValue;
	
	public Player(int maxShipValue){
		this.setMaxShipValue(maxShipValue);
		ships = new ArrayList<>();
	}
	
	
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
	
	public abstract void selectShips();
	

	public void setGame(Game g){
		game = g;
	}


	public int getMaxShipValue() {
		return maxShipValue;
	}


	public void setMaxShipValue(int maxShipValue) {
		this.maxShipValue = maxShipValue;
	}
	
}
