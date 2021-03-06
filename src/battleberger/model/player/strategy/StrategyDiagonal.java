package battleberger.model.player.strategy;

import java.util.List;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public class StrategyDiagonal extends Strategy{

	int x, y, last_x, last_y;
	
	
	public StrategyDiagonal(){
		x = -1;
		y = -1;
		last_x = -1;
		last_y = -1;
	}
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLast_x() {
		return last_x;
	}
	public void setLast_x(int last_x) {
		this.last_x = last_x;
	}
	public int getLast_y() {
		return last_y;
	}
	public void setLast_y(int last_y) {
		this.last_y = last_y;
	}
	public boolean isDirection() {
		return direction;
	}
	public void setDirection(boolean direction) {
		this.direction = direction;
	}


	boolean direction = false;
	private int move(int x){
		return (direction) ? x-1 : x +1;
	}
	@Override
	public Shot fire(Computer ai, Game g) {
		x = move(x);
		y = move(y);
		if(x >= width || x <= 0){
			last_x++;
			if(last_x >= width){
				last_x = 0;
			}
			x = last_x;
		}
		if(y >= height || y <= 0){
			last_y++;
			if(last_y >= height){
				last_y = 0;
				direction = ! direction;
			}
			//y = last_y;
		}
		return new Shot( x, y, ai.getBestShip());
	}

	@Override
	public List<AbstractShip> selectShips(int maxShipValue) {
		return selectRandomShips(maxShipValue);
	}

	
	
	
	
}
