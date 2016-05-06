package battleberger.model.player.strategy;

import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public interface IStrategy {
	
	
	
	Shot fire(Computer ai, Game g);
	
	List<AbstractShip> selectShips(int maxShipValue);
	
	

}
