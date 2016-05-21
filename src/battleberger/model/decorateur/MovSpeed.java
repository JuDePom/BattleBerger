package battleberger.model.decorateur;

import battleberger.model.AbstractShip;
import battleberger.model.AbstractShipDecorator;
import battleberger.model.Ship.StatType;

public class MovSpeed extends AbstractShipDecorator{

	public MovSpeed(AbstractShip ship){
		next=ship;
		name="MovSpeed";
		costUpgrade=10;
		if(ship!=null)
		ship.addUpgrade(StatType.MovSpeed);
	}
	@Override
	public int getMovSpeed() {		
		return next.getMovSpeed();
	}
}
