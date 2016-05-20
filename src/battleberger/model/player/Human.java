package battleberger.model.player;

import battleberger.model.AbstractShip;
import battleberger.model.Game;
import battleberger.view.IDisplay;

public class Human extends Player {

	@Override
	public Shot play(Game g) {
		return g.getDisplay().getShot(this);
	}
	
	public Human(){
		super(100);
	}

	@Override
	public void selectShips(IDisplay display) {
		while (getMaxShipValue() > 0){
			AbstractShip ship = display.selectShip(this);
			setMaxShipValue(getMaxShipValue() - ship.shipValue());
			ships.add(ship);
			display.refresh();
		}
		
		display.placeShips(ships);
	}
}
