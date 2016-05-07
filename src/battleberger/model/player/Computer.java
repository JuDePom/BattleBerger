package battleberger.model.player;

import battleberger.model.Game;
import battleberger.model.player.strategy.IStrategy;

public class Computer extends Player {
	
	protected IStrategy strat;
	
	public Computer(IStrategy strat){
		super(20);
		this.strat = strat;
	}

	@Override
	public Shot play(Game g) {
		return strat.fire(this, g);
	}
	
	@Override
	public void selectShips() {
		ships = strat.selectShips(getMaxShipValue());
	}

	public void setStrat(IStrategy s){
		strat = s;
	}
	
	public IStrategy getStrat(){
		return strat;
	}
}
