package battleberger.model;

public class ShipyardDefault extends AbstractShipyard {
	@Override
	public AbstractShip buildShip() {
		return new ShipDefault();
	}
}
