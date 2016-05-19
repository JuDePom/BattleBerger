package battleberger.model.decorateur;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipDecorator;

public class Power extends AbstractShipDecorator{
	public Power(AbstractShip ship){
		next=ship;
		name="Armor";
		cost=10;
	}
	@Override
	public int getPower() {		
		return 1+next.getPower();
	}
}
