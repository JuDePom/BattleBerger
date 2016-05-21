package battleberger.model;

import battleberger.model.AbstractShip.TimeSpace;
import battleberger.model.Ship.TypeShip;

public abstract class AbstractShipyard {
	private static TimeSpace ts=TimeSpace.SheepAge;
	
	
	public static AbstractShip orderShip(TypeShip type){
		switch(ts){
		case Default :
			return new ShipyardDefault().buildShip(type,0,0);	
		case MoyenAge :
			return new ShipyardMoyenAge().buildShip(type,0,0);
		case SheepAge :
			return new ShipyardSheepAge().buildShip(type,0,0);
		default :
			return new ShipyardDefault().buildShip(type,0,0);	
		}
	}
	
	
	public static void setTimeSpace(TimeSpace s){
		ts=s;
	}
	public static TimeSpace getTimeSpace(){
		return ts;
	}
	public abstract AbstractShip buildShip(TypeShip ship,int x, int y);
}
