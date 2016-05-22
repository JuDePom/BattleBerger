package battleberger.model.player;

import battleberger.model.Game;
import battleberger.model.player.strategy.Strategy;
import battleberger.view.IDisplay;

public class Computer extends Player {
	
	protected Strategy strat;
	
	public Computer(){
		super(25);
	}

	@Override
	public Shot play(Game g) {
		return strat.fire(this, g);
	}
	

	@Override
	public void setState(Shot s, battleberger.model.Game.State st) {
		strat.setState(s, st);
	};
	
	@Override
	public void selectShips(IDisplay display) {
		ships = strat.selectShips(getMaxShipValue());
	}

	public void setStrat(Strategy s){
		strat = s;
	}
	
	public Strategy getStrat(){
		return strat;
	}
}
