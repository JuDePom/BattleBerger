package battleberger.model.player.strategy;

import java.util.List;
import java.util.Random;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.Game.State;
import battleberger.model.Square;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public class StrategyWithMemory extends IStrategy {

	State[][] states;
	public StrategyWithMemory() {
	}
	
	@Override
	public void setDim(int width, int height){
		super.setDim(width, height);
		states = new State[width][height];
		for(int i = 0 ; i < width ; i++){
			for(int j = 0 ; j < height ; j++){
				states[i][j] = Game.State.nothing;
			}
		}
	}
	
	

	@Override
	public void setState(Shot s, battleberger.model.Game.State st) {
		for(Square sq : s.getSquares().keySet()){
			if(sq.getX() >=0 && sq.getX() < width && sq.getY() >= 0 && sq.getY() < height)
				states[sq.getX()][sq.getY()] = st;
		}
	};
	
	
	@Override
	public Shot fire(Computer ai, Game g) {
		Random r = new Random();
		for(int i = 0 ; i < states.length ; i++){
			for(int j = 0 ; j < states[0].length ; j++){
				State state = states[i][j];
				if(state == State.touched){
					return new Shot(i + (r.nextInt(1)-1 )*r.nextInt(2) , j, ai.getBestShip());
				}
			}
		}
		//si on est là on n'a touché aucun bateau
		
		int x, y;
		do{
			x = r.nextInt(width);
			y = r.nextInt(height);
		}while(states[x][y] == State.sinked);
		return new Shot(x, y, ai.getBestShip());
	}

	@Override
	public List<AbstractShip> selectShips(int maxShipValue) {
		return selectRandomShips(maxShipValue);
	}

}
