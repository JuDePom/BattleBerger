package battleberger.model.player;

import battleberger.model.World;
import battleberger.model.player.strategy.IStrategy;

public class Computer extends Player {
	
	protected IStrategy strat;
	
	public Computer(IStrategy strat){
		this.strat = strat;
	}

	@Override
	public Shot play(World w) {
		return strat.fire(this, w);
	}
	
	
	public void setStrat(IStrategy s){
		strat = s;
	}
	
	public IStrategy getStrat(){
		return strat;
	}

	
	
	

}
