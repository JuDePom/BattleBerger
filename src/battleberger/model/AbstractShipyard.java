package battleberger.model;

import battleberger.model.AbstractShip.TypeShip;

public abstract class AbstractShipyard {
	
	public static AbstractShip orderShip(){
		return new ShipyardDefault().buildShip(TypeShip.DefaultShip);
	}
	
	public abstract AbstractShip buildShip(TypeShip ship);
}
