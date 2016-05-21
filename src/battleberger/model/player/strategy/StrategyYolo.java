package battleberger.model.player.strategy;

import java.util.List;
import java.util.Random;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public class StrategyYolo extends IStrategy {

	
	
	@Override
	public Shot fire(Computer ai, Game g) {
		Random r = new Random();
		AbstractShip s = ai.getShipsReady().get(r.nextInt(ai.getShipsReady().size()));
		int y = r.nextInt(Game.getHeight());
		int x = r.nextInt(Game.getWidth());
		Shot sh = new Shot(x, y, s);
		return sh;
	}


	@Override
	public List<AbstractShip> selectShips(int maxShipValue) {
		return selectRandomShips(maxShipValue);
	}
	
	
	

}
