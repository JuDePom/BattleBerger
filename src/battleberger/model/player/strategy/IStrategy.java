package battleberger.model.player.strategy;

import battleberger.model.World;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public interface IStrategy {
	
	Shot fire(Computer ai, World w);

}
