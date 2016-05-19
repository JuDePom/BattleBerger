package battleberger.model.player.strategy;

import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Game.State;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public class StrategyWithMemory extends IStrategy {

	State[][] states;
	public StrategyWithMemory() {
	}
	
	
	public void setDim(int width, int height){
		states = new State[width][height];
		for(int i = 0 ; i < width ; i++){
			for(int j = 0 ; j < height ; j++){
				states[i][j] = Game.State.nothing;
			}
		}
	}
	@Override
	public Shot fire(Computer ai, Game g) {
		for(int i = 0 ; i < states.length ; i++){
			for(int j = 0 ; j < states[0].length ; j++){
				State state = states[i][j];
				if(state == State.touched){
					return new Shot(ai.getBestShip().getFireshape(), i, j);
				}
			}
		}
		//si on est là on n'a touché aucun bateau
		for(int i = 0 ; i < states.length ; i++){
			for(int j = 0 ; j < states[0].length ; j++){
				State state = states[i][j];
				if(state == State.nothing){
					return new Shot(ai.getBestShip().getFireshape(), i, j);
				}
			}
		}
		return null;
	}

	@Override
	public List<AbstractShip> selectShips(int maxShipValue) {
		return selectRandomShips(maxShipValue);
	}

}
