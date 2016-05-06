package battleberger.model.player.strategy;

import java.util.Random;

import battleberger.model.Game;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public class StrategyYolo implements IStrategy {

	@Override
	public Shot fire(Computer ai, Game g) {
		Random r = new Random();
		ai.getShip(r.nextInt(ai.nbShips()));
		r.nextInt(g.getHeight());
		Shot s = new Shot();
		//TODO
		//need le shape toussa	toussa
		return s;
	}

}
