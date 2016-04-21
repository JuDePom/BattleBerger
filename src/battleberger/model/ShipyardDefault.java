package battleberger.model;

import battleberger.model.AbstractShip.Orientation;
import battleberger.model.AbstractShip.TypeShip;

public class ShipyardDefault extends AbstractShipyard {
	@Override
	public AbstractShip buildShip(TypeShip ship) {
		return new ShipDefault(Orientation.North,0,0,"battleberger/texture");
	}
}
