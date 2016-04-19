package battleberger.model;

public abstract class AbstractShipyard {
	
	public static AbstractShip orderShip(){
		return new ShipyardDefault().buildShip();
	}
	
	public abstract AbstractShip buildShip();
}
