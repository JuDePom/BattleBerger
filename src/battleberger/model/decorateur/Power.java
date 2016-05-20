package battleberger.model.decorateur;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipDecorator;
import battleberger.model.Ship.StatType;

public class Power extends AbstractShipDecorator{
	public Power(AbstractShip ship){
		next=ship;
		name="Armor";
		costUpgrade=10;
		if(ship!=null)
		ship.addUpgrade(StatType.Power);
	}
	@Override
	public int getPower() {		
		return 1+next.getPower();
	}
}
