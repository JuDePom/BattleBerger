package battleberger.model.player;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.view.IDisplay;

public class Human extends Player {

	@Override
	public Shot play(Game g) {
		return null;
		
	}
	
	public Human(){
		super(20);
	}

	@Override
	public void selectShips(IDisplay display) {
		while (getMaxShipValue() > 0){
			AbstractShip ship = display.selectShip(this);
			setMaxShipValue(getMaxShipValue() - ship.shipValue());
			ships.add(ship);
		}
		
		display.placeShips(ships);
	}
}
