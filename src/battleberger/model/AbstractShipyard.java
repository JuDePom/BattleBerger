package battleberger.model;

import battleberger.model.Ship.TypeShip;

public abstract class AbstractShipyard {
	
	public static AbstractShip orderShip(TypeShip type){
		return new ShipyardDefault().buildShip(type,-1,-1);
	}
	
	public abstract AbstractShip buildShip(TypeShip ship,int x, int y);
}
