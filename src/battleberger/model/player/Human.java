package battleberger.model.player;

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
		ships = display.placeShips(getMaxShipValue());		
	}

	
	


}
