package battleberger.model.decorateur;

import battleberger.model.AbstractAbstractShip;
import battleberger.model.AbstractShipDecorator;

public class MovSpeed extends AbstractShipDecorator{

	public MovSpeed(AbstractAbstractShip ship){
		next=ship;
		name="MovSpeed";
	}
	@Override
	public int getMovSpeed() {		
		return 1+next.getMovSpeed();
	}
}
