package battleberger.model.player.strategy;

import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public class StrategyDiagonal extends IStrategy{

	int x, y, last_x, last_y, width, height;
	
	
	public StrategyDiagonal(int width, int height){
		x = 0;
		y = 0;
		last_x = 0;
		last_y = 0;
		this.width = width;
		this.height = height;
	}
	
	@Override
	public Shot fire(Computer ai, Game g) {
		x++;
		y++;
		
		if(x >= width){
			last_x++;
			if(last_x >= width){
				last_x = 0;
			}
			x = last_x;
		}
		if(y >= height){
			last_y++;
			if(last_y >= height){
				last_y = 0;
			}
			y = last_y;
		}
		
		return new Shot(ai.getBestShip().getFireshape(), x, y);
	}

	@Override
	public List<AbstractShip> selectShips(int maxShipValue) {
		return selectRandomShips(maxShipValue);
	}

	
	
}
