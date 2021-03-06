package battleberger.model.player.strategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipyard;
import battleberger.model.Game;
import battleberger.model.Ship.Orientation;
import battleberger.model.Ship.TypeShip;
import battleberger.model.player.Computer;
import battleberger.model.player.Shot;

public abstract class Strategy implements Serializable{
	
	int width, height;
	public abstract Shot fire(Computer ai, Game g);
	
	public abstract List<AbstractShip> selectShips(int maxShipValue);
	
	public void setDim(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setState(Shot s, battleberger.model.Game.State st) {
		
	}

	public List<AbstractShip> selectRandomShips(int maxShipValue){
		List<AbstractShip> ships = new ArrayList<>();
		Random r = new Random();
		int disp = maxShipValue;
		TypeShip[] s = TypeShip.values();
		while(disp > 0 ){
			AbstractShip ship = AbstractShipyard.orderShip(s[r.nextInt(s.length)]);
			Orientation orient = Orientation.values()[r.nextInt(Orientation.values().length)];
			ship.setOrient(orient);
			if(disp - ship.shipValue() >= 0){	
				
				boolean[][] shape = ship.getShape();
				boolean end;
				do{
					int x = r.nextInt(Game.getWidth() - shape.length),
						y = r.nextInt(Game.getHeight() - shape[0].length);
					ship.setPositionX(x);
					ship.setPositionY(y);
					end = true;
					for(int i = 0 ;i < shape.length ; i++){
						for(int j = 0 ; j < shape[0].length ; j++){
							if(shape[i][j]){
								for(AbstractShip sship : ships){
									if(sship.overlap(x + i, y + j)){
										end = false;
										break;
									}
								}
							}
							if(!end) break;
						}
						if(!end) break;
					}
					
				}while(! end);
				
				disp -= ship.shipValue();
				ships.add(ship);
			}
		}
		return ships;
	}
	
}
