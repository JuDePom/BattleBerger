package battleberger.model.player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Game.State;
import battleberger.view.IDisplay;

public abstract class Player implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected List<AbstractShip> ships = new ArrayList<AbstractShip>();
	protected Game game;
	protected int maxShipValue;
	protected int money=1000;
	
	public Player(int maxShipValue){
		this.setMaxShipValue(maxShipValue);
		ships = new ArrayList<>();
	}
	
	
	public abstract Shot play(Game g);

	
	public Game getGame() {
		return game;
	}


	public void setShips(List<AbstractShip> ships) {
		this.ships = ships;
	}


	public void setMoney(int money) {
		this.money = money;
	}


	public void setState(Shot s, State st){}
	
	
	public AbstractShip getBestShip(){
		int best_val = Integer.MIN_VALUE;
		AbstractShip best= ships.get(0);
		for(AbstractShip ship: getShipsReady()){
			int sum = 0;
			for(int[] t : ship.getFireshape()){
				for(int b : t){
					sum += b * ship.getPower();
				}
			}
			if(sum > best_val){
				best_val = sum;
				best = ship;
			}
		}
		return best;
	}
	
	
	
	public int nbShips(){
		return ships.size();
	}
	
	public void remove(AbstractShip s){
		ships.remove(s);
	}
	
	public AbstractShip getShip(int s){
		return ships.get(s);
	}
	
	public List<AbstractShip> getShips(){
		return ships;
	}
	
	public List<AbstractShip> getShipsReady(){
		List<AbstractShip> ret = new ArrayList<>();
		for(AbstractShip s : ships){
			if(s.getTimereload() <= 0)
				ret.add(s);
		}
		return ret;
	}
	
	public void endOfTurnProcessing(){
		for(AbstractShip s : ships){
			s.endOfTurnProcessing();
		}
	}
	
	public abstract void selectShips(IDisplay display);
	

	public void setGame(Game g){
		game = g;
	}


	public int getMaxShipValue() {
		return maxShipValue;
	}


	public void setMaxShipValue(int maxShipValue) {
		this.maxShipValue = maxShipValue;
	}
	public void upgrade(AbstractShip upgrade,AbstractShip base){
		remove(base);
		ships.add(upgrade);
	}
	public int getMoney(){
		return money;
	}
	public void gainMoney(int potdevin){
		money+=potdevin;
	}
}
