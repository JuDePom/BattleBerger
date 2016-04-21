package battleberger.model;

import battleberger.model.AbstractShip.Orientation;
import battleberger.model.AbstractShip.TypeShip;
import battleberger.model.ship.*;

public class ShipyardDefault extends AbstractShipyard {
	@Override
	public AbstractShip buildShip(TypeShip ship) {
		AbstractShip sheep;
		switch(ship){
		case ShipDefault :
			 sheep =new ShipDefault(Orientation.North,0,0,"battleberger/texture");
			 break;
		case Kevin :
			
			 default :
		sheep=null;		 
		}
		return sheep;
	}
}
