package battleberger.model;

import battleberger.model.Ship.TypeShip;

public abstract class AbstractShipyard {
	
	public static AbstractShip orderShip(){
		return new ShipyardDefault().buildShip(TypeShip.ShipDefault,0,0);
	}
	
	public abstract AbstractShip buildShip(TypeShip ship,int x, int y);
}
