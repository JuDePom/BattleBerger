package battleberger.model.player.strategy;

import java.util.Random;

import battleberger.model.World;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public class StrategyYolo implements IStrategy {

	@Override
	public Shot fire(Computer ai, World w) {
		Random r = new Random();
		ai.getShip(r.nextInt(ai.nbShips()));
		r.nextInt(w.getWorldSize());
		
		return Shot;
	}

}
